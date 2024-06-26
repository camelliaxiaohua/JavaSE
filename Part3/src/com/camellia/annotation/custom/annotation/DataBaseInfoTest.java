package com.camellia.annotation.custom.annotation;
/**
 * 使用自定义的注解：@DataBaseInfo
 */
public class DataBaseInfoTest {
    //在Java中，注解可以包含属性，属性必须在使用注解时赋值，除非在定义注解时为属性指定了默认值。
    //使用注解时，按照@注解名(属性名=值, 属性名=值, ...)的语法进行赋值。
    @DataBaseInfo(url = "jdbc:mysql://localhost:3306/learndb", //给了默认值也可替换。
                  user = "root",
                  password = "24211",
                  names={"camellia","xiaohua","China"},//数组赋值
                  clazz=Integer.class, //Class类
                  season=Season.WINTER)  //枚举
    public void connDB(){

    }
}
