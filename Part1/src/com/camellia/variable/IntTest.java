package com.camellia.variable;

public class IntTest {
    public static void main(String[] args) {
        //100是4个字节，b是八个字节。
        //所以存在自动类型类型转换。
        long b=100;
        //这个不存在类型转换。
        long c=100L;
        //这个会报错，原因是=右边先执行，这个整型字面量会以int类型处理，显然超过了int范围所以报错。其错误的原因在这。
        //long e=2147483648;
    }
}