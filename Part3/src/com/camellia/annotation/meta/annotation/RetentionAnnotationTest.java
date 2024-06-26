package com.camellia.annotation.meta.annotation;
@RetentionAnnotation// 这个注解会被保留到字节码中，并且在运行时可以被反射。
public class RetentionAnnotationTest {
    public static void main(String[] args) {
        // 获取这个类
        Class<RetentionAnnotationTest> testClass = RetentionAnnotationTest.class;
        // 获取这个类上的注解
        RetentionAnnotation annotation = testClass.getAnnotation(RetentionAnnotation.class);
        // java.lang.annotation.Annotation是所有注解的老祖宗。
        System.out.println(annotation);
    }
}
