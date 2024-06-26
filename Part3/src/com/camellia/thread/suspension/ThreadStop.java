package com.camellia.thread.suspension;

/**
 * 如何停止线程？
 */
public class ThreadStop {
    public static void main(String[] args) {
        Thread thread = new Thread(new Mythread());
        thread.setName("T线程");
        thread.start();
        //5秒后停止
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //这方法已经淘汰了，Java21测试已经不能关闭了。
        //thread.stop();
    }
}

class Mythread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000*1);
            for(int i= 0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}