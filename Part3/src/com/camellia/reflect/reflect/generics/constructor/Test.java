package com.camellia.reflect.reflect.generics.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取构造方法参数泛型
 */
public class Test {
    public static void main(String[] args) {
        //获取类
        Class<MyClass> myClassClass = MyClass.class;
        //获取构造方法,可能有多个构造方法
        Constructor<?>[] constructors = myClassClass.getDeclaredConstructors();
        //循环遍历构造方法
        for (Constructor<?> constructor : constructors) {
            //获取当前构造方法参数上的泛型
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            //参数有多个，可能有多个泛型
            for (Type genericParameterType : genericParameterTypes) {
                //如果使用了泛型
                if (genericParameterType instanceof ParameterizedType) {
                    //转型为参数换类型
                    ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                    //获取泛型数组
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    //遍历泛型数组
                    for (Type actualTypeArgument : actualTypeArguments) {
                        //获取泛型具体类型名
                        System.out.println(actualTypeArgument.getTypeName());
                    }
                }
            }
        }

    }
}
