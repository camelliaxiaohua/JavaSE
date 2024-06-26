package com.camellia.annotation.custom.annotation;

public @interface DataBaseInfo {
    //注解也可以定义属性，但是属性定义时有要求，属性名后面必须添加：()
    //语法: 属性的类型 属性的名字();
    String driver() default "com.mysql.jdbc.Driver";
    String url() default "jdbc:mysql://localhost:3306/camellia";
    String user();
    String password();

    //自定义注解类型
    byte b() default 1;
    short s() default 2;
    int i() default 3;
    long l() default 4;
    float f() default 5.0f;
    double d() default 6.0;
    boolean bool() default true;
    char ch() default 'A';
    String string() default "abc";
    Class clazz() default Object.class;
    Season season() default Season.SPRING;
    CustomAnnotation1 myAnnotation() default @CustomAnnotation1();
    // 注解的属性的数据类型，必须是以上的几种类型，或者这几种类型的一维数组，不能是其他类型。

    /**
     * 可以是一维数组
     * @return
     */
    String[] names();
}
