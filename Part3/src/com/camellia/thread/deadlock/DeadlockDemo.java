package com.camellia.thread.deadlock;

/**
 * 死锁演示
 */
public class DeadlockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new MyRunnable(lock1,lock2));
        Thread t2 = new Thread(new MyRunnable(lock1,lock2));
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    private Object o1;
    private Object o2;

    public MyRunnable(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            synchronized (o1){
                //休眠一秒，构成死锁。
                try {
                    Thread.sleep(1000);
                    synchronized (o2){}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            //彼此相互等待对方掌握的资源，构成死锁。
            synchronized (o2){
                synchronized (o1){}
            }
        }
    }
}
