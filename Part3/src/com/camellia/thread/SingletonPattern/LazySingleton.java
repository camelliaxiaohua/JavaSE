package com.camellia.thread.SingletonPattern;

/**
 * 懒汉式单例模式
 * 需要考虑线程安全问题
 *   - 在实例方法上添加关键字synchronized。
 *   - 在new对象的代码块添加synchronized。
 *
 * 该版本仍不完善，缺乏指令重排。
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {

    }
    public static  LazySingleton getInstance() {
        //这里会引发线程安全问题，如果有多个线程同时进入就会创建对个对象。
        if(instance == null) { //改善，避免每次检查。
            synchronized (LazySingleton.class) { // 加类锁。但是有个问题每次执行都需要检查加锁，可我，我们只new一次。
                if (instance == null) {
                    //睡眠两秒，引发线程安全问题。
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 懒汉式线程安全问题测试
 */
class SingletonTest {
    private static LazySingleton lazySingleton1;
    private static LazySingleton lazySingleton2;
    public static void main(String[] args) throws InterruptedException {
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
        thread1.join();
        thread2.join();
        // 判断两个lazySingleton对象是否一样。
        System.out.println(lazySingleton1);
        System.out.println(lazySingleton2);
        System.out.println(lazySingleton1 == lazySingleton2);
    }
}