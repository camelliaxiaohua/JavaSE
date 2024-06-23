package com.camellia.thread.ThreadPriority;

public class SetThreadPriority {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        //总体thread1抢到时间片几率更大，执行更靠前。
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i=0;i<1000;i++) {
            System.out.println(Thread.currentThread().getName() +"\t"+ i );
        }
    }
}