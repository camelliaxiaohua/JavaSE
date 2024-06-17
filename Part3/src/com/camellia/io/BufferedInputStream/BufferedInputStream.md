# BufferedInputStream

## 一、BufferedInputStream构造方法

| 构造函数                                            | 描述                                                           |
|-------------------------------------------------|--------------------------------------------------------------|
| `BufferedInputStream(InputStream in)`           | 创建 `BufferedInputStream` 并保存其参数，即输入流 `in`，以供日后使用。            |
| `BufferedInputStream(InputStream in, int size)` | 创建 `BufferedInputStream` 具有指定缓冲区大小的，并保存其参数（输入流） `in`，以供日后使用。 |


## 二、BufferedInputStream常用方法

| 修饰符和类型  | 方法                                 | 描述                                                  |
|---------|------------------------------------|-----------------------------------------------------|
| int     | `available()`                      | 返回可以从输入流中读取的字节数，不会阻塞下次对输入流的读取。                      |
| void    | `close()`                          | 关闭输入流并释放与流相关的所有系统资源。                                |
| void    | `mark(int readlimit)`              | 在输入流中标记当前位置，以便以后使用 `reset()` 方法恢复到此位置。              |
| boolean | `markSupported()`                  | 检查输入流是否支持 `mark` 和 `reset` 方法。                      |
| int     | `read()`                           | 从输入流中读取一个字节并返回。                                     |
| int     | `read(byte[] b, int off, int len)` | 从输入流中读取最多 `len` 个字节，并将其存储到字节数组 `b` 的偏移量 `off` 位置开始。 |
| void    | `reset()`                          | 将输入流恢复到上次调用 `mark()` 方法时的位置。                        |
| long    | `skip(long n)`                     | 跳过并丢弃输入流中的 `n` 个字节。                                 |


## 三、示例代码

```java
package com.camellia.io.BufferedInputStream;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1. java.io.BufferedInputStream的用法和FileInputStream用法相同。<br>
 *
 * 2. 他们的不同点是：<br>
 *      FileInputStream是节点流。<br>
 *      BufferedInputStream是缓冲流(包装流/处理流)。
 *      这个流的效率高。自带缓冲区。并且自己维护这个缓冲区。读大文件的时候建议采用这个缓冲流来读取。<br>
 * 3. BufferedInputStream对 FileInputStream 进行了功能增强。增加了一个缓冲区的功能。<br>
 *
 * 4. 怎么创建一个BufferedInputStream对象呢？构造方法：<br>
 *      BufferedInputStream(InputStream in)
 */
public class BufferedInputStreamTest {
    @Test
    public void testBufferedInputStreamRead(){
        BufferedInputStream bis = null;
        try{
            //创建节点流和包装流
            bis = new BufferedInputStream(new FileInputStream("src/document/english.txt"));
            //读，和FileInputStream完全一样。
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bis.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if(bis != null){
               try {
                   bis.close();
                   //关闭BufferedInputStream即可，包装流的底层会调用节点流的close方法。
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }


}
```
