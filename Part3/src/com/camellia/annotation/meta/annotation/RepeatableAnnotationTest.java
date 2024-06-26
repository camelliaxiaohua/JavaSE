package com.camellia.annotation.meta.annotation;

/**
 * @Datetime: 2024/6/26下午5:37
 * @author: Camellia.xioahua
 */
public class RepeatableAnnotationTest {

    @RepeatableAnnotation(name = "Camellia.xiaohua")
    @RepeatableAnnotation(name = "Flower")
    public void doSome(){

    }
}
