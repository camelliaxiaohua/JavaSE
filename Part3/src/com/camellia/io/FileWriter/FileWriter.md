---
title: FileWriter
date: 2024-06-16 22:28:34
tags:
categories:
- Java SE
---

!!! note 目录
<!-- toc -->

# FileWriter

`FileWriter` 是 Java 中用于将==字符==数据写入文件的类，**继承**自 `OutputStreamWriter`，属于 `java.io` 包。
它提供了将文本数据写入文件的功能，适用于处理文本文件的写入操作。

## 一、构造函数

| 构造函数                                            | 描述                                           |
|-------------------------------------------------|----------------------------------------------|
| * `FileWriter(File file)`                       | 创建一个新的 `FileWriter`，给定要写入的 `File`，使用默认的字符编码。 |
| * `FileWriter(File file, boolean append)`       | 创建一个新的 `FileWriter`，给定要写入的 `File`，并指定是否追加写入。 |
| `FileWriter(FileDescriptor fd)`                 | 创建一个新的 `FileWriter`，给定 `FileDescriptor`。     |
| * `FileWriter(String fileName)`                 | 创建一个新的 `FileWriter`，给定要写入的文件的名称，使用默认的字符编码。   |
| * `FileWriter(String fileName, boolean append)` | 创建一个新的 `FileWriter`，给定要写入的文件的名称，并指定是否追加写入。   |

## 二、常用方法

> FileWriter extends OutputStreamWriter
> 所以方法参考父类OutputStreamWriter

| 方法                                       | 描述                |
|------------------------------------------|-------------------|
| * `write(int c)`                         | 写入单个字符。           |
| * `write(char[] cbuf)`                   | 写入字符数组。           |
| * `write(char[] cbuf, int off, int len)` | 写入字符数组的指定部分。      |
| * `write(String str)`                    | 写入字符串。            |
| * `write(String str, int off, int len)`  | 写入字符串的指定部分。       |
| * `flush()`                              | 刷新流，将缓冲区中的数据写入文件。 |
| * `close()`                              | 关闭流并释放与之关联的资源。    |

> [!NOTE]
>
> FileWriter对比FileOutputStream的write方法不同的一点是可以传入字符串。



## 三、示例代码

```java
package com.camellia.io.FileWriter;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输出流测试类。
 * 提供写入普通文本到文件的功能。
 */
public class FileWriterTest {

    /**
     * 测试写入字符到文件的方法。
     * 向文件 "filechar2.txt" 中写入各种形式的文本。
     */
    @Test
    public void testFileWriterChar() {
        // 使用 try-with-resources 确保 FileWriter 在使用后自动关闭
        try (FileWriter writer = new FileWriter("E:\\Learn\\JavaSE\\File\\filechar2.txt")) {
            // 写入字符串
            writer.write("Camellia.xiaohua\n");
            // 写入单个字符 'a'
            writer.write(97);
            // 写入字符数组
            writer.write("重剑无锋，大巧无工\n".toCharArray());
            // 写入字符串的一部分，从索引2开始写入，写入5个字符
            writer.write("--中国·杭州", 2, 5);
            // 追加字符串到文件末尾
            writer.append("\n花有重开日，人无再少年！");
            // 刷新字符输出流，确保所有数据都被写入文件
            writer.flush();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }
}

```

