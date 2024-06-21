package com.camellia.thread.ImplementingMultiThreading;

import org.junit.jupiter.api.Test;

/**
 * 本类展示了如何使用匿名内部类来实现多线程编程。
 * 在Java中，匿名内部类是一种快速实现接口或继承类的一种方式，不需要显式地定义类。
 */
public class AnonymousThreadByRunnable {

    /**
     * 测试方法，演示如何通过匿名内部类实现`Runnable`接口并创建一个线程。
     * 这个方法中创建了一个新的线程，该线程执行一个循环，输出1000次。
     *
     * 主线程和新线程同时运行，演示了并行执行。
     */
    @Test
    public void testAnonymousThreadByRunnable01() {
        Thread thread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("my thread is running\t" + i);
                }
            }
        });
        thread.start();

        // 主线程执行一个循环，输出1000次
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main is running\t" + i);
        }
    }

    /**
     * 测试方法，另一种方式演示如何通过匿名内部类实现`Runnable`接口并启动一个新线程。
     * 这里直接在新线程中创建并启动了一个匿名Runnable对象。
     */
    @Test
    public void testAnonymousThreadByRunnable02() {
        // 创建并启动一个新线程，执行一个循环，输出1000次
        new Thread(new MyRunnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("my thread is running\t" + i);
                }
            }
        }).start();

        // 主线程执行一个循环，输出1000次
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main is running\t" + i);
        }
    }
}
