# 可重入锁（ReentrantLock）

Java 的 `ReentrantLock` 是一种实现 `Lock` 接口的锁，它提供了与 `synchronized` 关键字相似的锁定功能，
但它在某些情况下提供了更强大的功能和更大的灵活性。

## 一、主要特点

1. **重入特性**：如果一个线程已经持有了该锁，它可以再次获取锁而不会被阻塞。这与 `synchronized` 块的行为一致。

2. **公平性**：`ReentrantLock` 可以选择是否使用公平锁机制。公平锁是指锁按照请求的顺序（即先到先得）分配，而非公平锁则不保证这一点。公平锁可以通过在创建 `ReentrantLock` 对象时传递 `true` 来实现，例如：`new ReentrantLock(true)`。

3. **显式锁和解锁**：与 `synchronized` 关键字不同，`ReentrantLock` 需要显式地调用 `lock()` 和 `unlock()` 方法来获取和释放锁。这使得开发者在控制锁的获取和释放时有了更大的灵活性，但也增加了使用的复杂性，因为必须确保在所有代码路径上都正确地释放锁。

4. **条件变量**：`ReentrantLock` 提供了条件变量（`Condition`），可以用来实现更复杂的线程间同步。条件变量可以通过 `newCondition()` 方法创建，并提供了 `await()`、`signal()` 和 `signalAll()` 方法，类似于 `Object` 类中的 `wait()`、`notify()` 和 `notifyAll()`。

##  二、使用示例

以下是 `ReentrantLock` 的一个简单使用示例：

```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        lock.lock(); // 获取锁
        try {
            // 临界区代码
            System.out.println("Thread " + Thread.currentThread().getName() + " is performing the task");
            // 执行任务
        } finally {
            lock.unlock(); // 确保在任何情况下都释放锁
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        Runnable task = example::performTask;

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
```

## 三、总结

`ReentrantLock` 提供了比 `synchronized` 更灵活的锁定机制，特别是在需要条件变量和公平锁的场景下。
然而，它的显式锁定和解锁方式也要求开发者更加小心，以避免死锁等问题。在实际开发中，应根据具体需求选择合适的同步机制。

## 四、使用可重入锁实现线程安全的懒汉单例模式

```java
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
```