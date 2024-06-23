package com.camellia.thread.ThreadPriority;

/**
 * 线程同步机制的面试题：分析以下程序 m2 方法在执行的时候，需要等待 m1 方法的结束吗？
 *      不需要
 *
 * 这里有mc1,mc2两把锁。而且t1只抢夺mc1，t2只抢夺mc2。所以各自加锁不会影响对方。
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        MyClass3 mc1 = new MyClass3();
        MyClass3 mc2 = new MyClass3();
        Thread t1 = new Thread(new MyRunnable3(mc1));
        Thread t2 = new Thread(new MyRunnable3(mc2));

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}

class MyRunnable3 implements Runnable {

    private MyClass3 mc;

    public MyRunnable3(MyClass3 mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        if("t1".equals(Thread.currentThread().getName())){
            mc.m1();
        }
        if("t2".equals(Thread.currentThread().getName())){
            mc.m2();
        }
    }
}

class MyClass3 {
    public synchronized void m1(){
        System.out.println("m1 begin");
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m1 over");
    }

    public synchronized void m2(){
        System.out.println("m2 begin");
        System.out.println("m2 over");
    }
}