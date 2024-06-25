package com.camellia.reflect.field;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectFieldTest {

    /**
     * 获取类型的名称
     */
    @Test
    public void testObtainTypeName(){
        //获取类型
        Class s = "重剑无锋，大巧无功。".getClass();
        //获取类型名称
        System.out.println(s.getName());
        //获取不带包名的类型名称
        System.out.println(s.getSimpleName());
    }

    /**
     * 获取vip类中所有public修饰的属性和字段。
     */
    @Test
    public void testGetFields() {
        try {
            //获取vip类
            Class<?> vipClass = Class.forName("com.camellia.reflect.field.Vip");
            //获取vip类中所有public修饰的属性和字段。
            Field[] fields = vipClass.getFields();
            //遍历数组
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDeclaredFields() {
        try {
            //获取vip类
            Class<?> vipClass = Class.forName("com.camellia.reflect.field.Vip");
            //获取vip类中所有的属性和字段。
            Field[] declaredFields = vipClass.getDeclaredFields();
            //遍历数组
            for (Field field : declaredFields) {
                //获取属性名、属性类型、属性类型名称。
                System.out.println("属性名:"+field.getName()+"\t"+"属性类型:"+field.getType()+
                        "\t"+"属性类型名称:"+field.getType().getSimpleName());
                //获取属性修饰符
                int modifiers = field.getModifiers();
                System.out.println("属性修饰符"+Modifier.toString(modifiers));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
