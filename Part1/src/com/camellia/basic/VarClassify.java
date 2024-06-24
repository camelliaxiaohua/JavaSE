package com.camellia.basic;

/*
 变量可以根据定义/声明的位置来进行分类，可以分为两大类：
        1、局部变量
        2、成员变量
          静态变量
          实例变量
 */
public class VarClassify {
    public static void main(String[] args) {
        //凡是在方法体中定义的变量，一定是局部变量。
        //局部变量只在当前方法体中有效。
        int a=100;
    }

    //在类中定义的变量叫做成员变量。
    //实例变量
    int b=200;
    //静态变量
    static int c=300;
}
