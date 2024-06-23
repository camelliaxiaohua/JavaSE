package com.camellia.thread.ThreadPriority;

import org.junit.jupiter.api.Test;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        System.out.println("线程最低优先级："+Thread.MIN_PRIORITY);
        System.out.println("线程的最高优先级"+Thread.MAX_PRIORITY);
        System.out.println("线程的默认优先级"+Thread.NORM_PRIORITY);
    }

    @Test
    public void testThreadPriority() {
        //获取main线程的优先级
        Thread mainThread = Thread.currentThread();
        System.out.println("main线程的优先级"+mainThread.getPriority());
        //设置优先级
        mainThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("main线程的优先级"+mainThread.getPriority());
    }
}

