package com.camellia.oop.class4;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setAccountName("Camellia");
        account1.setBalance(5000);
        account1.withdraw(4500);
        System.out.println(account1.getAccountName());
        System.out.println(account1.getBalance());
    }
}
