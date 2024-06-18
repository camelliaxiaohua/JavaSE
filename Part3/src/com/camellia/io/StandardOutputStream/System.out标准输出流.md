# System.out 标准输出流
在Java编程语言中，`System.out`是一个非常重要的对象，它代表标准输出流。
标准输出流通常用于将信息输出到控制台或其他输出设备。
`System.out`是`java.io.PrintStream`类的一个实例，这个类提供了多种方法来格式化输出数据。

## 一、System.out 的主要特性和用途：

1. **输出目的地**：
    - 默认情况下，`System.out`流会将输出信息发送到控制台。这意味着当你调用`System.out.println("Hello, world!");`时，"Hello, world!"将被显示在你的命令行或控制台窗口上。

2. **PrintStream 类**：
    - `System.out`是`PrintStream`类的实例，`PrintStream`类提供了丰富的方法来打印信息，如`print()`, `println()`, `printf()`等。这些方法允许你格式化输出，输出不同类型的数据（如字符串、整数、浮点数等）。

3. **重定向输出**：
    - 你可以将`System.out`**重定向到文件、网络流或其他输出设备**。这可以通过创建一个新的`PrintStream`实例并赋值给`System.out`来实现。例如：
      ```java
      try {
          System.setOut(new PrintStream(new FileOutputStream("output.txt")));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      ```
      这段代码将标准输出流重定向到名为"output.txt"的文件中。

4. **安全性和性能**：
    - 在多线程环境中，使用`System.out`时需要小心，因为默认情况下，`PrintStream`的方法不是线程安全的。对于多线程应用，可能需要考虑使用线程安全的日志记录机制或同步`System.out`的访问。

5. **使用场景**：
    - `System.out`常用于调试输出、程序状态显示或简单的日志记录。对于生产环境中的日志记录，通常推荐使用日志框架如Log4j、SLF4J等，这些工具提供了更灵活的日志管理功能。

## 二、示例代码

```java
package com.camellia.io.StandardOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这是一个测试类，用于演示如何使用Java的标准输出流（System.out）和如何改变其输出目标。
 * 1. System.out 是Java中标准输出流的一个实例，默认情况下，它将输出到控制台。
 * 2. 该类展示了如何获取默认的标准输出流、改变输出流的目的地，并格式化输出。
 * 3. 注意：虽然System.out是一个全局流，JVM会在程序结束时自动关闭它，但在实际应用中，建议管理流的生命周期，以避免资源泄露。
 */
public class SystemOutTest {

    /**
     * 测试默认的System.out输出功能。
     * 默认情况下，System.out会将输出内容打印到控制台。
     */
    @Test
    public void testSystemOutDefault() {
        PrintStream out = System.out;
        out.println("滕王高阁临江渚，佩玉鸣鸾罢歌舞。");
    }

    /**
     * 演示如何改变System.out的输出目标到文件。
     * 通常，这在日志记录中很有用，可以将输出记录到文件中进行持久化。
     */
    @Test
    public void testSystemOutRedirect() {
        try {
            // 重定向System.out到文件
            System.setOut(new PrintStream("output.txt"));  // 更改输出路径以适应环境
        } catch (FileNotFoundException e) {
            // 输出文件未找到，打印异常信息
            System.err.println("文件未找到：output.txt");
            e.printStackTrace();
        }

        PrintStream out = System.out;
        out.println("滕王高阁临江渚，佩玉鸣鸾罢歌舞。");

        // 获取当前时间并格式化
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String formattedDate = sdf.format(now);

        // 输出当前时间和自定义消息
        out.println(formattedDate + ": SystemOutTest's testSystemOutRedirect method invoked.");

        // 在示例中，建议手动关闭流，即使在实际使用中JVM会处理
        out.close();
    }
}

```