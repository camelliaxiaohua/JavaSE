# DataOutputStream
`DataOutputStream` 是 Java 中的一个类，它属于 `java.io` 包，主要用于写出 Java 原始数据类型的值到一个输出流。
这个类是字节流的一部分，通常用于以平台无关的方式写出基本数据类型（如 `int`、`long`、`float`、`double`、`boolean`、`char` 等）的数据。

>1. 对于将数据写入到输出流并且需要恢复这些数据，通常使用 DataOutputStream 和 DataInputStream 配合使用。
> DataOutputStream 用于将各种数据类型以二进制格式写入到输出流，而 DataInputStream 用于从输入流中读取这些二进制格式的数据。
>2. 效率高。


## 一、构造函数
| 构造函数                                 | 描述                         |
|--------------------------------------|----------------------------|
| `DataOutputStream(OutputStream out)` | 创建一个新的数据输出流，将数据写入指定的基础输出流。 |

## 二、方法

| 修饰符          | 方法                                  | 描述                                                                              |
|--------------|-------------------------------------|---------------------------------------------------------------------------------|
| `void`       | `flush()`                           | 刷新此数据输出流。                                                                       |
| `final int`  | `size()`                            | 返回计数器的当前值，`written`，即迄今为止写入此数据输出流的字节数。                                          |
| `void`       | `write(byte[] b, int off, int len)` | 将从偏移量开始的指定字节数组中的字节写入底层输出流。                                                      |
| `void`       | `write(int b)`                      | 将指定的字节（参数的低八位 b）写入基础输出流。                                                        |
| `final void` | `writeBoolean(boolean v)`           | 将布尔值作为 1 字节值写入基础输出流。                                                            |
| `final void` | `writeByte(int v)`                  | 将一个字节作为 1 字节值写入基础输出流。                                                           |
| `final void` | `writeBytes(String s)`              | 将字符串作为字节序列写入底层输出流。                                                              |
| `final void` | `writeChar(int v)`                  | 将一个字符作为 2 字节值写入基础输出流，先写入高字节。                                                    |
| `final void` | `writeChars(String s)`              | 将字符串作为字符序列写入基础输出流。                                                              |
| `final void` | `writeDouble(double v)`             | 使用 `doubleToLongBits` 方法将双精度浮点数转换为 `long`，然后将该 `long` 值作为 8 字节数量（高字节优先）写入基础输出流。 |
| `final void` | `writeFloat(float v)`               | 使用 `floatToIntBits` 方法将浮点数转换为 `int`，然后将该 `int` 值作为 4 字节数量（高字节优先）写入基础输出流。        |
| `final void` | `writeInt(int v)`                   | 将一个整数作为四个字节写入基础输出流，先写入高字节。                                                      |
| `final void` | `writeLong(long v)`                 | 将一个长整数以八个字节的形式写入基础输出流，先写高字节。                                                    |
| `final void` | `writeShort(int v)`                 | 将一个短整数作为两个字节写入基础输出流，先写高字节。                                                      |
| `final void` | `writeUTF(String str)`              | 以与机器无关的方式使用修改后的 UTF-8 编码将字符串写入底层输出流。                                            |

## 三、示例代码

```java
package com.camellia.io.DataOutputStream;

import org.junit.jupiter.api.Test;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示了如何使用DataOutputStream将各种Java数据类型写入到文件中。
 *
 * <p>DataOutputStream是一个数据字节输出流，允许将Java程序中的数据直接写入文件，以二进制格式存储。
 * DataOutputStream写数据的效率很高，因为写的过程中不需要进行转码。
 * 需要注意的是，用DataOutputStream写入的数据只能由DataInputStream来读取。</p>
 */
public class DataOutputStreamTest {

    /**
     * 测试DataOutputStream的写入功能，将各种基本数据类型写入文件。
     */
    @Test
    public void testDataOutputStreamWrite() {
        // 使用try-with-resources语句确保DataOutputStream在使用完毕后被正确关闭
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/document/data"))) {
            // 准备数据
            byte b = -127;
            short s = 32767;
            int i = 2147483647;
            long l = 1111111111L;
            float f = 3.0F;
            double d = 3.14;
            boolean flag = false;
            char c = 'A';
            String str = "Camellia.XIAOHUA";

            // 写入数据
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(flag);
            dos.writeChar(c);
            dos.writeUTF(str);

            // 刷新流，确保所有数据都被写入
            dos.flush();
        } catch (FileNotFoundException e) {
            // 处理文件未找到异常
            e.printStackTrace();
        } catch (IOException e) {
            // 处理IO异常
            e.printStackTrace();
        }
    }
}

```