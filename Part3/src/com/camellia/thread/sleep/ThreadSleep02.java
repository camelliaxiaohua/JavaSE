package com.camellia.thread.sleep;

/**
 * 演示 Thread.sleep() 方法的使用和效果。
 * 说明：Thread.sleep() 是一个静态方法，它让当前线程休眠指定的时间。
 * 虽然可以通过线程实例调用，但实际上是让当前线程休眠，而不是调用线程实例。
 */
public class ThreadSleep02 {

    /**
     * 程序的入口点。
     * 主要演示了Thread.sleep()方法的使用。
     *
     * @param args 命令行参数
     * @throws InterruptedException 当线程在睡眠期间被中断时抛出此异常。
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建线程实例
        Thread t = new MyThread02();
        t.setName("MyThread");

        // 调用sleep方法，让当前线程（即主线程）休眠6秒
        // 虽然是通过线程实例调用，但实际上是让主线程休眠
        Thread.sleep(1000 * 6);

        // 启动线程
        t.start();

        // 判断这个休眠效果作用在哪个线程
        // sleep是静态方法，虽然是用实例调用，但是实际上作用于当前线程
    }
}

/**
 * 自定义的线程类，继承自Thread。
 * 在run方法中打印当前线程的名称和一个计数值。
 */
class MyThread02 extends Thread {

    /**
     * 重写run方法，在线程启动后执行。
     */
    @Override
    public void run() {
        // 循环打印当前线程的名称和计数值
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
