package com.camellia.thread.MethodForThreads;

import org.junit.jupiter.api.Test;

/**
 * 本类展示了如何使用Java中的一些基本线程方法。
 * 包括获取当前线程对象、创建线程、启动线程以及设置线程名称等。
 */
public class ThreadMethodsTest {

    /**
     * 测试线程的方法，演示了获取当前线程、创建和启动线程，以及设置线程名称。
     */
    @Test
    public void testThreadMethods() {
        // 1. 获取当前线程对象
        Thread mainThread = Thread.currentThread();
        // 获取当前线程名称并打印
        System.out.println("主线程名称：" + mainThread.getName());

        // 2. 创建一个新的线程对象
        Thread thread = new MyThread();
        // 启动线程
        thread.start();

        // 3. 再创建一个新的线程对象
        thread = new MyThread();
        // 修改线程名称
        thread.setName("Camellia@线程");
        // 启动线程
        thread.start();

        // 4. 创建线程对象时直接设置名称
        thread = new MyThread("XIAOHUA@线程");
        // 启动线程
        thread.start();
    }
}

/**
 * 自定义线程类，继承自java.lang.Thread。
 * 该类展示了如何通过继承Thread类来创建线程，并如何获取和设置线程的名称。
 */
class MyThread extends Thread {

    /**
     * 默认构造方法
     */
    public MyThread() {}

    /**
     * 带名称参数的构造方法
     * @param name 线程的名称
     */
    public MyThread(String name) {
        super(name);
    }

    /**
     * 重写run方法，这是线程的执行体，当线程启动时会执行此方法。
     */
    @Override
    public void run() {
        // 获取当前线程对象
        Thread thread = Thread.currentThread();
        // 获取当前线程名称并打印
        System.out.println("分支线程名称：" + thread.getName());
    }
}
