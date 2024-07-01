package com.camellia.oop.class4;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("奔驰E300L");
        car.setColor("blue");
        car.setPrice(450000);
        System.out.println(car.getBrand());
        System.out.println(car.getColor());
        System.out.println(car.getPrice());
    }
}
