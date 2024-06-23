package com.camellia.thread.Abegin;

/**
 * 分析当前程序有多少个线程
 * 当前程序除了GC线程之外只有一个主线程。
 * 在JVM当中只有一个VM Stack。
 * 这个栈底是main方法。
 * 栈的顶部是m3方法。
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main end");
    }

    private static void m1() {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 end");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 end");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }
}
