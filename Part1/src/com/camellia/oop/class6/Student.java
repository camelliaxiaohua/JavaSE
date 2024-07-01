package com.camellia.oop.class6;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void study(){
        System.out.println("study---->"+this);
    }
}
