package com.camellia.oop.class8;

public class User {
    //用户id
    private String id;
    //用户国籍
    //静态变量什么时候开劈空间（初始化）、存储在哪里？
    //类加载时初始化
    //JDK8之后：静态变量存储在堆内存之中

    private static String country="China";

    public User() {
    }

    public User(String id) {
        this.id = id;
    }
    public void PrintInfo(){
        System.out.println("ID: " + id+"\tCountry: " + country);
    }
}
