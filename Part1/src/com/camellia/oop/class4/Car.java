package com.camellia.oop.class4;

public class Car {
    private String brand;
    private int price;
    private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price>500000||price<200000){
            System.out.println("价格不合理");
            return;
        }
        else this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
