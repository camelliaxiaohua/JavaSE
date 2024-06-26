package com.camellia.annotation.reflect.annotation;

/**
 * @Datetime: 2024/6/26下午7:02
 * @author: Camellia.xioahua
 */
@Annotation1(name="zhangsan22222", age=3333)
@Annotation2(email="zhangsan@123.com", price = 3000.5)
public class MyClass {

    @Annotation1
    @Annotation2
    String s;

    @Annotation1
    @Annotation2
    public void doSome(){

    }

}