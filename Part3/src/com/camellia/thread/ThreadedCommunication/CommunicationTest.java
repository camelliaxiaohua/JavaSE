package com.camellia.thread.ThreadedCommunication;

public class CommunicationTest {
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread thread1 = new Thread(runnable); // 指定线程名
        Thread thread2 = new Thread(runnable); // 指定线程名
        Thread thread3 = new Thread(runnable); // 指定线程名
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TestRunnable implements Runnable {
    private int count = 10;
    private boolean t1Lock = true; // 初始时Thread-0先执行
    private boolean t2Lock = false; // 初始时Thread-1等待
    private boolean t3Lock = false; // 初始时Thread-2等待

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 释放被阻塞的线程，唤醒可能等待的线程
                this.notify();

                // 如果计数小于等于0，退出循环，线程结束
                if (count <= 0)
                    break;

                // Thread-0执行逻辑
                if (Thread.currentThread().getName().equals("Thread-0") && t1Lock) {
                    t1Lock = false;
                    t2Lock = true; // 等待Thread-1执行
                    System.out.println(Thread.currentThread().getName() + "\t:\t" + "A");
                    try {
                        this.wait(); // Thread-0等待，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Thread-1执行逻辑
                if (Thread.currentThread().getName().equals("Thread-1") && t2Lock) {
                    t2Lock = false;
                    t3Lock = true; // 等待Thread-2执行
                    System.out.println(Thread.currentThread().getName() + "\t:\t" + "B");
                    try {
                        this.wait(); // Thread-1等待，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Thread-2执行逻辑
                if (Thread.currentThread().getName().equals("Thread-2") && t3Lock) {
                    t3Lock = false;
                    t1Lock = true; // 等待Thread-0执行
                    count--; // 每次Thread-2执行后计数减一
                    System.out.println(Thread.currentThread().getName() + "\t:\t" + "C");
                    try {
                        this.wait(); // Thread-2等待，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
