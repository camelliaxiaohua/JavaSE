package com.camellia.thread.ThreadSafe;

/**
 * 线程同步机制的面试题：分析以下程序 m2 方法在执行的时候，需要等待 m1 方法的结束吗？
 *      需要等待。
 *
 * 在静态方法上添加synchronized之后，线程会占有类锁。
 * 类锁是，对于一个类来说，只有一把锁。不管创建了多少个对象，类锁只有一把。
 *
 * 静态方法上添加synchronized，实际上是为了保证静态变量的安全。
 * 实例方法上添加synchronized，实际上是为了保证实例变量的安全。
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        MyClass4 mc1 = new MyClass4();
        MyClass4 mc2 = new MyClass4();
        Thread t1 = new Thread(new MyRunnable4(mc1));
        Thread t2 = new Thread(new MyRunnable4(mc2));

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

class MyRunnable4 implements Runnable {

    private MyClass4 mc;

    public MyRunnable4(MyClass4 mc) {
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

class MyClass4 {
    public static synchronized void m1(){
        System.out.println("m1 begin");
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("m1 over");
    }

    public static synchronized void m2(){
        System.out.println("m2 begin");
        System.out.println("m2 over");
    }
}