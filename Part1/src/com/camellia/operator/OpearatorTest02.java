package com.camellia.operator;

/*
&&     短路与
||     短路或
 */
public class OpearatorTest02 {
    public static void main(String[] args) {
        //1、&和&&的区别
        int i1=99;
        int j1=100;
        if(i1>j1&i1>++j1){}    //虽然i1>j1不成立，但是i1>++j1还是会执行。
        System.out.println(j1);
        if(i1>j1&&i1>++j1){}   //i1>j1不成立，就不判断后面的。
        System.out.println(j1);
    }
}
