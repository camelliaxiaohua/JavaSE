package com.camellia.io.Test;


import java.io.*;

public class CatalogCopy {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        File file1 = new File("E:\\桌面临时缓存\\Java 21 帮助文档");
        File file2 = new File("E:\\Learn\\JavaSE\\Part3\\src\\document\\HelpDocument");

            File[] files = file1.listFiles();
            for(File file : files){
                if(file.isFile()){
                    copyFile(file,file2);
                }else copyCatalog(file,file2);
            }
        long end = System.currentTimeMillis();
        System.out.println("The total time the program was executed:\t"+(end-begin));
    }

    public static void copyFile(File file1,File file2){
        try(BufferedInputStream reader =new BufferedInputStream((new FileInputStream(file1)));
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file2+"\\"+file1.getName()))){
            int readCount = 0;
            byte[] bytes = new byte[1024];
            while ((readCount = reader.read(bytes)) != -1){
                writer.write(bytes,0,readCount);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file2 +"\\" + file1.getName()+"拷贝完毕!");
    }

    public static void copyCatalog(File file1,File file2){
        String s = (file2 + "\\" + file1.getName());
        File file = new File(s);
        file.mkdir();
        System.out.println(s+"目录创建完毕");
        for(File file3 : file1.listFiles()){
            if(file3.isFile())copyFile(file3,file);
            else copyCatalog(file3,file);
        }
    }

}
