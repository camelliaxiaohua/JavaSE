package com.camellia.operator;

/*
逻辑运算符
&      逻辑与（并且）  左右两边都是true，结果就是true。只要有一个false，结果就是false。
|      逻辑或（或者）  左右两边只要有一个是true，结果就是true。
^      逻辑异或       左右两边不一样，结果就是true。
 */
public class OperatorTest01 {
    public static void main(String[] args) {
        System.out.println(true&true);     //true
        System.out.println(true&false);    //false
        System.out.println(false&false);   //false

        System.out.println(true|true);     //true
        System.out.println(true|false);    //true
        System.out.println(false|false);   //false

        System.out.println(true^true);     //false
        System.out.println(true^false);    //true
        System.out.println(false^false);   //false
    }
}
