---
title: FileInputStream
date: 2024-06-16 22:19:53
tags:
categories:
- Java SE



---

!!! note 目录
<!-- toc -->

# FileInputStream
FileInputStream 是 Java 中用于从文件中读取<u>字节流</u>的类。
它是 InputStream 类的一个子类，提供了一种方便的方法来读取文件内容。

## 一、构造方法

| 构造函数                                | 描述                                                         |
| --------------------------------------- | ------------------------------------------------------------ |
| * `FileInputStream(File file)`          | 通过打开与实际文件的连接来创建，该文件由文件系统中的 `File` 对象命名。 |
| `FileInputStream(FileDescriptor fdObj)` | 使用文件描述符 `fdObj` 创建 `FileInputStream`，它代表与文件系统中实际文件的现有连接。 |
| * `FileInputStream(String name)`        | 通过打开与实际文件的连接来创建，该文件由 `name` 文件系统中的路径名命名。 |

## 二、常用方法

| 修饰符类型             | 方法                                 | 描述                                                         |
| ---------------------- | ------------------------------------ | ------------------------------------------------------------ |
| `int`                  | *`available()`                       | 返回可从此输入流读取（或跳过）的剩余字节数估计值，而这个读取过程不会导致程序等待（即不会阻塞）。 |
| `void`                 | * `close()`                          | 关闭此文件输入流并释放与该流相关的所有系统资源。             |
| `int`                  | * `read()`                           | 从该输入流读取一个字节的数据。                               |
| `int`                  | * `read(byte[] b)`                   | 从此输入流读取最多 `b.length` 字节的数据到字节数组中。       |
| `int`                  | * `read(byte[] b, int off, int len)` | 从此输入流读取最多 `len` 字节的数据到字节数组中。            |
| `long`                 | * `skip(long n)`                     | 跳过并丢弃输入流中的 `n` 字节数据。                          |
| `FileChannel`          | `getChannel()`                       | 返回与此文件输入流关联的唯一对象。                           |
| `final FileDescriptor` | `getFD()`                            | 返回代表 `FileDescriptor` 与此正在使用的文件系统中实际文件的连接的对象。 |

## 三、测试代码

```java
package com.camellia.io.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    private static InputStream in = null;

    /**
     * int read() 从该输入流读取一个字节的数据。
     */
    @Test
    public void testFileInputStreamRead() {
        try {
            // String s = "\"E:\\Learn\\JavaSE\\File\\file.txt\"";  这种写法需要两个//;
            String s = "E:/Learn/JavaSE/File/file.txt";
            init(s);
            //循环输出
            int readByte = 0;
            while ((readByte = in.read()) != -1) {
                System.out.print(readByte + "\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * int read(byte[] b) 从此输入流读取最多b.length字节的数据到字节数组中。 <br>
     * int read(byte[] b, int off, int len) 从此输入流读取最多len字节的数据到字节数组中。
     */
    @Test
    public void testFileInputStreamRead2() {
        try {
            String s = "E:/Learn/JavaSE/File/file.txt";
            init(s);
            //准备一个byte[]数组（一次最多读取到6个字节)
            byte[] bytes = new byte[6];
            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));   //防止bytes没全部覆盖，有上次的残留。
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Test
    public void testFileInputStreamSkip(){
        try {
            String s = "E:/Learn/JavaSE/File/file1.txt";
            init(s);
            //准备一个byte[]数组（一次最多读取到6个字节)
            byte[] bytes = new byte[6];
            int readCount = 0;
            //跳过两个字符
            in.skip(2);   //HaCamellia.xiaohua
            //估计剩余字节数
            System.out.println(in.available());
            while ((readCount = in.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 创建文件对象
     * @param s 文件的地址
     */
    public void init(String s) {
        try {
            in = new FileInputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     */
    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
```