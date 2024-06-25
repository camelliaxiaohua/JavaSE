package com.camellia.reflect.field;

import java.lang.reflect.Field;

/**
 * 1. 反射为对象属性赋值
 */
public class ReflectObjectAssignment {
    public static void main(String[] args) {
        try {
            //获取类
            Class<?> clazz = Class.forName("com.camellia.reflect.field.Customer");
            Customer customer = (Customer) clazz.newInstance();
            //获取对应的Field
            Field ageField = clazz.getDeclaredField("age");
            //调用方法打破封装（可以访问私有属性）。用于绕过 Java 语言访问控制检查，使得可以访问和修改私有字段、方法和构造函数。
            ageField.setAccessible(true);
            //修改属性的值。
            //给对象属性赋值三要素：对象（customer）、属性（ageField）、赋值（23）。
            ageField.set(customer,23);
            // 读取属性值
            System.out.println(ageField.get(customer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
