package com.camellia.oop.class6;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("小吴");
        System.out.println("main---->"+s1);
        s1.study();
        Student s2 = new Student("小花");
        System.out.println("main---->"+s2);
        s2.study();
    }
}
