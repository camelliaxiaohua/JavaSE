package com.camellia.reflect.reflect.generics.parent.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取父类的泛型信息
 */
public class Test {
    public static void main(String[] args) {
        //获取类
        Class<Cat> catClass = Cat.class;
        //获取当前类父类的泛型
        Type genericSuperclass = catClass.getGenericSuperclass();
        //如果父类使用了泛型
        if (genericSuperclass instanceof ParameterizedType) {
            //转型为参数换类型
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
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
