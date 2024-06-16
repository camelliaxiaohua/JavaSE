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
