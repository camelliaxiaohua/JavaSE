package com.camellia.io.decorator.package01;

public class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("Bird fly!");
    }
}
