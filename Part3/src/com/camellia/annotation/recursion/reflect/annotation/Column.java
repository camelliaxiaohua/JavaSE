package com.camellia.annotation.recursion.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Column注解用来标注类中的属性，被标注的属性参与建表。
 * @Datetime: 2024/6/26下午7:50
 * author: Camellia.xioahua
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    /**
     * 字段的名字
     * @return 字段的名字
     */
    String name();

    /**
     * 字段的类型
     * @return 字段的类型
     */
    String type() default "varchar";
}
