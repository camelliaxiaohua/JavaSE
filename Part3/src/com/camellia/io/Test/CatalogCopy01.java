package com.camellia.io.Test;

import java.io.*;

/**
 * 这个类提供了从源位置复制文件和目录到目标位置的功能。
 */
public class CatalogCopy01 {

    /**
     * 主方法，启动文件复制过程。
     *
     * @param args 命令行参数（本应用程序未使用）。
     */
    public static void main(String[] args) {
        // 记录程序开始执行的时间
        long begin = System.currentTimeMillis();

        // 定义要复制的源目录
        File sourceFile = new File("E:\\桌面临时缓存\\Java 21 帮助文档");

        // 定义复制到的目标目录
        File targetFile = new File("E:\\Learn\\JavaSE\\Part3\\src\\document\\HelpDocument");

        // 如果目标目录不存在，则创建它
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        // 遍历源目录中的每个文件
        for (File newFile : sourceFile.listFiles()) {
            // 如果是文件，直接复制
            if (newFile.isFile()) {
                copy(newFile, targetFile);
            } else {
                // 如果是目录，递归复制该目录
                copyPath(newFile, targetFile);
            }
        }

        // 记录程序结束的时间
        long end = System.currentTimeMillis();
        // 输出程序执行的总时间
        System.out.println("程序执行的总时间：\t" + (end - begin) + " 毫秒");
    }

    /**
     * 递归复制目录从源位置到目标位置。
     *
     * @param sourceFile 源目录
     * @param targetFile 目标目录
     */
    private static void copyPath(File sourceFile, File targetFile) {
        // 在目标位置创建新目录
        File newFile = new File(targetFile, sourceFile.getName());
        newFile.mkdir();

        // 复制源目录中的每个文件或子目录
        for (File file : sourceFile.listFiles()) {
            if (file.isFile()) {
                copy(file, newFile);
            } else {
                copyPath(file, newFile);
            }
        }
    }

    /**
     * 复制单个文件从源位置到目标位置。
     *
     * @param sourceFile 源文件
     * @param targetFile 目标目录
     */
    private static void copy(File sourceFile, File targetFile) {
        File newFile = new File(targetFile, sourceFile.getName());
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(newFile))) {

            // 使用缓冲区读取和写入文件
            byte[] bytes = new byte[8192];
            int readCount;
            // 分块读取文件并写入到新位置
            while ((readCount = reader.read(bytes)) != -1) {
                writer.write(bytes, 0, readCount);
            }
            writer.flush(); // 确保所有数据都被写入文件
            System.out.println("复制成功：\t" + newFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("文件未找到：" + sourceFile.getAbsolutePath());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("复制文件时发生错误：" + sourceFile.getAbsolutePath());
            e.printStackTrace();
        }
    }
}
