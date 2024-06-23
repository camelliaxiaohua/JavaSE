package com.camellia.thread.sleep;

/**
 * 如何解除线程的睡眠（怎么解除线程因sleep导致的阻塞，让其开始抢夺CPU时间片。）
 */
public class ThreadSleep03 {

    /**
     * 程序的入口点。
     * 演示了如何通过interrupt方法解除线程的睡眠状态。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建并启动线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " begin");
                try {
                    // 线程休眠一年
                    Thread.sleep(1000 * 60 * 60 * 24 * 365);
                } catch (InterruptedException e) {
                    // 捕获InterruptedException异常，并终止休眠
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                }
                // 睡眠一年后或者被中断后，继续执行
                System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
            }
        });
        thread.start();

        // 主线程
        // 需求：5秒后，唤醒正在睡眠的Thread-0线程
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 使用interrupt方法中断线程的睡眠
        // interrupt是实例方法，哪个实例对象调用就终止哪个线程的睡眠。
        // 底层实现原理是利用了异常处理机制：
        // 当调用interrupt方法时，如果线程正在睡眠，会抛出InterruptedException异常，然后捕获异常终止睡眠。
        //如果在catch子句中继续抛出异常则不会中断，因为抛出异常等于没处理。
        //可以打印异常信息，也可以自定义语句。
        thread.interrupt();
    }
}
