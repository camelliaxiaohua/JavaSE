package com.camellia.reflect.reflect.generics.method.parameters;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 获取方法参数上的类型信息
 */
public class Test {
    public static void main(String[] args) {
        //获取类
        Class<MyClass> myClassClass = MyClass.class;
        try {
            //获取方法
            Method method = myClassClass.getDeclaredMethod("m", List.class);
            //获取方法参数上的泛型
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            //参数有多个，可能有多个泛型
            for (Type genericParameterType : genericParameterTypes) {
                //如果父类使用了泛型
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

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }
}
