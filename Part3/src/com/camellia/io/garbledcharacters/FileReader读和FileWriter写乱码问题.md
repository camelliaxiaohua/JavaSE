# FileReader读和FileWriter写乱码问题
1. 节点流（Node Streams）
   - 节点流直接与数据源或数据目的地（如文件、内存、网络连接等）相连接，进行数据的读写操作。它们是真正执行IO操作的流。
2. 包装流（Processing Streams）
   包装流用于包装节点流或其他包装流，以提供附加功能，如缓冲、数据转换等。它们通过装饰模式增强了节点流的功能。

## 一、为什么FileReader读和FileWriter写会出现乱码？

在Java中，`FileReader`和`FileWriter`主要用于读取和写入文本文件。它们的工作方式是基于平台默认的字符编码。
这可能会导致在某些情况下出现乱码问题，尤其是在处理非ASCII字符或跨平台操作时。

### 1.1 出现乱码的原因主要有以下几个：

1. **字符编码不一致**：
    - 如果文件的编码与`FileReader`和`FileWriter`默认使用的编码不同，就会出现乱码。例如，如果文件是用UTF-8编码写入的，而`FileReader`使用的是系统默认的编码（如Windows上的GBK或ISO-8859-1），读取时就会出现乱码。

2. **跨平台编码差异**：
    - 不同操作系统的默认编码不同。例如，Windows系统通常默认使用GBK编码，而Linux系统通常默认使用UTF-8编码。如果在Windows上创建的文件在Linux上读取，或者反过来，而没有显式指定编码，就会出现乱码。

### 1.2 图解

![](E:\Learn\asserts\Io读写乱码.png)

## 二、如何解决FileReader读和FileWriter写出现的乱码问题？

为了避免乱码问题，可以显式指定字符编码。推荐使用`InputStreamReader`和`OutputStreamWriter`，它们允许指定字符编码。
![](E:\Learn\asserts\img_1.png)

### 2.1 InputStreamReader
`InputStreamReader`是一个字符流类，它将字节输入流转换为字符输入流。其主要功能是读取字节数据并将其解码为字符数据。
- 构造方法：
   - `InputStreamReader(InputStream in)`: 使用**平台默认字符**集创建InputStreamReader。 
   - `InputStreamReader(InputStream in, String charsetName)`: 使用**指定字符集**创建InputStreamReader。

### 2.2 OutputStreamWriter
`OutputStreamWriter`是一个字符流类，它将字符输出流转换为字节输出流。其主要功能是将字符数据编码为字节数据并写入输出流。
- 构造方法：
   - `OutputStreamWriter(OutputStream out)`: 使用**平台默认**字符集创建OutputStreamWriter。
   - `OutputStreamWriter(OutputStream out, String charsetName)`: 使用**指定字符集**创建OutputStreamWriter。

### 2.3 读取文件时指定编码
```java
package com.camellia.io.garbledcharacters;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * InputStreamReader 是一个字符流转换器，用于将字节流解码为字符流。
 * 它通过指定的字符编码将输入的字节流解码为字符数据。
 *
 * 常用的构造方法：
 *   InputStreamReader(InputStream in) 使用平台默认的字符集进行解码。
 *   InputStreamReader(InputStream in, String charsetName) 使用指定的字符集进行解码。
 *
 * FileReader 实际上是 InputStreamReader 的子类，是一个包装流而非节点流。
 */
public class InputStreamReaderDecodingTest {

    /**
     * 测试使用 InputStreamReader 读取 GBK 编码的文件。
     * 使用指定的字符集（GBK）解码文件内容并输出到控制台。
     */
    @Test
    public void testInputStreamReaderDecoding() {
        // 创建一个 InputStreamReader 对象，指定使用 GBK 字符集进行解码
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("src/document/GBK滕王阁序.txt"), "GBK")) {
            // 文件采用了 GBK 编码方式存储，所以在解码的时候要指定对应的解码方法
            int readCount;
            char[] chars = new char[1024];
            while ((readCount = isr.read(chars)) != -1) {
                // 将读取到的字符数组转换为字符串并输出
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试使用 FileReader 读取 GBK 编码的文件。
     * 使用指定的字符集（GBK）解码文件内容并输出到控制台。
     */
    @Test
    public void testFileReaderDecoding() {
        // 创建一个 FileReader 对象，指定使用 GBK 字符集进行解码
        try (FileReader isr = new FileReader("src/document/GBK滕王阁序.txt", Charset.forName("GBK"))) {
            // 文件采用了 GBK 编码方式存储，所以在解码的时候要指定对应的解码方法
            int readCount;
            char[] chars = new char[1024];
            while ((readCount = isr.read(chars)) != -1) {
                // 将读取到的字符数组转换为字符串并输出
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

### 2.3 写入文件时指定编码
```java
package com.camellia.io.garbledcharacters;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 这个类演示了使用OutputStreamWriter和FileWriter以GBK编码将文本写入文件。
 *
 * <p>OutputStreamWriter 是一个字符流，也是一个转换流。它将字符编码成字节并写入输出流。
 * 如果OutputStreamWriter在编码过程中使用的字符集与文件的字符集不一致，可能会导致乱码。
 * FileWriter 是 OutputStreamWriter 的子类，简化了将字符写入文件的过程。</p>
 *
 * <p>注意：FileWriter是一个包装流，而不是节点流。它封装了一个FileOutputStream来实现其功能。</p>
 */
public class OutputStreamWriterEncodingTest {

    /**
     * 使用OutputStreamWriter以GBK编码将文本写入文件。
     * 此方法将文本写入文件，覆盖文件中的现有内容。
     */
    @Test
    public void testOutputStreamWriterEncoding() {
        // 创建一个使用GBK编码的OutputStreamWriter
        // 注意：以下代码中输出流以覆盖的方式写入文件
        try (OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("src/document/GBK滕王阁序out.txt", false), Charset.forName("GBK"))) {
            osw.write("花有从开日，人无再少年。");
            // 刷新流，确保所有数据被写入
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileWriter以GBK编码将文本写入文件。
     * 此方法将文本写入文件，覆盖文件中的现有内容。
     */
    @Test
    public void testFileWriterEncoding() {
        // 创建一个使用GBK编码的FileWriter
        // 注意：以下代码中输出流以覆盖的方式写入文件
        try (FileWriter fw = new FileWriter(
                "src/document/GBK滕王阁序out.txt", Charset.forName("GBK"), false)) {
            fw.write("花有从开日，人无再少年。");
            // 刷新流，确保所有数据被写入
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```