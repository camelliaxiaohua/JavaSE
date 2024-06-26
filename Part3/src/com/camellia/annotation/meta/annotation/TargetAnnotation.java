package com.camellia.annotation.meta.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(value = {ElementType.METHOD})
@Target(ElementType.METHOD) //限定注解只能出现在方法上
public @interface TargetAnnotation {
}
