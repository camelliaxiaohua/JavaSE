package com.camellia.io.CompressionDecompression;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 该类包含使用GZIP格式压缩和解压缩文件的测试方法。
 */
public class GZIPInputOutputStreamTest {

    /**
     * 测试GZIP文件的解压缩。
     * 读取一个GZIP压缩的PDF文件，并将解压后的内容写入一个新的PDF文件。
     */
    @Test
    public void testGZIPInputStream() {
        try (
                // 创建一个GZIP输入流，从压缩文件读取数据
                GZIPInputStream gzip = new GZIPInputStream(new FileInputStream("src/document/C程序设计（第五版） (谭浩强) (Z-Library).pdf.gz"));
                // 创建一个文件输出流，将解压后的内容写入新的文件
                FileOutputStream out = new FileOutputStream("src/document/C程序设计（第五版） (谭浩强) (Z-Library).pdf")
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 从GZIP输入流读取数据并写入文件输出流
            while ((bytesRead = gzip.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            // 节点流关闭时会自动刷新，而包装流需要手动刷新
        } catch (FileNotFoundException e) {
            // 处理指定文件未找到的情况
            e.printStackTrace();
        } catch (IOException e) {
            // 处理一般的I/O异常
            e.printStackTrace();
        }
    }

    /**
     * 测试文件的GZIP压缩。
     * 读取一个PDF文件，并将压缩后的内容写入一个新的GZIP文件。
     */
    @Test
    public void testGZIPOutputStream() {
        try (
                // 创建一个文件输入流，从原始文件读取数据
                FileInputStream in = new FileInputStream("E:\\桌面临时缓存\\C程序设计（第五版） (谭浩强) (Z-Library).pdf");
                // 创建一个GZIP输出流，将数据写入压缩文件
                GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream("src/document/C程序设计（第五版） (谭浩强) (Z-Library).pdf.gz"))
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 从文件输入流读取数据并写入GZIP输出流
            while ((bytesRead = in.read(buffer)) != -1) {
                gzip.write(buffer, 0, bytesRead);
            }

            // 调用finish()方法非常重要，以确保所有数据被刷新并最终生成压缩文件
            gzip.finish();
        } catch (FileNotFoundException e) {
            // 处理指定文件未找到的情况
            e.printStackTrace();
        } catch (IOException e) {
            // 处理一般的I/O异常
            e.printStackTrace();
        }
    }
}
