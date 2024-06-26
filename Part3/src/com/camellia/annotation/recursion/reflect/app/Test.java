package com.camellia.annotation.recursion.reflect.app;

import com.camellia.annotation.recursion.reflect.annotation.Column;
import com.camellia.annotation.recursion.reflect.annotation.Table;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @Datetime: 2024/6/26下午8:11
 * @author: Camellia.xioahua
 */
public class Test {

    private static String classpathRoot;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // 扫描类路径当中所有的文件，找到所有的.class结尾的文件。
        // 通过.class文件的路径找到对应的全限定类名（全限定类名是带包名的。）
        classpathRoot = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
        //System.out.println("类路径的根：" + classpathRoot);
        // 创建File对象
        File file = new File(classpathRoot);
        // 调用方法来生成建表语句
        generateCreateStatement(file);
        System.out.println(sb);
    }

    /**
     * 通过这个方法，来生成建表语句
     *
     * @param file 起初的这个file代表的是类的根目录
     */
    private static void generateCreateStatement(File file) {
        if (file.isFile()) { // file是一个文件的时候，递归结束
            //System.out.println(file.getAbsolutePath());
            String classFileAbsolutePath = file.getAbsolutePath();
            if (classFileAbsolutePath.endsWith(".class")) {
                // 程序执行到这里，表示文件一定是一个字节码文件
                //System.out.println(classFileAbsolutePath);
                String className = classFileAbsolutePath.substring(classpathRoot.length() - 1, classFileAbsolutePath.length() - ".class".length()).replace("\\", ".");
                //System.out.println(className);

                try {
                    // 获取类
                    Class<?> clazz = Class.forName(className);
                    // 判断类上面是否有@Table注解
                    if(clazz.isAnnotationPresent(Table.class)){
                        Table tableAnnotation = clazz.getAnnotation(Table.class);
                        // 获取到表的名字
                        String tableName = tableAnnotation.value();
                        System.out.println(tableName);
                        sb.append("create table ");
                        sb.append(tableName);
                        sb.append("(");
                        // 获取所有的属性
                        Field[] fields = clazz.getDeclaredFields();
                        for(Field field : fields){
                            // 判断字段上是否存在 @Column 注解
                            if(field.isAnnotationPresent(Column.class)){
                                Column columnAnnotation = field.getAnnotation(Column.class);
                                // 字段名
                                String columnName = columnAnnotation.name();
                                System.out.println(columnName);
                                sb.append(columnName);
                                sb.append(" ");
                                // 字段的类型
                                String columnType = columnAnnotation.type();
                                System.out.println(columnType);
                                sb.append(columnType);
                                sb.append(",");
                            }
                        }
                        // 删除当前sb中的最后一个逗号
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(");\n");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            //System.out.println(f.getAbsolutePath());
            generateCreateStatement(f);
        }
    }
}
