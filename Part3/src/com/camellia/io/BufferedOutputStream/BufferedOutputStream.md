---
title: BufferedOutputStream字节输出缓冲流
date: 2024-06-17 11:50:58
tags:
categories:
- Java SE
---

!!! note 目录
<!-- toc -->

# BufferedOutputStream字节输出缓冲流

`BufferedOutputStream` 是 Java 标准库中的一个类，属于 `java.io` 包，用于为输出流添加缓冲功能，从而提高写入效率。
通过使用缓冲区，可以减少对底层输出流的访问次数，从而提高性能。



## 一、`BufferedOutputStream` 的主要特点和功能

1. **缓冲区**：`BufferedOutputStream` 使用内部缓冲区来暂存要写入的数据，<u>默认缓冲区大小为 8192 字节</u>（8 KB）。你可以通过构造函数指定不同大小的缓冲区。
2. **提高写入效率**：由于减少了对底层输出流的访问次数（例如磁盘或网络），因此可以显著提高写入操作的效率。
3. **减少I/O操作次数**：通过将多个写入操作合并成一个大块写入操作，可以减少实际的I/O操作次数，从而提升性能。

## 二、构造方法

| 构造函数                                               | 描述                                    |
|----------------------------------------------------|---------------------------------------|
| `BufferedOutputStream(OutputStream out)`           | 创建一个新的缓冲输出流，以将数据写入指定的基础输出流。           |
| `BufferedOutputStream(OutputStream out, int size)` | 创建一个新的缓冲输出流，以使用指定的缓冲区大小将数据写入指定的基础输出流。 |

> [!NOTE]
>
> 同理，BufferedOutputStream也是个包装类，包装对应的字节节点输出流。



## 三、常用方法

| 修饰符和类型 | 方法                                  | 描述                                        |
|--------|-------------------------------------|-------------------------------------------|
| void   | `flush()`                           | 刷新此缓冲输出流，将缓冲区中的数据写入基础输出流。                 |
| void   | `write(byte[] b, int off, int len)` | 将指定字节数组中从偏移量 `off` 开始的 `len` 个字节写入此缓冲输出流。 |
| void   | `write(int b)`                      | 将指定的字节写入此缓冲输出流。                           |

## 四、代码示例

```java
package com.camellia.io.BufferedOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1. java.io.BufferedOutputStream也是一个缓冲流。属于输出流。
 * 2. 怎么创建BufferedOutputStream对象？
 *      BufferedOutputStream(OutputStream out)
 * 3. FileOutputStream是节点流。 BufferedOutputStream是包装流。
 */
public class BufferedOutputStreamTest {
    @Test
    public void BufferedOutputStreamRead(){
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/document/out_english.txt"))){
            bos.write("重剑无锋，大巧无工！".getBytes());
            //刷新
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //这里采用try-with-resources关闭资源。若使用try-catch-finally关闭则和BufferedInputStream一样。
}

```