package com.camellia.thread.ThreadedCommunication;

public class ThreadCount {
    public static void main(String[] args) {
        MyRunnables mr = new MyRunnables();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();
    }
}

class MyRunnables implements Runnable {
    private int count = 1;
    @Override
    public void run() {
        while ((count) < 101) {
        synchronized (this) {
            // 唤醒被阻塞的线程
            this.notify();
            // 模拟延迟
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + (count++));
                try { //让其中一个线程等待。(t1先进来就阻塞t1并归还锁，让外面的t2进来)
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}