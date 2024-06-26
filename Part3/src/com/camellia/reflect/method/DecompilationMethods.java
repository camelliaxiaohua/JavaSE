package com.camellia.reflect.method;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * 反编译类的方法
 */
public class DecompilationMethods {
    public static void main(String[] args) {

        try {
            // 创建一个字符串构建器，用于拼接生成的类信息字符串
            StringBuilder sb = new StringBuilder();
            // 获取指定类的Class对象
            Class<?> stringClass = Class.forName("java.lang.String");
            // 获取类的修饰符（如public, abstract等）
            int classModifiers = stringClass.getModifiers();
            String strClass = Modifier.toString(classModifiers);
            sb.append(strClass).append(" class");
            // 获取类的简名（不包括包名）
            String simpleName = stringClass.getSimpleName();
            sb.append(" ").append(simpleName);
            // 获取类的直接父类（如果存在）
            String strSuper = "";
            if(stringClass.getSuperclass() != null){
                strSuper = stringClass.getSuperclass().getSimpleName();
                sb.append(" extends ").append(strSuper);
            }
            // 获取类实现的所有接口
            Class<?>[] interfaces = stringClass.getInterfaces();
            if (interfaces.length > 0) {
                sb.append(" implements ");
                // 拼接接口名
                for(Class<?> i : interfaces) {
                    sb.append(i.getSimpleName()).append(",");
                }
            }
            // 删除最后一个多余的逗号
            if(sb.lastIndexOf(",") != -1){
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("{\n");
            // 获取类中所有的字段
            Field[] allFields = stringClass.getDeclaredFields();
            for(Field f : allFields) {
                // 获取字段的修饰符
                int fieldModifiers = f.getModifiers();
                String strModifier = Modifier.toString(fieldModifiers);
                sb.append("\t").append(strModifier).append(" ");
                // 获取字段的类型
                String type = f.getType().getSimpleName();
                sb.append(type).append(" ");
                // 获取字段的名称
                String name = f.getName();
                sb.append(name).append(";\n");
            }
            // 获取类中所有的方法
            Method[] methods = stringClass.getDeclaredMethods();
            for(Method method : methods) {
                // 获取方法的修饰符
                sb.append("\t").append(Modifier.toString(method.getModifiers())).append(" ");
                // 获取方法的返回类型
                sb.append(method.getReturnType().getSimpleName()).append(" ");
                // 获取方法的名称
                sb.append(method.getName()).append("(");
                // 获取方法的参数列表
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    // 获取参数的类型
                    sb.append(parameters[i].getType().getSimpleName()).append(" ");
                    // 获取参数的名称
                    sb.append(parameters[i].getName());
                    // 如果不是最后一个参数，加上逗号
                    if(i != parameters.length - 1)sb.append(",");
                }
                sb.append("){};\n");
            }
            sb.append("}");
            // 打印生成的类信息
            System.out.println(sb);
        } catch (ClassNotFoundException e) {
            // 捕获并打印类未找到的异常
            e.printStackTrace();
        }

    }
}
