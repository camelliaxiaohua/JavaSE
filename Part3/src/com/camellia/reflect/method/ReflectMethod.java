package com.camellia.reflect.method;

import java.lang.reflect.*;

/**
 * 反射获取方法以及信息
 */
public class ReflectMethod {
    public static void main(String[] args) {
        try {
            //获取类
            Class<?> clazz = Class.forName("com.camellia.reflect.method.UserService");
            //获取所有的方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                //方法修饰符
                System.out.println(Modifier.toString(method.getModifiers()));
                //方法返回值类型
                System.out.println(method.getReturnType().getSimpleName());
                //方法名
                System.out.println(method.getName());
                //用getParameterTypes方法获取方法参数列表
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    System.out.println(type.getSimpleName());
                }
                //用Parameter方法获取方法参数列表
                useParameter(methods);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void useParameter(Method[] methods) {
        for (Method method : methods) {
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                //获取参数列表类型的简类名
                System.out.println(parameter.getType().getSimpleName());
                //获取参数的名字
                System.out.println(parameter.getName());
            }
        }
    }
}
