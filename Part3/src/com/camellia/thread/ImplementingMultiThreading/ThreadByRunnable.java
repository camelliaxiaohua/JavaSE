package com.camellia.thread.ImplementingMultiThreading;

/**
 * 本类展示了在Java中实现多线程的第二种方式：
 * 通过实现`java.lang.Runnable`接口来创建和运行线程。
 * 在这个示例中，我们定义了一个实现了`Runnable`接口的类`MyRunnable`，并在主线程中创建并启动了一个线程。
 */
public class ThreadByRunnable {

    /**
     * 程序的入口点。创建并启动一个线程，同时在主线程中执行另一段代码。
     * 通过这种方式，我们可以同时执行多个任务，实现多线程编程。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个实现了Runnable接口的对象
        Runnable runnable = new MyRunnable();

        // 创建一个Thread对象，并将Runnable对象传递给它
        Thread thread = new Thread(runnable);

        // 启动线程
        thread.start();

        // 这段代码在主线程中执行
        // 主线程执行一个循环，输出100次
        for (int i = 0; i < 100; i++) {
            System.out.println("Main is running.\t" + i);
        }
    }
}

/**
 * 严格来说，这个不是一个线程类
 * 它是一个普通的类，只不过实现了一个Runnable接口。
 * 实现Runnable接口意味着这个类可以作为线程执行的任务。
 */
class MyRunnable implements Runnable {

    /**
     * 实现Runnable接口中的run方法。
     * 当线程启动时，会调用run方法中的代码。
     */
    @Override
    public void run() {
        // 子线程执行一个循环，输出100次
        for (int i = 0; i < 100; i++) {
            System.out.println("My thread is running.\t" + i);
        }
    }
}
