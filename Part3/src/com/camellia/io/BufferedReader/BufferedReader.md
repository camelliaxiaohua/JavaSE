# BufferedReader

## 一、构造函数

| 构造函数                                | 描述                       |
|-------------------------------------|--------------------------|
| `BufferedReader(Reader in)`         | 创建一个使用默认大小输入缓冲区的缓冲字符输入流。 |
| `BufferedReader(Reader in, int sz)` | 创建一个使用指定大小输入缓冲区的缓冲字符输入流。 |

## 二、常用方法

| 修饰符和类型         | 方法                                    | 描述                                    |
|----------------|---------------------------------------|---------------------------------------|
| void           | `close()`                             | 关闭流并释放相关的系统资源。                        |
| Stream<String> | `lines()`                             | 返回一个流，其中包含从缓冲字符输入流读取的每一行文本。           |
| void           | `mark(int readAheadLimit)`            | 标记当前位置，使得可以稍后返回到此点。                   |
| boolean        | `markSupported()`                     | 检查流是否支持标记（`mark`）和重置（`reset`）操作。      |
| int            | `read()`                              | 读取下一个字符。如果没有更多数据，则返回 -1。              |
| int            | `read(char[] cbuf, int off, int len)` | 从流中读取字符到指定的字符数组中，从指定位置开始，最多读取指定数量的字符。 |
| String         | `readLine()`                          | 读取一整行文本，包括行尾的换行符。如果到达文件末尾，则返回 `null`。 |
| boolean        | `ready()`                             | 检查流是否准备好进行读取操作，即是否有数据可供读取。            |
| void           | `reset()`                             | 重置流的位置到最近的 `mark()` 标记处，允许重新读取之前的内容。  |


## 三、代码示例

```java
package com.camellia.io.BufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 带有缓冲区的字符输入流。
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Part3/src/document/滕王阁序.txt"))){
            int readCount = 0;
            char[] chars = new char[1024];
            while ((readCount = br.read(chars)) != -1){
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
