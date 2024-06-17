package com.camellia.io.BufferedOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1. java.io.BufferedOutputStream也是一个缓冲流。属于输出流。
 * 2. 怎么创建BufferedOutputStream对象？
 *      BufferedOutputStream(OutputStream out)
 * 3. FileOutputStream是节点流。 BufferedOutputStream是包装流。
 */
public class BufferedOutputStreamTest {
    @Test
    public void BufferedOutputStreamRead(){
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/document/out_english.txt"))){
            bos.write("重剑无锋，大巧无工！".getBytes());
            //刷新
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //这里采用try-with-resources关闭资源。若使用try-catch-finally关闭则和BufferedInputStream一样。

}
