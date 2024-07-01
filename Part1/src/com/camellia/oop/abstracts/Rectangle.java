package com.camellia.oop.abstracts;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(String name, String color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void area() {
        System.out.println("Area of Rectangle"+this.height*this.width);
    }
}
