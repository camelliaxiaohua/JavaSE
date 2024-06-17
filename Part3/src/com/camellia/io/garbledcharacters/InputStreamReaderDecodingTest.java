package com.camellia.io.garbledcharacters;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * InputStreamReader 是一个字符流转换器，用于将字节流解码为字符流。
 * 它通过指定的字符编码将输入的字节流解码为字符数据。
 *
 * 常用的构造方法：
 *   InputStreamReader(InputStream in) 使用平台默认的字符集进行解码。
 *   InputStreamReader(InputStream in, String charsetName) 使用指定的字符集进行解码。
 *
 * FileReader 实际上是 InputStreamReader 的子类，是一个包装流而非节点流。
 */
public class InputStreamReaderDecodingTest {

    /**
     * 测试使用 InputStreamReader 读取 GBK 编码的文件。
     * 使用指定的字符集（GBK）解码文件内容并输出到控制台。
     */
    @Test
    public void testInputStreamReaderDecoding() {
        // 创建一个 InputStreamReader 对象，指定使用 GBK 字符集进行解码
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("src/document/GBK滕王阁序.txt"), "GBK")) {
            // 文件采用了 GBK 编码方式存储，所以在解码的时候要指定对应的解码方法
            int readCount;
            char[] chars = new char[1024];
            while ((readCount = isr.read(chars)) != -1) {
                // 将读取到的字符数组转换为字符串并输出
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试使用 FileReader 读取 GBK 编码的文件。
     * 使用指定的字符集（GBK）解码文件内容并输出到控制台。
     */
    @Test
    public void testFileReaderDecoding() {
        // 创建一个 FileReader 对象，指定使用 GBK 字符集进行解码
        try (FileReader isr = new FileReader("src/document/GBK滕王阁序.txt", Charset.forName("GBK"))) {
            // 文件采用了 GBK 编码方式存储，所以在解码的时候要指定对应的解码方法
            int readCount;
            char[] chars = new char[1024];
            while ((readCount = isr.read(chars)) != -1) {
                // 将读取到的字符数组转换为字符串并输出
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
