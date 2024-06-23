package com.camellia.thread.ThreadSafe;

/**
 * 线程同步机制的面试题：分析以下程序 m2 方法在执行的时候，需要等待 m1 方法的结束吗？
 *      不需要。
 *
 *  这里只声明了一个对象MyClass mc = new MyClass(),所以多个线程用一把锁。当一个线程执行到有synchronized关键字时，会检查会能否或取锁。
 *  若能获取锁，就加锁执行。若不能，就等待。没有关键字synchronized的方法或代码块不受影响，继续保持异步。
 */
public class ThreadSafeTest1 {
    public static void main(String[] args) {
        // 只声明了一个对象，所以这里就一把锁。
        MyClass mc = new MyClass();
        Thread t1 = new Thread(new MyRunnable(mc));
        Thread t2 = new Thread(new MyRunnable(mc));

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

class MyRunnable implements Runnable {

    private MyClass mc;

    public MyRunnable(MyClass mc) {
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

class MyClass {
    //检查加锁情况
    public synchronized void m1(){
        System.out.println("m1 begin");
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m1 over");
    }
    //保持异步，不受加锁影响。
    public void m2(){
        System.out.println("m2 begin");
        System.out.println("m2 over");
    }
}
