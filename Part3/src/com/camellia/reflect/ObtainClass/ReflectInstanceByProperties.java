package com.camellia.reflect.ObtainClass;

import java.util.ResourceBundle;
/**
 * 读取属性配置文件，获取类名，通过反射机制实例化对象。
 */
public class ReflectInstanceByProperties {
    public static void main(String[] args) {
        //资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("com.camellia.reflect.ObtainClass.ClassInfo");
        //通过key获取value
        String className = bundle.getString("className");
        //通过反射机制实例化对象
        try {
            Class aClass = Class.forName(className);
            Object object = aClass.newInstance();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
