package com.camellia.thread.SingletonPattern;

/**
 * 饿汉式单例模式
 */
public class HungrySingleton {

    private static HungrySingleton instance  = new HungrySingleton();
    private HungrySingleton() {

    }
    public static HungrySingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton1 == hungrySingleton2);
    }
}

