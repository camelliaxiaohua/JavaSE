package com.camellia.reflect.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class DecompileConstructor {
    public static void main(String[] args) throws Exception{
        // 获取类
        Class clazz = Class.forName("java.lang.String");
        // 获取所有的构造方法
        Constructor[] cons = clazz.getDeclaredConstructors();
        // 遍历所有的构造方法
        for(Constructor con : cons){
            // 构造方法修饰符
            System.out.println(Modifier.toString(con.getModifiers()));
            // 构造方法名
            System.out.println(con.getName());
            // 构造方法参数列表
            Parameter[] parameters = con.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                //构造方法参数类型
                System.out.println(parameter.getType().getName());
                //构造方法参数名
                System.out.println(parameter.getName());
            }
        }
    }
}
