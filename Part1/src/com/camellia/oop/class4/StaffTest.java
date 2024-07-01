package com.camellia.oop.class4;

public class StaffTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.setName("Dary");
        staff.setAge(20);
        staff.setSalary(5000);
        staff.raiseSalary(6000);
        System.out.println(staff.getName());
        System.out.println(staff.getAge());
        System.out.println(staff.getSalary());
    }
}
