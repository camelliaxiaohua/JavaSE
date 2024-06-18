package com.camellia.io.PrintWriter;

import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    @Test
    public void testPrintWriter(){
        try(PrintWriter pw = new PrintWriter(new FileWriter("src/document/PrintWriter"))){
            pw.println("落霞与孤鹜齐飞，秋水共长天一色。");
            //刷新
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
