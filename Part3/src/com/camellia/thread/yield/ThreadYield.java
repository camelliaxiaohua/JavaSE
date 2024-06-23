package com.camellia.thread.yield;

public class ThreadYield {
    public static void main(String[] args) {
        Thread thread0 = new MyThread();
        Thread thread1 = new MyThread();
        thread0.start();
        thread1.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            //当前线程为Thread-0，并且是10的倍数就让位。
            if(Thread.currentThread().getName().equals("Thread-0")&& (i%10 == 0)){
                System.out.println(Thread.currentThread().getName()+"进行了让位，此时的i下标为：\t"+i);
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+i);
        }
    }
}