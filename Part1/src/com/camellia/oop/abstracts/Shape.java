package com.camellia.oop.abstracts;

abstract public  class Shape {
    private String name="未知";
    private String color="未知";
    abstract public void area();
    public void display(){
        System.out.println(this.name+" "+this.color);
    }

    public Shape() {
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
