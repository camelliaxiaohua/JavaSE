package com.camellia.io.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 一个用于将目录及其内容复制到另一个位置的工具类。
 */
public class CatalogCopy02 {

    /**
     * 启动目录复制过程的主方法。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Path sourceDir = Paths.get("E:\\桌面临时缓存\\Java 21 帮助文档");
        Path targetDir = Paths.get("E:\\Learn\\JavaSE\\Part3\\src\\document\\HelpDocument");

        try {
            // 从源目录开始遍历文件树
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
                /**
                 * 在访问文件时调用的方法。
                 *
                 * @param file 当前访问的文件路径
                 * @param attrs 当前文件的基本属性
                 * @return FileVisitResult 表示是否继续遍历
                 * @throws IOException 如果发生I/O错误
                 */
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // 将文件从源目录复制到目标目录
                    copyFile(file, targetDir.resolve(sourceDir.relativize(file)));
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * 在访问目录中的条目之前调用的方法。
                 *
                 * @param dir 当前访问的目录路径
                 * @param attrs 当前目录的基本属性
                 * @return FileVisitResult 表示是否继续遍历
                 * @throws IOException 如果发生I/O错误
                 */
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    // 在目标位置创建相应的目录
                    Path targetPath = targetDir.resolve(sourceDir.relativize(dir));
                    if (!Files.exists(targetPath)) {
                        Files.createDirectories(targetPath);
                        System.out.println("目录已创建: " + targetPath);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("The total time the program was executed:\t"+(end-begin));
    }

    /**
     * 将文件从源位置复制到目标位置。
     *
     * @param source 源文件路径
     * @param target 目标文件路径
     */
    private static void copyFile(Path source, Path target) {
        try {
            // 复制文件，如果目标文件已存在，则替换它
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件已复制: " + target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
