package com.camellia.singleton.lazy;

public class SingletionTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);   //比较引用存储的对象地址。
    }
}
