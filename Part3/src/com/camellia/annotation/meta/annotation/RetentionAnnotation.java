package com.camellia.annotation.meta.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Retention(value = RetentionPolicy.SOURCE) //@RetentionAnnotation 注解保留在源码中。
 * @Retention(RetentionPolicy.CLASS)//@RetentionAnnotation 注解保留在字节码中，这是默认的行为，但不能被反射。
 * @Retention(value = RetentionPolicy.RUNTIME)//@RetentionAnnotation 注解保留在字节码中，并且在运行时可以被反射。
 * */
@Retention(RetentionPolicy.RUNTIME)
@Inherited //RetentionAnnotation能够被继承
public @interface RetentionAnnotation {

}
