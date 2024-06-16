package com.camellia.io.filepath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AboutFilePath {
    public static void main(String[] args) throws FileNotFoundException {

        // 到目前为止，我们读写文件时，路径统一采用的是绝对路径
        //FileInputStream in = new FileInputStream("E:\\powernode\\02-JavaSE\\code\\file.txt");
        //FileInputStream in = new FileInputStream("E:/powernode/02-JavaSE/code/file.txt");

        // 我们尝试使用相对路径
        // 相对路径一定要搞清楚当前路径是哪里？相对路径一定是从当前所在的路径开始。
        // 在IDEA工具中，默认的当前路径是 project 的根。（项目的根就是当前路径）
        //FileInputStream in = new FileInputStream("log");

        // 读log2文件
        //FileInputStream in = new FileInputStream("chapter08/src/log2");

        // 新的内容
        // 以下讲解内容有一些代码是和线程有关系的。大致理解一下。
        // 或者说这个代码死记硬背也是可以的。
        // 从类路径当中加载资源。
        // Thread.currentThread() 获取当前线程
        // Thread.currentThread().getContextClassLoader() 获取当前线程的类加载器
        // getResource()方法就表示从类的根路径下开始加载资源
        // 注意：这种方式只能从类路径当中加载资源。如果这个资源是放在类路径之外的，这种方式不合适。
        // 如果你代码是以下这种写法的，表示当前路径就是类的根路径。自动从类的根路径下开始加载资源。
        // 这种方式的优点：通用，在进行系统移植的时候，这种方式仍然是通用的。适应性强。
        // 这种方式的缺点：资源必须放在类路径当中。没有在类路径下，是无法加载到的。
        String path = Thread.currentThread().getContextClassLoader().getResource("test/file").getPath();
        System.out.println(path);

        FileInputStream in = new FileInputStream(path);

    }
}
