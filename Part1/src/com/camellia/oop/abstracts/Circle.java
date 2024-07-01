package com.camellia.oop.abstracts;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }
    public Circle(String name,String color,double radius) {
        super(name,color);
        this.radius = radius;
    }
    @Override
    public void area() {
        System.out.println("Area of circle:"+ Constant.IP*this.radius*this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
