package com.camellia.reflect.ObtainClass;

import org.junit.jupiter.api.Test;

public class ObtainClassTest {
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
}
