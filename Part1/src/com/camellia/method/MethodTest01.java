package com.camellia.method;

// 调用方法是，类名. 什么情况下可以省略。
// 调用者 和 被调用者 在同一个类中时，可以省略。
public class MethodTest01 {
    public static void main(String[] args) {
        //调用method1
        method1();
        MethodTest01.method1();
        //调用method2
        /*method2(); 编译器报错*/
        MethodTest.method2();
    }
    public static void method1(){
        System.out.println("mothod1执行了！");
    }
}

class  MethodTest{
    public static void method2(){
        System.out.println("method2执行了！");
    }
}
