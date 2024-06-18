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
