package com.camellia.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输入输出流测试类。
 * 提供将一个文件内容复制到另一个文件的功能。
 */
public class FileReaderFileWriterCopy {

    /**
     * 主方法，程序入口。
     * 读取文件 "我与地坛 (史铁生) (Z-Library).txt" 的内容，并将其写入 "filechar3.txt"。
     * 同时在控制台打印读取的内容。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // 使用 try-with-resources 确保 FileReader 和 FileWriter 在使用后自动关闭
        try (FileReader reader = new FileReader("E:\\Learn\\JavaSE\\File\\我与地坛 (史铁生) (Z-Library).txt");
             FileWriter writer = new FileWriter("E:\\Learn\\JavaSE\\File\\filechar3.txt")) {

            char[] chars = new char[512]; // 定义字符数组作为缓冲区
            int readCount;

            // 循环读取文件的字符块，直到文件结束
            while ((readCount = reader.read(chars)) != -1) {
                // 将读取到的字符块转换为字符串
                String s = new String(chars, 0, readCount);
                // 写入字符串到目标文件
                writer.write(s);
                // 在控制台打印读取到的内容
                System.out.println(s);
            }

            // 刷新字符输出流，确保所有数据都被写入文件
            writer.flush();

        } catch (FileNotFoundException e) {
            // 文件未找到时打印堆栈跟踪信息
            e.printStackTrace();
        } catch (IOException e) {
            // 发生 I/O 错误时打印堆栈跟踪信息
            e.printStackTrace();
        }
    }
}
