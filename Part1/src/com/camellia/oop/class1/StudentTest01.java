package com.camellia.oop.class1;

public class StudentTest01 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name="Camellia.xiaohua";
        s1.age=18;
        s1.gender=true;
        System.out.println(s1);
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.gender?"男":"女");
    }
}
