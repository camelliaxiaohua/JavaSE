package com.camellia.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输入输出流复制类
 * 提供通过字节或字节数组复制文件的功能
 */
public class FileINputOUtputStreamCopy {
    // 输入流
    private static FileInputStream in = null;
    // 输出流
    private static FileOutputStream out = null;

    /**
     * 主方法，程序入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 输入文件地址
        String inAddress = "I:\\座花台_one\\视频\\VID_20230325_163656.mp4";
        // 输出文件地址
        String outAddress = "E:/Learn/JavaSE/File/outMp4.mp4";
        // 初始化输入流
        inInit(inAddress);
        // 初始化输出流
        outInit(outAddress);
        // 读写交替，通过字节数组复制文件
        CopyByBytes();
    }

    /**
     * 通过字节数组方式复制文件
     */
    public static void CopyByBytes() {
        try {
            int readCount = 0;
            // 定义字节数组缓冲区
            byte[] bytes = new byte[1024];
            // 读取和写入数据
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
            }
            // 刷新，flush()方法的作用是将缓冲区中的数据强制写入到输出流中。
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有流
            allClose();
        }
    }

    /**
     * 通过单字节方式复制文件
     */
    public static void CopyByByte() {
        int readByte = 0;
        try {
            // 读取和写入单个字节
            while ((readByte = in.read()) != -1) {
                System.out.print((char) readByte);
                out.write(readByte);
            }
            // 刷新，flush()方法的作用是将缓冲区中的数据强制写入到输出流中。
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有流
            allClose();
        }
    }

    /**
     * 初始化输入流
     * @param inAddress 输入文件地址
     */
    public static void inInit(String inAddress) {
        try {
            in = new FileInputStream(inAddress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化输出流
     * @param outAddress 输出文件地址
     */
    public static void outInit(String outAddress) {
        try {
            out = new FileOutputStream(outAddress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭所有流
     */
    public static void allClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
