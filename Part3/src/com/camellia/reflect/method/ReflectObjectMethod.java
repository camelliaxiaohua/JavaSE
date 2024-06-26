package com.camellia.reflect.method;

import java.lang.reflect.Method;

/**
 * 通过反射机制调用method
 */
public class ReflectObjectMethod {
    public static void main(String[] args) {
        try {
            //获取类
            Class<?> clazz = Class.forName("com.camellia.reflect.method.UserService");
            UserService userService = (UserService) clazz.newInstance();
            //获取指定方法:方法名、形参。
            Method loginMethod = clazz.getDeclaredMethod("login", String.class, String.class);
            //调用指定方法。注意：调用哪个对象(userService)、哪个方法(loginMethod)、传什么参数(admin、123456)、返回什么值(returnValue)。
            Object returnValue = loginMethod.invoke(userService, "admin", "123456");
            System.out.println(returnValue);
            Method logoutMethod = clazz.getDeclaredMethod("logout");
            logoutMethod.invoke(userService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
