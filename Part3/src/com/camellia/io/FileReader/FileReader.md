# FileReader

`FileReader` 是 Java 中用于读取文件内容的类，**继承**自 `InputStreamReader`，属于 `java.io` 包。
它提供了从文件中读取字符数据的功能，适用于处理文本文件。

## 一、FileReader构造函数

| 构造函数                                           | 描述                                                  |
|------------------------------------------------|-----------------------------------------------------|
| `FileReader(String fileName)`                  | 创建一个新的`FileReader`，给定要读取的文件的名称，使用默认的字符集。            |
| `FileReader(String fileName, Charset charset)` | 创建一个新的`FileReader`，给定要读取的文件的名称和字符集。                 |
| `FileReader(File file)`                        | 创建一个新的`FileReader`，给定`File`要读取的，使用默认的字符集。           |
| `FileReader(FileDescriptor fd)`                | 创建一个新的`FileReader`，给定`FileDescriptor`要读取的，使用默认的字符集。 |
| `FileReader(File file, Charset charset)`       | 创建一个新的`FileReader`，给定`File`要读取的和字符集。                |

## 二、FileReader常用方法

> FileReader extends InputStreamReader
> 所以方法参考父类InputStreamReader

| 方法                                  | 描述                              |
|-------------------------------------|---------------------------------|
| read()                              | 读取单个字符。                         |
| read(char[] cbuf)                   | 读取字符到数组中。                       |
| read(char[] cbuf, int off, int len) | 读取字符到数组的指定位置和长度。                |
| skip(long n)                        | 跳过和丢弃n个字符。                      |
| ready()                             | 判断流是否准备好被读取。                    |
| close()                             | 关闭流并释放与之关联的资源。                  |
| mark(int readAheadLimit)            | 标记流中的当前位置，以便后续调用reset()恢复到这个位置。 |
| reset()                             | 将流重置到最后标记的位置。                   |
| markSupported()                     | 判断流是否支持mark()操作。                |


## 三、代码示例

```java
package com.camellia.io.FileReader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符输入流测试类。
 * 提供两种方式读取文件内容：逐字符读取和逐块读取。
 */
public class FileReaderTest {

    /**
     * 测试逐字符读取文件内容的方法。
     * 读取文件 "filechar1.txt" 并打印每个字符。
     */
    @Test
    public void testFileReaderReadChar() {
        // 使用 try-with-resources 确保 FileReader 在使用后自动关闭
        try (FileReader reader = new FileReader("E:\\Learn\\JavaSE\\File\\filechar1.txt")) {
            int readChar;
            // 循环读取文件的每个字符，直到文件结束
            while ((readChar = reader.read()) != -1) {
                System.out.print((char) readChar); // 将读取到的字符打印到控制台
            }
        } catch (FileNotFoundException e) {
            // 文件未找到时打印堆栈跟踪信息
            e.printStackTrace();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }

    /**
     * 测试逐块读取文件内容的方法。
     * 读取文件 "filechar1.txt" 并打印读取到的字符块。
     */
    @Test
    public void testFileReaderReadChars() {
        // 使用 try-with-resources 确保 FileReader 在使用后自动关闭
        try (FileReader reader = new FileReader("E:\\Learn\\JavaSE\\File\\filechar1.txt")) {
            int readCount;
            char[] chars = new char[512]; // 定义字符数组作为缓冲区
            // 循环读取文件的字符块，直到文件结束
            while ((readCount = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount)); // 将读取到的字符块转换为字符串并打印
            }
        } catch (FileNotFoundException e) {
            // 文件未找到时打印堆栈跟踪信息
            e.printStackTrace();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }
}

```


