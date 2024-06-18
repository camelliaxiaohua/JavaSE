package com.camellia.io.Test;

import org.junit.jupiter.api.Test;

import java.io.File;

public class CatalogCopyTest {
    @Test
    public void testCatalogCopy(){
        File file1 = new File("E:\\桌面临时缓存\\Java 21 帮助文档");
        File file2 = new File("src/document/Test");
        File[] files = file1.listFiles();
        for(File file : files){
            if(file.isFile()){
                System.out.println(file2.getAbsoluteFile()+"\\"+file.getName());
            }
            else {
                System.out.println(file2.getAbsoluteFile()+"\\"+file.getName());
            }
        }
    }
}
