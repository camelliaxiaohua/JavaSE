package com.camellia.thread.ThreadLifecycle_4.sleep;

/**
 * 关于线程的 sleep 方法
 *
 * <p>静态方法 sleep(long millis)
 *
 * <p>方法签名：static void sleep(long millis)
 *
 * <p>说明：
 * <ul>
 *   <li>这是一个静态方法。
 *   <li>没有返回值。
 *   <li>参数是一个毫秒数。1秒 = 1000毫秒。
 * </ul>
 *
 * <p>方法作用
 *
 * <p>让当前线程进入休眠状态，也就是让当前线程放弃占有的CPU时间片，使其进入阻塞状态。
 * <ul>
 *   <li>具体含义：当前线程不再占用CPU，让给其他线程使用。
 *   <li>阻塞时长：根据传入的毫秒参数决定。在指定的时间范围内，当前线程没有权利抢夺CPU时间片。
 * </ul>
 *
 * <p>“当前线程”解释
 *
 * <p>Thread.sleep(1000); 这行代码在哪个线程中执行，那么当前线程就是那个线程。
 *
 * <p>关于 run 方法
 *
 * <p>在重写 run 方法时，不能在方法声明位置使用 throws 抛出异常。
 *
 * <p>使用 sleep 方法的场景
 *
 * <p>sleep 方法可以用来模拟每隔固定时间调用一次程序。
 */
public class ThreadSleep01 {

    /**
     * 程序的入口点。
     * 主线程将在开始时休眠5秒，然后打印出一系列消息。
     * 接着启动一个新的线程，该线程每隔一秒打印一次消息。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            // 让当前线程休眠5秒（代码出现在主线程中，所以主线程休眠5秒）
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 主线程输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
        }

        // 创建并启动新的线程
        Runnable myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}

/**
 * 自定义的Runnable实现类。
 * 在run方法中，每隔一秒打印一次消息。
 */
class MyThread implements Runnable {

    /**
     * 实现Runnable接口中的run方法。
     * 当线程启动时，会执行此方法。
     */
    @Override
    public void run() {
        // 子线程输出，每隔一秒打印一次消息
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
            try {
                // 让当前线程休眠1秒
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
