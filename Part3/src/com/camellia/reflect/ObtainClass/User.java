package com.camellia.reflect.ObtainClass;

public class User {
    private String name;
    private int age;

    static {
        System.out.println("User initialized");
    }
    public User() {
        System.out.println("User类的无参数构造方法执行了");
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
