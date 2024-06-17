package com.camellia.io.BufferedInputStream;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1. java.io.BufferedInputStream的用法和FileInputStream用法相同。<br>
 *
 * 2. 他们的不同点是：<br>
 *      FileInputStream是节点流。<br>
 *      BufferedInputStream是缓冲流(包装流/处理流)。
 *      这个流的效率高。自带缓冲区。并且自己维护这个缓冲区。读大文件的时候建议采用这个缓冲流来读取。<br>
 * 3. BufferedInputStream对 FileInputStream 进行了功能增强。增加了一个缓冲区的功能。<br>
 *
 * 4. 怎么创建一个BufferedInputStream对象呢？构造方法：<br>
 *      BufferedInputStream(InputStream in)
 */
public class BufferedInputStreamTest {
    @Test
    public void testBufferedInputStreamRead(){
        BufferedInputStream bis = null;
        try{
            //创建节点流和包装流
            bis = new BufferedInputStream(new FileInputStream("src/document/english.txt"));
            //读，和FileInputStream完全一样。
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bis.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           if(bis != null){
               try {
                   bis.close();
                   //关闭BufferedInputStream即可，包装流的底层会调用节点流的close方法。
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }


}
