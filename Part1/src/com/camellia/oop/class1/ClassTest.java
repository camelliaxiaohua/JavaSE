package com.camellia.oop.class1;

/**
 * @Datetime: 2024/7/1下午9:51
 * @author: Camellia.xioahua
 */
public class ClassTest {
    public static void main(String[] args) {
        Camellia camellia = new Camellia();
    }
}

class Camellia{



    {
        System.out.println("构造代码块执行");
    }

    static {
        System.out.println("静态代码块执行");
    }

    Camellia(){
        System.out.println("无参构造方法执行");
    }
}
