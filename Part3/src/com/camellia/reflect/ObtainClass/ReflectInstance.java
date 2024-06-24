package com.camellia.reflect.ObtainClass;

import org.junit.jupiter.api.Test;
/**
 * 获取Class可以干什么？
 */
public class ReflectInstance {
    @Test
    public void testReflectInstance() throws Exception {
        //获取到Class类型的实例之后，通过反射机制实例化对象。
        Class userClass = Class.forName("com.camellia.reflect.ObtainClass.User");
        //userClass代表的就是User类型
        User user = (User)userClass.newInstance();
        // 底层实现原理是：调用了User类的无参数构造方法完成了对象的实例化。
        // 要使用这个方法实例化对象的话，必须保证这个类中是存在无参数构造方法的。如果没有无参数构造方法，则出现异常：java.lang.InstantiationException。
        System.out.println(user);
        User newUser = (User)userClass.newInstance();
        System.out.println(newUser == user);
    }
}