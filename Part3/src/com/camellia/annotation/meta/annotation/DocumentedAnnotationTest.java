package com.camellia.annotation.meta.annotation;

/**
 * ClassName: Test
 * Description: 描述信息
 * @author: Camellia.xioahua
 * @Datetime: 时间
 * @Version: 版本
 */
@DocumentedAnnotation
public class DocumentedAnnotationTest {

    @DocumentedAnnotation
    public static int num = 100;

    @DocumentedAnnotation
    public void doSome(){

    }

    @DocumentedAnnotation
    public DocumentedAnnotationTest() {

    }
}
