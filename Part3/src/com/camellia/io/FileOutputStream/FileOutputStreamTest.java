package com.camellia.io.FileOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    //创建文件字节输出流对象
    private FileOutputStream out = null;

    /**
     * 以数组形式输出指定的多个字节。
     */
    @Test
    public void testFileOutputStreamMethods() {
        try {
            String s = "E:/Learn/JavaSE/File/outfile1.txt";
            init(s);
            //输出
            byte[] bytes = "Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune.".getBytes();
            out.write(bytes);
            //注意：刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * write()输出单个字节
     */
    @Test
    public void testFileOutputStreamWrite() {
        try {
            String s = "E:/Learn/JavaSE/File/outfile1.txt";
            init(s);
            //输出
            out.write(97);
            out.write(98);
            out.write(99);
            //注意：刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 创建一个文件输出流对象
     * @param address 写文件地址
     */
    public void init(String address) {
        try {
            //这里会覆盖文件内容，传参数true就不会覆盖。
            out = new FileOutputStream(address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭文件输出流
     */
    public void close() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
