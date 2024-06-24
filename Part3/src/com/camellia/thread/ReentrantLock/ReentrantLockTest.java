package com.camellia.thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock来实现线程安全。
 * Lock是接口，从JDK5引入，
 * Lock接口下有一实现类：可重入锁（ReentrantLock）
 * Lock比synchronized更好，更加灵活。
 */
public class ReentrantLockTest {
    private static LazySingleton lazySingleton1;
    private static LazySingleton lazySingleton2;
    public static void main(String[] args) {
        //创建线程对象thread1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lazySingleton1 = LazySingleton.getInstance();
            }
        });
        //创建线程对象thread2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lazySingleton2 = LazySingleton.getInstance();
            }
        });
        //启动线程
        thread1.start();
        thread2.start();
        //这里有个问题，如不推迟主线程的执行lazySingleton1和lazySingleton2可能还未初始化就走到输出语句。
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 判断两个lazySingleton对象是否一样。
        System.out.println(lazySingleton1);
        System.out.println(lazySingleton2);
        System.out.println(lazySingleton1 == lazySingleton2);
    }
}

class LazySingleton {
    private static LazySingleton instance;

    //注意：要想使用ReentrantLock达到线程安全，假设要让t1 t2 t3线程同步，就需要让t1 t2 t3共享同一个lock。
    private static final ReentrantLock lock = new ReentrantLock();

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        //这里会引发线程安全问题，如果有多个线程同时进入就会创建对个对象。
        if(instance == null) { //改善，避免每次检查。
            try {
                lock.lock(); // 加类锁。但是有个问题每次执行都需要检查加锁，可我，我们只new一次。
                if (instance == null) {
                    //睡眠两秒，引发线程安全问题。
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new LazySingleton();
                }
            } finally {
                //解锁，需要保证一定会执行解锁
                lock.unlock();
            }
        }
        return instance;
    }
}