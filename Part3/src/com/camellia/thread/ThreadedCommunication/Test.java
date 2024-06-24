package com.camellia.thread.ThreadedCommunication;

public class Test {
    public static void main(String[] args) {
        TestRunnable runnable = new TestRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TestRunnable implements Runnable {

    private int count = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                this.notify();
                if(count == 10)break;
                if(Thread.currentThread().getName().equals("Thread-0")){
                    System.out.println(Thread.currentThread().getName()+"-->"+"A");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(Thread.currentThread().getName().equals("Thread-1")){
                    System.out.println(Thread.currentThread().getName()+"-->"+"B");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(Thread.currentThread().getName().equals("Thread-2")){
                    System.out.println(Thread.currentThread().getName()+"-->"+"C");
                    count++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}