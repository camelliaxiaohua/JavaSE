package com.camellia.reflect.reflect.generics.returns.value;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
    public static void main(String[] args) {
        //获取类
        Class<Myclass> myClassClass = Myclass.class;
        try {
            //获取方法
            Method method = myClassClass.getDeclaredMethod("m");
            //获取方法返回值泛型
            Type genericReturnType = method.getGenericReturnType();
            //如果使用了泛型
            if (genericReturnType instanceof ParameterizedType) {
                //转型为参数换类型
                ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                //获取泛型数组
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                //遍历泛型数组
                for (Type actualTypeArgument : actualTypeArguments) {
                    //获取泛型具体类型名
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}