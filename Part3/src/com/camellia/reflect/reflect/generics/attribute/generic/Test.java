package com.camellia.reflect.reflect.generics.attribute.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
    public static void main(String[] args) {
        //获取这个类
        Class<User> userClass = User.class;
        try {
            //获取属性上的泛型，先要获取属性。
            Field field = userClass.getDeclaredField("map");
            //获取属性上的泛型
            Type genericType = field.getGenericType();
            //如果使用了泛型
            if (genericType instanceof ParameterizedType) {
                //转型为参数换类型
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                //获取泛型数组
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                //遍历泛型数组
                for (Type actualTypeArgument : actualTypeArguments) {
                    //获取泛型具体类型名
                    System.out.println(actualTypeArgument);
                }
            }
        } catch (NoSuchFieldException e) {
           e.printStackTrace();
        }
    }
}
