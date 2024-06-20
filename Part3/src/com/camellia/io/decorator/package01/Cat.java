package com.camellia.io.decorator.package01;

public class Cat implements Flyable{
    @Override
    public void fly() {
        System.out.println("Cat fly");
    }
}
