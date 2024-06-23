# IO流体系结构

1. **四大头领：**
    - **InputStream**：用于读取字节流的基类。
    - **OutputStream**：用于写入字节流的基类。
    - **Reader**：用于读取字符流的基类。
    - **Writer**：用于写入字符流的基类。
>都是抽象类

2. **文件相关的流：**
    - **FileInputStream**：从文件中读取字节。
    - **FileOutputStream**：向文件中写入字节。
    - **FileReader**：从文件中读取字符。
    - **FileWriter**：向文件中写入字符。

3. **缓冲流相关的流：**
    - **BufferedInputStream**：提供了缓冲功能的输入流。
    - **BufferedOutputStream**：提供了缓冲功能的输出流。
    - **BufferedReader**：提供了缓冲功能的字符输入流。
    - **BufferedWriter**：提供了缓冲功能的字符输出流。

4. **转换流相关的流：**
    - **InputStreamReader**：将字节流转换为字符流。
    - **OutputStreamWriter**：将字符流转换为字节流。

5. **打印流相关的流：**
    - **PrintStream**：用于打印格式化的输出流。
    - **PrintWriter**：提供了自动刷新功能的打印输出流。

6. **对象流相关的流：**
    - **ObjectInputStream**：用于从文件中读取对象。
    - **ObjectOutputStream**：用于向文件中写入对象。

7. **数据流相关的流：**
    - **DataInputStream**：用于读取基本数据类型的流。
    - **DataOutputStream**：用于写入基本数据类型的流。

8. **字节数组流相关的流：**
    - **ByteArrayInputStream**：从字节数组中读取数据。
    - **ByteArrayOutputStream**：向字节数组中写入数据。

9. **压缩和解压缩相关的流：**
    - **GZIPInputStream**：从GZIP格式的流中读取数据。
    - **GZIPOutputStream**：将数据写入GZIP格式的流。

10. **线程相关的流：**
    - **PipedInputStream**：与PipedOutputStream配合使用，允许两个线程间的通信。
    - **PipedOutputStream**：与PipedInputStream配合使用，允许两个线程间的通信。

> 所有的流都实现了Closeable接口，都有close()方法，流用完要关闭。
所有的输出流都实现了Flushable接口，都有flush()方法，flush方法
的作用是，将缓存清空，全部写出。养成好习惯，以防数据丢失。

