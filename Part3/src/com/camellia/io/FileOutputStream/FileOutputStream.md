---
title: FileOutputStream
date: 2024-06-16 22:21:28
tags:
categories:
- Java SE



---

!!! note 目录
<!-- toc -->

# FileOutputStream
`Java FileOutputStream` 是一个用于输出到文件的<u>字节流</u>类。
它属于 `java.io` 包，主要用于向文件中写入数据。
使用` FileOutputStream `时，你可以将字节数据写入文件中，这些数据可以是从程序中生成的，也可以是从其他数据源读取的。

> 注意：输出的时候需要手动刷新

## 一、构造方法

| 构造函数                                              | 描述                                                                                                |
|---------------------------------------------------|---------------------------------------------------------------------------------------------------|
| * `FileOutputStream(File file)`                   | 创建一个文件输出流来写入指定 `File` 对象所表示的文件。                                                                   |
| `FileOutputStream(FileDescriptor fdObj)`          | 创建一个文件输出流来写入指定的文件描述符，该描述符表示与文件系统中实际文件的现有连接。                                                       |
| * `FileOutputStream(File file, boolean append)`   | 创建一个文件输出流来写入指定 `File` 对象所表示的文件，并指定是否在文件末尾追加数据。                                                    |
| * `FileOutputStream(String name)`                 | 用于创建一个文件字节输出流对象，通过该对象可以向指定路径的文件中写入数据。如果指定的文件不存在，会尝试创建一个新文件；如果文件已经存在，则新数据会覆盖原有文件内容。                |
| * `FileOutputStream(String name, boolean append)` | 创建一个文件字节输出流对象，允许你控制文件写入的行为。如果 `append` 为 `true`，新数据会追加到文件末尾；如果 `append` 为 `false`，新数据会覆盖文件中的现有内容。 |

## 二、常用方法

| 修饰符和类型                 | 方法                                    | 描述                               |
|------------------------|---------------------------------------|----------------------------------|
| `void`                 | * `close()`                           | 关闭此文件输出流并释放与此流相关的所有系统资源。         |
| `FileChannel`          | `getChannel()`                        | 返回与此文件输出流关联的唯一对象。                |
| `final FileDescriptor` | `getFD()`                             | 返回与此流关联的文件描述符。                   |
| `void`                 | * `write(byte[] b)`                   | 将 `b.length` 指定字节数组中的字节写入此文件输出流。 |
| `void`                 | * `write(byte[] b, int off, int len)` | 从偏移量开始的指定字节数组中的字节写入此文件输出流。       |
| `void`                 | * `write(int b)`                      | 将指定的字节写入此文件输出流。                  |



## 三、示例代码



```java
package com.camellia.io.FileOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    //创建文件字节输出流对象
    private FileOutputStream out = null;

    /**
     * 以数组形式输出指定的多个字节。
     */
    @Test
    public void testFileOutputStreamMethods() {
        try {
            String s = "E:/Learn/JavaSE/File/outfile1.txt";
            init(s);
            //输出
            byte[] bytes = "Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune.".getBytes();
            out.write(bytes);
            //注意：刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * write()输出单个字节
     */
    @Test
    public void testFileOutputStreamWrite() {
        try {
            String s = "E:/Learn/JavaSE/File/outfile1.txt";
            init(s);
            //输出
            out.write(97);
            out.write(98);
            out.write(99);
            //注意：刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 创建一个文件输出流对象
     * @param address 写文件地址
     */
    public void init(String address) {
        try {
            //这里会覆盖文件内容，传参数true就不会覆盖。
            out = new FileOutputStream(address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭文件输出流
     */
    public void close() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

```

