package com.camellia.thread.ImplementingMultiThreading_2;

/**
 * 本类展示了在Java中如何实现多线程编程的第一种方式：
 * 通过继承`java.lang.Thread`类来创建和运行线程。
 * 在这个示例中，我们定义了一个自定义线程类`MyThread`，并在主线程中创建并启动了一个线程。
 */
public class ThreadByThread {
    /**
     * 程序的入口点。创建并启动一个线程，同时在主线程中执行另一段代码。
     * 通过这种方式，我们可以同时执行多个任务，实现多线程编程。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个自定义的线程对象
        MyThread myThread = new MyThread();

        // 启动线程
        myThread.start();

        // 这段代码在主线程中执行
        // 主线程执行一个循环，输出1000000次
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Main Thread: " + i + " is running.");
        }
    }
}

// 自定义一个线程类，通过继承java.lang.Thread类来实现线程
// MyThread类继承Thread，因此它本身也是一个线程。
class MyThread extends Thread {
    /**
     * 重写run方法，这是线程执行的代码。
     * 线程开始执行时，会调用run方法中的代码。
     */
    @Override
    public void run() {
        // 子线程执行一个循环，输出1000000次
        for (int i = 0; i < 1000000; i++) {
            System.out.println("My Thread " + i + " is running.");
        }
    }
}
