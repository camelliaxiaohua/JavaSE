package com.camellia.thread.ThreadSafe;

/**
 * 线程同步机制的面试题：分析以下程序 m2 方法在执行的时候，需要等待 m1 方法的结束吗？
 *      需要
 *
 * 线程t1,t2共用一把锁，而且m1和m2方法都添加了synchronized关键字。所以都保持同步机制。
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        // 一把锁
        MyClass2 mc = new MyClass2();
        Thread t1 = new Thread(new MyRunnable2(mc));
        Thread t2 = new Thread(new MyRunnable2(mc));

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

class MyRunnable2 implements Runnable {

    private MyClass2 mc;

    public MyRunnable2(MyClass2 mc) {
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

class MyClass2 {
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

