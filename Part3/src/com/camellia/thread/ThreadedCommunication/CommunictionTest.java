package com.camellia.thread.ThreadedCommunication;

public class CommunictionTest {
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TestRunnable implements Runnable {
    private int count = 10;
    private boolean t1Lock = true;
    private boolean t2Lock = false;
    private boolean t3Lock = false;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                // 释放被阻塞的线程，所以进来的即使不符合也不会占用，同时也唤醒wait的线程。
                this.notify();
                if (count <=0)break;
                if(Thread.currentThread().getName().equals("Thread-0")&&t1Lock){
                    t1Lock = false;
                    t2Lock = true;
                    System.out.println(Thread.currentThread().getName()+"\t:\t"+"A");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(Thread.currentThread().getName().equals("Thread-1")&&t2Lock){
                    t2Lock = false;
                    t3Lock = true;
                    System.out.println(Thread.currentThread().getName()+"\t:\t"+"B");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(Thread.currentThread().getName().equals("Thread-2")&&t3Lock){
                    t3Lock = false;
                    t1Lock = true;
                    count--;
                    System.out.println(Thread.currentThread().getName()+"\t:\t"+"C");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}