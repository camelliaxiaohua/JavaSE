package com.camellia.io.TryWithResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java 7的新特性：try-with-resources（资源自动关闭）
 * 凡是实现了AutoCloseable接口的流都可以使用try-with-resources实现自动关闭。
 */
public class TryWithResources {
    public static void main(String[] args) {
        //用于测试流是否关闭
        FileInputStream inTest = null;
        try (FileInputStream in = new FileInputStream("E:/Learn/JavaSE/File/outfile1.txt");
             FileOutputStream out = new FileOutputStream("****")) {
            inTest = in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //测试是否关闭，若关闭inTest是无法正常读取的。
        try {
            System.out.println(inTest.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
