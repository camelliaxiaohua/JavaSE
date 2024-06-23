---
title: IO流概述
date: 2024-06-16 09:14:25
tags:
categories:
- Java SE



---

!!! note 目录
<!-- toc -->


# IO流体系结构

1. **四大头领：**
   - **InputStream**：用于读取==字节流==的基类。
   - **OutputStream**：用于写入==字节流==的基类。
   - **Reader**：用于读取==字符流==的基类。
   - **Writer**：用于写入==字符流==的基类。
>都是抽象类

2. **文件相关的流：**

   - **FileInputStream**：从文件中读取==字节==。
   - **FileOutputStream**：向文件中写入==字节==。
   - **FileReader**：从文件中读取==字符==。
   - **FileWriter**：向文件中写入==字符==。

3. **缓冲流相关的流：**
   - **BufferedInputStream**：提供了缓冲功能的==字节==输入流。
   - **BufferedOutputStream**：提供了缓冲功能的==字节==输出流。
   - **BufferedReader**：提供了缓冲功能的==字符==输入流。
   - **BufferedWriter**：提供了缓冲功能的==字符==输出流。

4. **转换流相关的流：**
   - **InputStreamReader**：将字==**节流转换为字符流**==。
   - **OutputStreamWriter**：将==**字符流转换为字节流**==。

5. **打印流相关的流：**
   - **PrintStream**：用于打印格式化的输出流。
   - **PrintWriter**：提供了自动刷新功能的打印输出流。

6. **对象流相关的流：**

   - **ObjectInputStream**：用于从文件中读取==对象==。
   - **ObjectOutputStream**：用于向文件中写入==对象==。

7. **数据流相关的流：**
   - **DataInputStream**：用于读取==基本数据类型==的流。
   - **DataOutputStream**：用于写入==基本数据类型==的流。

   > 对象流也具有数据流相关的功能

8. **字节数组流相关的流：**
   - **ByteArrayInputStream**：从==字节数组==中读取数据。
   - **ByteArrayOutputStream**：向==字节数组==中写入数据。

9. **压缩和解压缩相关的流：**
   - **GZIPInputStream**：从GZIP格式的流中读取数据。
   - **GZIPOutputStream**：将数据写入GZIP格式的流。

10. **线程相关的流：**
   - **PipedInputStream**：与PipedOutputStream配合使用，允许两个线程间的通信。
   - **PipedOutputStream**：与PipedInputStream配合使用，允许两个线程间的通信。

> 所有的流都实现了Closeable接口，都有close()方法，流用完要关闭。
所有的输出流都实现了Flushable接口，都有flush()方法，flush方法
的作用是，将缓存清空，全部写出。养成好习惯，以防数据丢失。

