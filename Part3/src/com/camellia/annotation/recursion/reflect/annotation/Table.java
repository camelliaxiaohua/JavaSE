package com.camellia.annotation.recursion.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 被@Table注解标注的类参与生成建表语句。
 * @Datetime: 2024/6/26下午7:43
 * @author: Camellia.xioahua
 */

@Target(ElementType.TYPE) //设置@Table注解只能出现在类上。
@Retention(RetentionPolicy.RUNTIME) //保持被反射机制读取。
public @interface Table {
    /**
     * 用来指定表的名字
     * @return 表的名字
     */
    String value();
}
