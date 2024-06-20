package com.camellia.io.CompressionDecompression;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 该类包含使用ZIP格式压缩和解压缩文件的测试方法。
 */
public class ZipInputOutputStreamTest {
    // 源文件路径
    private String sourceFilePath = "E:\\桌面临时缓存\\C程序设计（第五版） (谭浩强) (Z-Library).pdf";
    // ZIP压缩文件路径
    private String zipFilePath = "src/document/C程序设计（第五版） (谭浩强) (Z-Library).pdf.zip";
    // 解压后的文件路径
    private String extractedFilePath = "src/document/C程序设计（第五版） (谭浩强) (Z-Library) - extracted.pdf";

    /**
     * 测试ZIP文件的压缩。
     * 读取一个PDF文件，并将压缩后的内容写入一个新的ZIP文件。
     */
    @Test
    public void testZipOutputStream() {
        try (
                // 创建文件输入流读取源文件
                FileInputStream fis = new FileInputStream(sourceFilePath);
                // 创建ZIP输出流写入压缩文件
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))
        ) {
            // 创建一个新的ZIP条目
            ZipEntry zipEntry = new ZipEntry(new File(sourceFilePath).getName());
            zos.putNextEntry(zipEntry);

            // 读取文件的缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 将文件写入ZIP
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }

            // 关闭当前条目
            zos.closeEntry();
        } catch (FileNotFoundException e) {
            // 处理指定文件未找到的情况
            e.printStackTrace();
        } catch (IOException e) {
            // 处理一般的I/O异常
            e.printStackTrace();
        }
    }

    /**
     * 测试ZIP文件的解压缩。
     * 读取一个ZIP压缩的文件，并将解压后的内容写入一个新的文件。
     */
    @Test
    public void testZipInputStream() {
        try (
                // 创建ZIP输入流读取压缩文件
                ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
                // 创建文件输出流写入解压后的文件
                FileOutputStream fos = new FileOutputStream(extractedFilePath)
        ) {
            // 获取ZIP中的第一个条目
            ZipEntry zipEntry = zis.getNextEntry();

            // 读取文件的缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 将文件内容写入输出流
            while ((bytesRead = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // 关闭当前条目
            zis.closeEntry();
        } catch (FileNotFoundException e) {
            // 处理指定文件未找到的情况
            e.printStackTrace();
        } catch (IOException e) {
            // 处理一般的I/O异常
            e.printStackTrace();
        }
    }
}
