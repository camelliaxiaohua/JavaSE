package com.camellia.thread.ThreadSafe;

/**
 * 演示出多线程带来的并发安全问题(异步）
 */
public class ThreadSafe {
    public static void main(String[] args) {
        // 创建账户对象
        AccountSolve act = new AccountSolve("act-001", 10000);
        // 创建线程对象1
        Thread t1 = new Thread(new WithdrawSolve(act));
        // 创建线程对象2
        Thread t2 = new Thread(new WithdrawSolve(act));
        // 启动线程
        t1.start();
        t2.start();
    }
}

/**
 * 取款线程
 */
class Withdraw implements Runnable {

    //实例变量（共享数据）
    private AccountSolve act;

    public Withdraw(AccountSolve act) {
        this.act = act;
    }

    @Override
    public void run() {
        this.act.withdraw(1000);
    }
}


/**
 * 银行账户
 */
class Account{

    private String actNo;
    private double balance;

    public Account() {}

    public Account(String actNo, double balance) {
        this.actNo = actNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    /**
     * 取款方法
     * @param money 取款额度
     */
    public void withdraw(double money) {
        //为了演示出多线程带来的并发安全问题，这里将分为两步完成取款操作。
        //第一步：取余额
        double before = this.balance;
        System.out.println(Thread.currentThread().getName() + "线程正在取款"+money+"，当前"+this.getActNo()+"账户余额" + before);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //第二步：修改余额
        this.setBalance(before-money);
        System.out.println(Thread.currentThread().getName() + "线程取款成功，当前"+this.getActNo()+"账户余额" + this.getBalance());
    }
}