package com.camellia.io.BufferedReader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 带有缓冲区的字符输入流。
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Part3/src/document/滕王阁序.txt"))){
            int readCount = 0;
            char[] chars = new char[1024];
            while ((readCount = br.read(chars)) != -1){
                System.out.println(new String(chars, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BufferedReader/BufferedInputStream的两个方法：
     *      1. mark方法：在当前的位置上打标记
     *      2. reset方法：回到上一次打标记的位置
     *
     *      这两个方法的调用顺序是：先调用mark，再调用reset。
     *      这两个方法组合起来完成的任务是：某段内容重复读取。
     */
    @Test
    public void testBufferedMark(){
        // 创建带有缓冲区的字符输入流（一般把BufferedReader叫做处理流/包装流）
        try(BufferedReader br = new BufferedReader(new FileReader("src/document/滕王阁序.txt"))){
            System.out.println(br.markSupported());
            int readChar=0;
            while ((readChar = br.read()) != -1){
                if(((char) readChar)=='尔')br.mark(1024);
                System.out.print(((char) readChar));
            }
            br.reset();
            while ((readChar = br.read()) != -1){
                if(((char) readChar)=='尔')br.mark(0); //随便写，在jdk21无实际意义。
                System.out.print(((char) readChar));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
