package com.camellia.io.decorator.package03;

// 被装饰者
public class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("Bird fly!");
    }
}
