# BufferedWriter字符输出缓冲流

`BufferedWriter` 是 Java 标准库中的一个类，属于 `java.io` 包，用于为字符输出流添加缓冲功能，从而提高写入效率。
通过使用缓冲区，可以减少对底层输出流的访问次数，从而提高性能。

## 一、`BufferedWriter` 的主要特点和功能

1. **缓冲区**：`BufferedWriter` 使用内部缓冲区来暂存写入的数据，默认缓冲区大小为 8192 个字符（16 KB）。你可以通过构造函数指定不同大小的缓冲区。
2. **提高写入效率**：由于减少了对底层输出流的访问次数（例如磁盘或网络），因此可以显著提高写入操作的效率。
3. **写入新行**：提供了方便的 `newLine()` 方法，可以写入系统默认的行分隔符。
4. **自动刷新**：可以通过调用 `flush()` 方法将缓冲区中的数据立即写入到输出流。


## 二、构造方法

| 构造函数                                 | 描述                            |
|--------------------------------------|-------------------------------|
| `BufferedWriter(Writer out)`         | 创建一个使用默认大小的输出缓冲区的缓冲字符输出流。     |
| `BufferedWriter(Writer out, int sz)` | 创建一个新的缓冲字符输出流，该流使用指定大小的输出缓冲区。 |


## 三、常用方法

| 修饰符和类型 | 方法                                     | 描述                                           |
|--------|----------------------------------------|----------------------------------------------|
| void   | `close()`                              | 关闭流并确保所有缓冲区中的内容都被刷新到输出目标，例如文件或其他输出流。         |
| void   | `flush()`                              | 强制将缓冲区中的所有数据立即写入到输出设备，以确保所有数据都被持久化存储。        |
| void   | `newLine()`                            | 写入一个行分隔符，使得输出继续在新的一行上，从而便于格式化文本。             |
| void   | `write(char[] cbuf, int off, int len)` | 从字符数组 `cbuf` 的指定位置 `off` 开始，写入 `len` 个字符到流中。 |
| void   | `write(int c)`                         | 将单个字符 `c` 写入到流中。                             |
| void   | `write(String s, int off, int len)`    | 从字符串 `s` 的指定位置 `off` 开始，写入 `len` 个字符到流中。     |


## 四、示例代码

```java
package com.camellia.io.BufferedWriter;

import java.io.*;

public class BufferedInputOutStream {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Part3/src/document/滕王阁序.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Part3/src/document/out_滕王阁序.txt"))){
            //开始读（br.readLine()方法每次读取一行，如果读取不到任何数据，则返回null。）
            String s = null;
            while ((s = br.readLine()) != null){
                bw.write(s);
                System.out.println(s);
            }
            //刷新
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```