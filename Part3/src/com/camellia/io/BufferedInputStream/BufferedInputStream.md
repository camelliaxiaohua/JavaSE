---
title: BufferedInputStream字节输入缓冲流
date: 2024-06-17 11:21:54
tags:
categories:
- Java SE
---

!!! note 目录
<!-- toc -->

# BufferedInputStream字节输入缓冲流

BufferedInputStream 是 Java 标准库中的一个类，属于 java.io 包，用于为输入流添加缓冲功能，从而提高读取效率。
通过使用缓冲区，可以减少对底层输入流的访问次数，从而提高性能。

## 一、BufferedInputStream 的主要特点和功能

1. 缓冲区：BufferedInputStream 使用内部缓冲区来暂存读取的数据，<u>默认缓冲区大小为 8192 字节</u>（8 KB）。
   你可以通过构造函数指定不同大小的缓冲区。
2. 提高读取效率：由于减少了对底层输入流的访问次数（例如磁盘或网络），因此可以显著提高读取操作的效率。
3. **<u>支持标记和重置</u>**：BufferedInputStream 支持对流进行标记和重置操作，方便在读取过程中回退到先前的位置。

## 二、BufferedInputStream构造方法

| 构造函数                                              | 描述                                                           |
|---------------------------------------------------|--------------------------------------------------------------|
| * `BufferedInputStream(InputStream in)`           | 创建 `BufferedInputStream` 并保存其参数，即输入流 `in`，以供日后使用。            |
| * `BufferedInputStream(InputStream in, int size)` | 创建 `BufferedInputStream` 具有指定缓冲区大小的，并保存其参数（输入流） `in`，以供日后使用。 |

> [!NOTE]
>
> 从构造方法可以看出BufferedInputStream是包装流，可以包装对应的字节节点流。



## 三、BufferedInputStream常用方法

| 修饰符和类型  | 方法                                   | 描述                                                                                              |
|---------|--------------------------------------|-------------------------------------------------------------------------------------------------|
| int     | `available()`                        | 返回可以从输入流中读取的字节数，不会阻塞下次对输入流的读取。                                                                  |
| void    | * `close()`                          | 关闭输入流并释放与流相关的所有系统资源。                                                                            |
| void    | * `mark(int readlimit)`              | 在输入流中标记当前位置，以便以后使用 `reset()` 方法恢复到此位置。读取的数据量不能超过 mark 方法的参数 readAheadLimit。如果读取的数据超过这个限制，标记将失效。 |
| boolean | `markSupported()`                    | 检查输入流是否支持 `mark` 和 `reset` 方法。                                                                  |
| int     | * `read()`                           | 从输入流中读取一个字节并返回。                                                                                 |
| int     | * `read(byte[] b, int off, int len)` | 从输入流中读取最多 `len` 个字节，并将其存储到字节数组 `b` 的偏移量 `off` 位置开始。                                             |
| void    | * `reset()`                          | 将输入流恢复到上次调用 `mark()` 方法时的位置。                                                                    |
| long    | `skip(long n)`                       | 跳过并丢弃输入流中的 `n` 个字节。                                                                             |


## 四、示例代码

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
