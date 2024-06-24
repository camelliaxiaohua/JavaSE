package com.camellia.basic;

public class PlusTest{
    public static void main(String[] args) {
        int a=10;
        int b=20;
        String str="10";
        //字符串拼接
        System.out.println(str + b); //1020;

        str="30";
        //当一个表达式中出现多个+，若没有（），遵循从左到右。
        System.out.println(a + b + str); //3030;

        //添加了（）优先级比较高。
        System.out.println(a+(b+str)); //102030

    }
}