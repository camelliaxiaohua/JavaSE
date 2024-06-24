package com.camellia.thread.ImplementingMultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式：实现Callable接口，实现call方法。
 * 该方式实现的线程可以获取返回值。
 */
public class ThreadByCallable {
    public static void main(String[] args) {
        //创建未来任务对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 0;
            }
        });
        //创建线程对象
        Thread thread = new Thread(futureTask);
        thread.setName("Camellia");
        //启动线程
        thread.start();
        //获取未来任务线程的返回值。由于要获取未来线程返回值，所以该方法会阻塞当前线程，直到拿到未来线程返回值。
        //类似于join
        try {
            Integer i = futureTask.get();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
