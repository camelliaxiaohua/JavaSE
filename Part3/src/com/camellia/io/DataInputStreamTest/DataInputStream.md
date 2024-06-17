# DataInputStream
`DataInputStream` 是 Java 中用于从底层输入流读取 Java 数据类型数据的类。
它属于 java.io 包，提供了一系列方法，用于读取各种原始数据类型的数据，如 int、float、double、char、boolean 等。
`DataInputStream` 通常与 `DataOutputStream` 配合使用，以确保数据在写入和读取时具有一致的格式。

>在读取数据时，应确保数据的读取顺序与写入顺序一致。
## 一、构造函数
| 构造函数                              | 描述                                            |
|-----------------------------------|-----------------------------------------------|
| `DataInputStream(InputStream in)` | 创建一个使用指定底层 `InputStream` 的 `DataInputStream`。 |

## 二、方法

| 修饰符和类型                | 方法                                      | 描述                                                           |
|-----------------------|-----------------------------------------|--------------------------------------------------------------|
| `final int`           | `read(byte[] b)`                        | 从包含的输入流读取一些字节并将它们存储到缓冲区数组中 `b`。                              |
| `final int`           | `read(byte[] b, int off, int len)`      | 从包含的输入流中读取最多 `len` 字节的数据到字节数组中。                              |
| `final boolean`       | `readBoolean()`                         | 读取一个布尔值。                                                     |
| `final byte`          | `readByte()`                            | 读取一个字节。                                                      |
| `final char`          | `readChar()`                            | 读取一个字符。                                                      |
| `final double`        | `readDouble()`                          | 读取一个双精度浮点数。                                                  |
| `final float`         | `readFloat()`                           | 读取一个单精度浮点数。                                                  |
| `final void`          | `readFully(byte[] b)`                   | 读取字节数组 `b` 的数据。                                              |
| `final void`          | `readFully(byte[] b, int off, int len)` | 读取指定偏移量 `off` 和长度 `len` 的字节数组。                               |
| `final int`           | `readInt()`                             | 读取一个整数。                                                      |
| `final String`        | `readLine()`                            | 已弃用。此方法不能正确地将字节转换为字符。                                        |
| `final long`          | `readLong()`                            | 读取一个长整数。                                                     |
| `final short`         | `readShort()`                           | 读取一个短整数。                                                     |
| `final int`           | `readUnsignedByte()`                    | 读取一个无符号字节。                                                   |
| `final int`           | `readUnsignedShort()`                   | 读取一个无符号短整数。                                                  |
| `final String`        | `readUTF()`                             | 读取一个以 UTF-8 编码的字符串。                                          |
| `static final String` | `readUTF(DataInput in)`                 | 从流中读取以修改版 UTF-8 格式编码的 Unicode 字符串表示形式，然后以 `String` 形式返回该字符串。 |
| `final int`           | `skipBytes(int n)`                      | 跳过输入流中的 `n` 个字节。                                             |

## 三、示例代码
```java
package com.camellia.io.DataInputStreamTest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 演示如何使用DataInputStream读取使用DataOutputStream写入的文件。
 *
 * <p>java.io.DataInputStream是数据字节输入流，用于读取DataOutputStream写入的数据。
 * 注意：读取的顺序必须与写入的顺序一致，否则数据无法正确恢复。</p>
 */
public class DataInputStreamTest {

    public static void main(String[] args) {
        // 使用try-with-resources语句创建DataInputStream对象，确保在使用完毕后自动关闭流
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Part3/src/document/data"))) {
            // 开始读取数据
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            long l = dis.readLong();
            float f = dis.readFloat();
            double d = dis.readDouble();
            boolean flag = dis.readBoolean();
            char c = dis.readChar();
            String str = dis.readUTF();

            // 打印读取到的数据
            System.out.println("Byte: " + b);
            System.out.println("Short: " + s);
            System.out.println("Int: " + i);
            System.out.println("Long: " + l);
            System.out.println("Float: " + f);
            System.out.println("Double: " + d);
            System.out.println("Boolean: " + flag);
            System.out.println("Char: " + c);
            System.out.println("UTF String: " + str);

        } catch (IOException e) {
            // 捕获并处理IO异常
            e.printStackTrace();
        }
    }
}

```