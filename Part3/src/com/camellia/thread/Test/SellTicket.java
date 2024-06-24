package com.camellia.thread.Test;

public class SellTicket {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class MyRunnable implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket <= 0) {
                    System.out.println("车票已售空 . . .");
                    break;
                } else {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩" + (--ticket));
                    Thread.yield();
                }
            }
        }
    }
}