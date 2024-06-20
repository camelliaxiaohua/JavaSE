package com.camellia.io.decorator.package02;

// 被装饰者
public class Cat implements Flyable {
    @Override
    public void fly() {
        System.out.println("Cat fly!");
    }
}
