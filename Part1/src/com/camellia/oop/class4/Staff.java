package com.camellia.oop.class4;

public class Staff {
    private String name;
    private int age;
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary<800){
            System.out.println("工资不可低于800");
            return;
        }
        this.salary = salary;
    }
    public void raiseSalary(double raise){
        if(salary>10000){
            System.out.println("工资已超过10000，不在涨薪资。");
            return;
        }
        salary+=raise;
    }
}
