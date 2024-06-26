package com.camellia.reflect.constructor;

import java.lang.reflect.Constructor;

/**
 * 通过反射机制创建对象
 *    - 采用Object obj = clazz.newInstance()方式创建对象必须有一个无参数构造方法，如果没有会出现异常。
 *    - 在Java9的时候，这个方法被标注了已过时。不建议使用了。
 */
public class ReflectionCreatesObject {
    public static void main(String[] args) {
        try {
            //获取类
            Class<?> clazz = Class.forName("java.util.Date");
            //获取无参数构造方法
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            //调用无参构造方法实例化对象
            Object object = declaredConstructor.newInstance();
            System.out.println(object);
            //获取有参构造方法
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class, int.class);
            Object object1 = constructor.newInstance(2024, 6, 25);
            System.out.println(object1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
