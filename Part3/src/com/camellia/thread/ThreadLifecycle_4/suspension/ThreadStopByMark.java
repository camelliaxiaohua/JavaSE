package com.camellia.thread.ThreadLifecycle_4.suspension;

/**
 * 如何合理的以正常的方式终止一个线程的执行？
 * - 在实际开发中采用打标记的方式来终止一个线程。
 */
public class ThreadStopByMark {
    public static void main(String[] args) {
        MyThread runnable = new MyThread();
        Thread thread = new Thread(runnable);
        thread.start();
        //5秒后停止
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终止线程执行
        runnable.running = false;
    }
}

class MyThread implements Runnable {
    /**
     * 是否继续执行的标记
     * true：继续执行
     * false：停止执行
     */
    boolean running = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (running) {
                System.out.println(Thread.currentThread().getName() + i + "\tis running");
                try {
                    Thread.sleep(1000 * 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(Thread.currentThread().getName() + i + "\tis stopped");
                return;
            }
        }
    }
}
