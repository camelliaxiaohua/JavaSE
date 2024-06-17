package com.camellia.io.BufferedWriter;

import java.io.*;

public class BufferedInputOutStream {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("Part3/src/document/滕王阁序.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Part3/src/document/out_滕王阁序.txt"))){
            //开始读（br.readLine()方法每次读取一行，如果读取不到任何数据，则返回null。）
            String s = null;
            while ((s = br.readLine()) != null){
                bw.write(s);
                System.out.println(s);
            }
            //刷新
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
