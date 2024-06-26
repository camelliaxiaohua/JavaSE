package com.camellia.annotation.meta.annotation;

import java.lang.annotation.Repeatable;

/**
 * @Datetime: 2024/6/26下午5:36
 * @author: Camellia.xioahua
 */
@Repeatable(RepeatableAnnotations.class)
public @interface RepeatableAnnotation {
    String name();
}
