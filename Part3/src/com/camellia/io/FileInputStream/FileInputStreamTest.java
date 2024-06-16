package com.camellia.io.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    private static InputStream in = null;

    /**
     * int read() 从该输入流读取一个字节的数据。
     */
    @Test
    public void testFileInputStreamRead() {
        try {
//          String s = "\"E:\\Learn\\JavaSE\\File\\file.txt\"";  这种写法需要两个//;
            String s = "E:/Learn/JavaSE/File/file.txt";
            init(s);
            //循环输出
            int readByte = 0;
            while ((readByte = in.read()) != -1) {
                System.out.print(readByte + "\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * int read(byte[] b) 从此输入流读取最多b.length字节的数据到字节数组中。 <br>
     * int read(byte[] b, int off, int len) 从此输入流读取最多len字节的数据到字节数组中。
     */
    @Test
    public void testFileInputStreamRead2() {
        try {
            String s = "E:/Learn/JavaSE/File/file.txt";
            init(s);
            //准备一个byte[]数组（一次最多读取到6个字节)
            byte[] bytes = new byte[6];
            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));   //防止bytes没全部覆盖，有上次的残留。
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Test
    public void testFileInputStreamSkip(){
        try {
            String s = "E:/Learn/JavaSE/File/file1.txt";
            init(s);
            //准备一个byte[]数组（一次最多读取到6个字节)
            byte[] bytes = new byte[6];
            int readCount = 0;
            //跳过两个字符
            in.skip(2);   //HaCamellia.xiaohua
            //估计剩余字节数
            System.out.println(in.available());
            while ((readCount = in.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 创建文件对象
     * @param s 文件的地址
     */
    public void init(String s) {
        try {
            in = new FileInputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     */
    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
