package com.camellia.annotation.custom.annotation;

/**
 * 如果注解中只有一个属性，并且该属性名为`value`，在使用注解时，可以省略属性名，直接赋值。
 */
public @interface OnlyValue {
    String value();
}
