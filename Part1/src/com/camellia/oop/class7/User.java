package com.camellia.oop.class7;

public class User {
    //用户id
    private String id;
    //用户国籍
    private String country="China";

    public User() {
    }

    public User(String id) {
        this.id = id;
    }
    public void PrintInfo(){
        System.out.println("ID: " + id+"\tCountry: " + country);
    }
}
