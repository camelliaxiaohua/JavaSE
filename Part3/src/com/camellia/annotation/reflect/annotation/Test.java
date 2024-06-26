package com.camellia.annotation.reflect.annotation;

import java.lang.annotation.Annotation;

/**
 * @Datetime: 2024/6/26下午7:03
 * @author: Camellia.xioahua
 */
public class Test {
    public static void main(String[] args) {
        // 获取类
        Class<MyClass> mcClass = MyClass.class;
        // 获取类上的所有注解
        Annotation[] annotations = mcClass.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }

        // 判断该类上是否存在这个注解
        if(mcClass.isAnnotationPresent(Annotation1.class)){
            // 获取指定的某个注解
            Annotation1 a1 = mcClass.getAnnotation(Annotation1.class);
            // 访问注解对象中的属性
            System.out.println(a1.name());
            System.out.println(a1.age());
        }

        if(mcClass.isAnnotationPresent(Annotation2.class)){
            Annotation2 a2 = mcClass.getAnnotation(Annotation2.class);
            System.out.println(a2.email());
            System.out.println(a2.price());
        }

    }
}
