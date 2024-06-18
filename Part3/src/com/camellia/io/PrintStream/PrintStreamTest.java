package com.camellia.io.PrintStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    @Test
    public void testPrintStream(){
        //创建一个打印流对象
        try(PrintStream ps = new PrintStream(new FileOutputStream("src/document/PrintStream.txt"),true)){
            ps.println("落霞与孤鹜齐飞，秋水共长天一色。");
            String name ="Camellia.xioahua";
            double score = 96.6;
            ps.printf("姓名：%s  考试成绩：%.2f",name,score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
