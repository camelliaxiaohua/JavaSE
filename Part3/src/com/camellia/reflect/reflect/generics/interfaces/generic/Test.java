package com.camellia.reflect.reflect.generics.interfaces.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
    public static void main(String[] args) {
        //获取类
        Class<Bird> birdClass = Bird.class;
        //获取当前父接口的泛型,单继承多实现。
        Type[] genericInterfaces = birdClass.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            //如果父接口使用了泛型
            if(genericInterface instanceof ParameterizedType){
                //转型为参数换类型
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                //获取泛型数组
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    //获取泛型具体类型名
                    System.out.println(actualTypeArgument.getTypeName());
                }
            }
        }

    }
}
