package com.camellia.operator;

/**
 * 1、查看程序字节码指令：javap -c
 * 2、重点解读的字节码是：
 *    bipush        10     :将10这个字面量压入操作数栈中。
 *    istore_1             :将操作数栈顶元素弹出，然后将其存储到局部变量表的一号槽位上。
 *    iload_1              :将局部变量表1号槽位上的数据复制一份，压入操作数栈。
 *    iinc          2,1    :将局部变量表的2号槽位上的数加一。
 *
 * 3、在Java语言中，任何一个方法执行时，都会专门为这个方法分配所属的内存空间，供这个方法的使用。
 *    每个方法都有自己独立的内存空间，这个内存空间有两块比较重要的内存空间：
 *        局部变量表、操作数栈
 */

public class ReadClass {
    public static void main(String[] args) {
        int i=10;
        int j=i;
        j++;
    }
}
/*
Compiled from "ReadClass.java"
public class ReadClass {
    public ReadClass();
    Code:
            0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
            4: return

    public static void main(java.lang.String[]);
    Code:
            0: bipush        10
            2: istore_1
       3: iload_1
       4: istore_2
       5: iinc          2, 1
            8: return
}
*/
