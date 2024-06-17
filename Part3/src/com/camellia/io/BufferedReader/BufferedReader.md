# BufferedReader字符输入缓冲流

`BufferedReader` 是 Java 标准库中的一个类，属于 `java.io` 包，用于为字符输入流添加缓冲功能，从而提高读取效率。
它提供了方便的方法来读取文本数据，尤其是读取整行文本。

## 一、`BufferedReader` 的主要特点和功能

1. **缓冲区**：`BufferedReader` 使用内部缓冲区来暂存读取的数据，默认缓冲区大小为 8192 个字符（16 KB）。你可以通过构造函数指定不同大小的缓冲区。
2. **提高读取效率**：通过减少对底层输入流的访问次数（例如磁盘或网络），可以显著提高读取操作的效率。
3. **读取整行**：提供了方便的 `readLine()` 方法，可以读取整行文本，直至遇到行结束符。
4. **支持标记和重置**：支持对流进行标记和重置操作，方便在读取过程中回退到先前的位置。

## 二、构造函数

| 构造函数                                | 描述                       |
|-------------------------------------|--------------------------|
| `BufferedReader(Reader in)`         | 创建一个使用默认大小输入缓冲区的缓冲字符输入流。 |
| `BufferedReader(Reader in, int sz)` | 创建一个使用指定大小输入缓冲区的缓冲字符输入流。 |

## 三、常用方法

| 修饰符和类型         | 方法                                    | 描述                                                                           |
|----------------|---------------------------------------|------------------------------------------------------------------------------|
| void           | `close()`                             | 关闭流并释放相关的系统资源。                                                               |
| Stream<String> | `lines()`                             | 返回一个流，其中包含从缓冲字符输入流读取的每一行文本。                                                  |
| void           | `mark(int readAheadLimit)`            | 标记当前位置，使得可以稍后返回到此点。读取的数据量不能超过 mark 方法的参数 readAheadLimit。如果读取的数据超过这个限制，标记将失效。 |
| boolean        | `markSupported()`                     | 检查流是否支持标记（`mark`）和重置（`reset`）操作。                                             |
| int            | `read()`                              | 读取下一个字符。如果没有更多数据，则返回 -1。                                                     |
| int            | `read(char[] cbuf, int off, int len)` | 从流中读取字符到指定的字符数组中，从指定位置开始，最多读取指定数量的字符。                                        |
| String         | `readLine()`                          | 读取一整行文本，包括行尾的换行符。如果到达文件末尾，则返回 `null`。                                        |
| boolean        | `ready()`                             | 检查流是否准备好进行读取操作，即是否有数据可供读取。                                                   |
| void           | `reset()`                             | 重置流的位置到最近的 `mark()` 标记处，允许重新读取之前的内容。                                         |


## 四、代码示例

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

```java
/**
     * BufferedReader/BufferedInputStream的两个方法：
     *      1. mark方法：在当前的位置上打标记
     *      2. reset方法：回到上一次打标记的位置
     *
     *      这两个方法的调用顺序是：先调用mark，再调用reset。
     *      这两个方法组合起来完成的任务是：某段内容重复读取。
     */
    @Test
    public void testBufferedMark(){
        // 创建带有缓冲区的字符输入流（一般把BufferedReader叫做处理流/包装流）
        try(BufferedReader br = new BufferedReader(new FileReader("src/document/滕王阁序.txt"))){
            System.out.println(br.markSupported());
            int readChar=0;
            while ((readChar = br.read()) != -1){
                if(((char) readChar)=='尔')br.mark(1024); 
                System.out.print(((char) readChar));
            }
            br.reset();
            while ((readChar = br.read()) != -1){
                if(((char) readChar)=='尔')br.mark(0); //随便写，在jdk21无实际意义。
                System.out.print(((char) readChar));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```