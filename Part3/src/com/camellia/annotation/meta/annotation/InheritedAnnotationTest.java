package com.camellia.annotation.meta.annotation;

/**
 * @Datetime: 2024/6/26下午5:23
 * @author: Camellia.xioahua
 */
public class InheritedAnnotationTest {
    public static void main(String[] args) {
        Class<InheritedSub> subClass = InheritedSub.class;
        RetentionAnnotation annotation = subClass.getAnnotation(RetentionAnnotation.class);
        System.out.println(annotation);
    }
}
