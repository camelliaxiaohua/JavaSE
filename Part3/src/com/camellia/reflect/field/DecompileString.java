package com.camellia.reflect.field;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 反编译java.lang.String的所有属性
 */
public class DecompileString {
    public static void main(String[] args) {

        try {
            //字符串拼接
            StringBuilder sb = new StringBuilder();
            //获取String类
            Class<?> stringClass = Class.forName("java.lang.String");
            //获取类的修饰符
            int classModifiers = stringClass.getModifiers();
            String strClass = Modifier.toString(classModifiers);
            sb.append(strClass).append(" class");
            //获取简类名
            String simpleName = stringClass.getSimpleName();
            sb.append(" ").append(simpleName);
            //获取类继承的父类
            String strSuper = "";
            if(stringClass.getSuperclass() != null){
                strSuper = stringClass.getSuperclass().getSimpleName();
                sb.append(" extends ").append(strSuper);
            }
            //获取String类的父接口
            Class<?>[] interfaces = stringClass.getInterfaces();
            if (interfaces.length > 0) {
                sb.append(" implements ");
                for(Class<?> i : interfaces) {
                    sb.append(i.getSimpleName()).append(",");
                }
            }
            if(sb.lastIndexOf(",") != -1){
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("{\n");
            //获取String类中所有的字段
            Field[] allFields = stringClass.getDeclaredFields();
            for(Field f : allFields) {
                //获取字段修饰符
                int fieldModifiers = f.getModifiers();
                String strModifier = Modifier.toString(fieldModifiers);
                sb.append("\t").append(strModifier).append(" ");
                //获取字段类型
                String type = f.getType().getSimpleName();
                sb.append(type).append(" ");
                //获取字段名称
                String name = f.getName();
                sb.append(name).append(";\n");
            }
            sb.append("}");
            System.out.println(sb);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
