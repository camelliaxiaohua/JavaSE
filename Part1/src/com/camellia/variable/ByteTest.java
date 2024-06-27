package com.camellia.variable;

public class ByteTest {
    public static void main(String[] args) {
        byte b=1;
        byte a=127;
       //按道理这个由int转换为byte没有强转的话因该报错。
        // 其实这是Java语言开发者给程序员的优化措施。
        // 规则：当一个整数型字面量没有超过对应变量类型范围时，可以直接赋值给对应变量类型的变量。

        //byte和short混合运算的时候，先各自转换为int再做运算。
        //byte+byte-->int、 byte+short-->int、 short+short-->int
        short m=10;
        byte n=10;
        //编译器报错，最后结果是int类型，不能用short变量接收。（注意和字面量的区别）
        //short result=m+n;

        byte c=10/3;
        // 10/3都是字面量，所以会在编译器就计算出来。即在ByteTest.java中是byte c=10/3,但是在ByteTest.class中byte c=3;


        byte x=10;
        byte y=3;
        //byte d=x/y;
        //编译器报错,其只能知道x/y结果为int，不知道结果是什么，只有在正式运行才知道。



    }
}
