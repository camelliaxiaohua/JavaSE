package com.camellia.annotation.custom.annotation;

/**
 * 以下是使用注解的过程。
 */
public class CustomAnnotationTest {
    @CustomAnnotation1
    private String name;

    @CustomAnnotation1
    public void doSome(){

    }

    public void doOther(@CustomAnnotation1 String name, @CustomAnnotation1 String password){

    }

    public void toDo(
            @CustomAnnotation1
            String name,
            @CustomAnnotation1
            String password){

    }
}
