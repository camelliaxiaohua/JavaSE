package com.camellia.reflect.ObtainClass;

import org.junit.jupiter.api.Test;

public class ObtainClassTest {
    /**
     * 获取Class的前三种方式
     */
    @Test
    public void testObtainClass(){
        //c1就代表对应类的类型,代表硬盘上的.class文件。
        try {
            //全限定类名，不可省略。
            //1.
            Class c1 = Class.forName("com.camellia.reflect.ObtainClass.User");
            //2.
            User user = new User("Camellia",22);
            Class c2 = user.getClass();
            //3.
            Class c3 = User.class;
            //某种类型的字节码文件在内存当中只有一份,c1 和 c2 都代表了同一种类型。
            System.out.println(c1 == c2&& c2 == c3); //true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Class的第四种方式：类加载器
     *  - 加载类：使用此方式只是将类加载的前两步完成了，第三步初始化没有做。只有在第一次使用才被初始化。
     *  - className三步全部完成。
     */
    @Test
    public void testClassloader(){
        //获取类加载器对象（获取的是 系统类加载器/应用类加载器）
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //jdk.internal.loader.ClassLoaders$AppClassLoader@36baf30c
        //这个类加载器是负责加载 classpath 中的字节码文件的。
        System.out.println(systemClassLoader);

        try {
            //加载类：使用此方式只是将类加载的前两步完成了，第三步初始化没有做。只有在第一次使用才被初始化。
            Class<?> aClass = systemClassLoader.loadClass("com.camellia.reflect.ObtainClass.User");
            System.out.println(aClass);
            //使用时初始化。
              System.out.println(aClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
