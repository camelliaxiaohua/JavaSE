package com.camellia.oop.class4;

public class Account {
    private String accountName;
    private double balance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance<0){
            System.out.println("存款不得小于0");
            return;
        }
        this.balance = balance;
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("余额不足");
            return;
        }
        else balance-=amount;
    }
}
