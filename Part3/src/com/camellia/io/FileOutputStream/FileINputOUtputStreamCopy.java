package com.camellia.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileINputOUtputStreamCopy {
    //输入流
    private static FileInputStream in = null;
    //输出流
    private static FileOutputStream out = null;

    public static void main(String[] args) {
        //输入文件地址
        String inAddress = "I:\\座花台_one\\视频\\VID_20230325_163656.mp4";
        //输出文件地址
        String outAddress = "E:/Learn/JavaSE/File/outMp4.mp4";
        inInit(inAddress);
        outInit(outAddress);
        //读写交替
        CopyByBytes();
    }

    public static void CopyByBytes() {
        try {
            int readCount = 0;
            byte[] bytes = new byte[1024];
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
            }
            //刷新,flush()方法的作用是将缓冲区中的数据强制写入到输出流中。
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            allClose();
        }
    }

    public static void CopyByByte() {
        int readByte = 0;
        try {
            while ((readByte = in.read()) != -1) {
                System.out.print(((char) readByte));
                out.write(readByte);
            }
            //刷新,flush()方法的作用是将缓冲区中的数据强制写入到输出流中。
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            allClose();
        }
    }

    public static void inInit(String inAddress) {
        try {
            in = new FileInputStream(inAddress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void outInit(String outAddress) {
        try {
            out = new FileOutputStream(outAddress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
