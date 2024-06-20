# ByteArrayInputStream和ByteArrayOutputStream

`ByteArrayInputStream`和`ByteArrayOutputStream`是Java中用于处理字节数据的流类，这些类位于`java.io`包中。
它们主要用于在内存中读取和写入字节数据，不涉及实际的文件I/O操作。
这使得它们非常适合在处理数据时临时存储数据，例如在进行数据传输或转换时。

## 一、ByteArrayInputStream

`ByteArrayInputStream`是一个字节输入流，用于从字节数组读取数据。它允许你将字节数组作为输入源，将字节数据读入程序中。

**主要特点**：
- **从字节数组读取数据**：你可以从一个字节数组中读取数据，而不需要从文件或网络流中读取。
- **方便数据处理**：在进行数据处理或转换时，首先可以将数据加载到一个字节数组中，然后使用`ByteArrayInputStream`来读取这些数据。
- **限制**：一旦创建了`ByteArrayInputStream`对象，其内部使用的字节数组大小是固定的，并且在`ByteArrayInputStream`对象生命周期内，这个数组不会自动扩展。

**构造方法**：
```java
public ByteArrayInputStream(byte[] buf)
```
此构造方法创建一个新的`ByteArrayInputStream`，用于读取指定字节数组。

**使用示例**：
```java
byte[] data = { 1, 2, 3, 4, 5 };
ByteArrayInputStream bais = new ByteArrayInputStream(data);
int byteData;
while ((byteData = bais.read()) != -1) {
    System.out.print(byteData + " ");
}
bais.close();
```

## 二、ByteArrayOutputStream

`ByteArrayOutputStream`是一个字节输出流，用于在内存中生成字节数据。你可以使用它来将数据写入到一个字节数组中，这些数据随后可以被读取、处理或传输。

**主要特点**：
- **生成字节数组**：可以用来生成字节数据的临时存储区，通常用于数据转换、序列化等场景。
- **动态扩展**：`ByteArrayOutputStream`的内部字节数组大小会根据需要动态增长，因此不需要事先指定数组的大小。
- **与其他流结合使用**：常与其他流结合使用，例如通过`ObjectOutputStream`来序列化对象。

**构造方法**：
```java
public ByteArrayOutputStream()
```
此构造方法创建一个新的`ByteArrayOutputStream`对象，其内部字节数组的初始大小为默认值（通常是32字节）。

**使用示例**：
```java
ByteArrayOutputStream baos = new ByteArrayOutputStream();
baos.write(65);  // 写入一个字节
baos.write(66);  // 写入另一个字节
byte[] data = baos.toByteArray();  // 获取所有写入的数据
System.out.println(new String(data));  // 输出结果 "AB"
baos.close();
```

## 三、示例代码

```java
package com.camellia.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;

/**
 * 本类展示了如何使用`ByteArrayOutputStream`和`ByteArrayInputStream`进行内存中的字节流操作。
 * 还演示了如何使用装饰器设计模式中的包装流`ObjectOutputStream`和`ObjectInputStream`。
 */
public class ByteArrayOutputInputStreamTest {

    /**
     * 演示了`ByteArrayOutputStream`的基本用法。
     * 创建一个`ByteArrayOutputStream`实例，写入一些字节数据，然后读取这些数据。
     */
    @Test
    public void testByteArrayOutputStream(){
        // 创建一个ByteArrayOutputStream实例
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 向流中写入字节数据
        baos.write(97); // 写入字符'a'的ASCII值
        baos.write(98); // 写入字符'b'的ASCII值
        baos.write(99); // 写入字符'c'的ASCII值

        // 获取ByteArrayOutputStream中的字节数组
        byte[] byteArray = baos.toByteArray();

        // 输出每个字节的值
        for(byte b : byteArray){
            System.out.println(b);
        }
    }

    /**
     * 演示了装饰器设计模式的应用，使用`ObjectOutputStream`和`ByteArrayOutputStream`进行对象的序列化。
     * 通过`ByteArrayInputStream`和`ObjectInputStream`来反序列化这些对象。
     */
    @Test
    public void testWrapByteArrayOutputInputStream(){
        // 不用关闭流，因为真正的流是ByteArrayOutputStream。
        // 使用了包装流就需要刷新
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
            // 开始写
            oos.writeObject(new Date());
            oos.writeInt(100);
            oos.writeBoolean(true);
            oos.writeUTF("Camellia.xiaohua");
            // 包装流需要手动刷新
            oos.flush();
            byte[] bytes = baos.toByteArray();
            // 使用ByteArrayInputStream将上面这个byte数组恢复。
            // 读的过程，读内存中的大byte数组。
            // 节点流
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            // 包装流
            ObjectInputStream ois = new ObjectInputStream(bais);

            // 开始读,写和读顺序要一样。
            System.out.println(ois.readObject());
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

```