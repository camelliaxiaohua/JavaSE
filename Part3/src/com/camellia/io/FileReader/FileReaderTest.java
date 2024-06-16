package com.camellia.io.FileReader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符输入流测试类。
 * 提供两种方式读取文件内容：逐字符读取和逐块读取。
 */
public class FileReaderTest {

    /**
     * 测试逐字符读取文件内容的方法。
     * 读取文件 "filechar1.txt" 并打印每个字符。
     */
    @Test
    public void testFileReaderReadChar() {
        // 使用 try-with-resources 确保 FileReader 在使用后自动关闭
        try (FileReader reader = new FileReader("E:\\Learn\\JavaSE\\File\\filechar1.txt")) {
            int readChar;
            // 循环读取文件的每个字符，直到文件结束
            while ((readChar = reader.read()) != -1) {
                System.out.print((char) readChar); // 将读取到的字符打印到控制台
            }
        } catch (FileNotFoundException e) {
            // 文件未找到时打印堆栈跟踪信息
            e.printStackTrace();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }

    /**
     * 测试逐块读取文件内容的方法。
     * 读取文件 "filechar1.txt" 并打印读取到的字符块。
     */
    @Test
    public void testFileReaderReadChars() {
        // 使用 try-with-resources 确保 FileReader 在使用后自动关闭
        try (FileReader reader = new FileReader("E:\\Learn\\JavaSE\\File\\filechar1.txt")) {
            int readCount;
            char[] chars = new char[512]; // 定义字符数组作为缓冲区
            // 循环读取文件的字符块，直到文件结束
            while ((readCount = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount)); // 将读取到的字符块转换为字符串并打印
            }
        } catch (FileNotFoundException e) {
            // 文件未找到时打印堆栈跟踪信息
            e.printStackTrace();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }
}
