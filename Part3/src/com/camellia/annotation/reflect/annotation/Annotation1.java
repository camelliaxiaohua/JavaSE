package com.camellia.annotation.reflect.annotation;

import java.lang.annotation.*;

/**
 * @Datetime: 2024/6/26下午7:01
 * @author: Camellia.xioahua
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Annotation1 {
    String name() default "";
    int age() default 0;
}