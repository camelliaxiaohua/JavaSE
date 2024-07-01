package com.camellia.singleton.hungry;

/**
 * 懒汉模式
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public  static Singleton getInstance(){
        //此处存在线程安全问题,可以在代码块上加锁（synchronized），或者方法上加锁，推荐代码块。
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
