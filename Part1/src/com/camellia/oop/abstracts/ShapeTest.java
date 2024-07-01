package com.camellia.oop.abstracts;

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle("圆形","绿色",3);
        circle.display();
        circle.area();
        Rectangle rectangle = new Rectangle("矩形", "粉色", 20, 30);
        rectangle.display();
        rectangle.area();
    }
}
