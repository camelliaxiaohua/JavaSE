package com.camellia.thread.ThreadedCommunication;

public class AlternatePrinting {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new PrintTask(printer, 1));
        Thread t2 = new Thread(new PrintTask(printer, 2));
        Thread t3 = new Thread(new PrintTask(printer, 3));

        t1.start();
        t2.start();
        t3.start();
    }
}

class Printer {
    private int currentThread = 1;
    private final Object lock = new Object();

    public void print(int threadId, int number) {
        synchronized (lock) {
            while (currentThread != threadId) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread " + threadId + ": " + number);

            if (currentThread == 1) currentThread = 2;
            else if (currentThread == 2) currentThread = 3;
            else if (currentThread == 3) currentThread = 1;

            lock.notifyAll();
        }
    }
}

class PrintTask implements Runnable {
    private Printer printer;
    private int threadId;
    private static final int MAX_COUNT = 10;

    public PrintTask(Printer printer, int threadId) {
        this.printer = printer;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        int count = 1;
        while (count <= MAX_COUNT) {
            printer.print(threadId, count++);
        }
    }
}
