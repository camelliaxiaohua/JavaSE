package com.camellia.thread.DaemonThread;

/**
 * <p>
 * 1. 在Java中，线程分为两种主要类型：
 *    - 用户线程（非守护线程）
 *    - 守护线程（后台线程）
 * <p>
 * 2. 在JVM中，始终存在一个隐藏的守护线程，即垃圾回收器（GC）线程。
 * <p>
 * 3. 守护线程的特点是：
 *    - 当所有用户线程结束时，守护线程会自动终止。
 * <p>
 * 4. 如何将线程设置为守护线程：
 *    - 在启动线程之前使用 setDaemon(true) 方法将其设置为守护线程。
 */
public class DaemonThreadTest {

    /**
     * 主方法演示Java中守护线程的使用。
     * @param args 命令行参数（在此示例中未使用）
     */
    public static void main(String[] args) {
        // 创建 MyThread 的实例
        MyThread myThread = new MyThread();
        // 在启动线程之前将其设置为守护线程
        myThread.setDaemon(true);
        myThread.start();

        // 主线程（用户线程）
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
            try {
                Thread.sleep(1000); // 线程休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 虽然 MyThread 执行了一个无限循环，但设置为守护线程意味着当所有用户线程（如主线程）结束时它会终止。
    }
}

/**
 * MyThread 类继承自 Thread，演示了简单的守护线程行为。
 */
class MyThread extends Thread {

    /**
     * 线程启动后执行的 run 方法。
     */
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "\t" + (++i));
        }
    }
}
