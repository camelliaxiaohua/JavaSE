package com.camellia.annotation.inline.annotation;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDK内置注解
 */
public class InlineAnnotationTest {


    /**
     * Java内置注解：@SuppressWarnings
     *      1. 主要作用是：抑制警告。
     *      2. 该注解常见的属性值：
     *          rawtypes：抑制未使用泛型的警告
     *          resource: 抑制未关闭资源的警告
     *          deprecation: 抑制使用了已过时资源时的警告
     *          all：抑制所有警告
     */

    @SuppressWarnings("all")
    public static void main(String[] args)  {

        @SuppressWarnings("rawtypes")
        List list = new ArrayList();

        try {
            @SuppressWarnings("resource")
            FileInputStream in = new FileInputStream("e:/file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        @SuppressWarnings("deprecation")
        AnnotationDeprecated deprecated = new AnnotationDeprecated();
    }

}

/**
 * JDK的内置注解：@Deprecated
 * 1. 被这个注解标注的元素已过时。
 * 2. 这个注解是给编译器看的。编译器看到这个注解之后会有警告提示信息。
 * 3. 经过测试 @Deprecated 注解可以标注的元素很多，例如：类上，方法上，属性上....
 */
@Deprecated
class AnnotationDeprecated {
    //since属性值表示从哪个版本开始已过时，forRemoval属性值如果是true表示已移除。
    @Deprecated(since = "9", forRemoval = true)
    public static  int num = 100;

    @Deprecated
    public void doSome(){

    }
}


/**
 * JDK内置的注解：@Override
 *      1. 给编译器看的。
 *      2. 这个注解标注实例方法，被标注的方法必须是重写父类的方法。
 *      3. 这个注解就是在编译阶段进行方法检查的，检查这个方法是否重写了父类方法，如果没有重写父类方法，则报错。
 *      4. 通过测试这个@Override注解只能使用在实例方法上。其他位置不能应用。
 */
class AnnotationOverride {

    // 不能在字段上使用@Override注解
    //@Override
    public static int num = 100;

    // 正确使用：重写了Object类的equals方法
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    // 不能在静态方法上使用@Override注解
    //@Override
    public static void m() {
    }
}


/**
 * 关于Java内置注解：@FunctionalInterface
 *      1. 这个注解是专门用来标注接口的。
 *      2. 被标注的接口必须是一个函数式接口，如果不是函数式接口，则编译器报错。
 *      3. 这个注解也是给编译器看的。
 *      4. 什么是函数式接口？
 *          如果这个接口中抽象方法只有一个（有且仅有一个）。称为函数式接口。
 *      5. 被 @FunctionalInterface 标注的接口中，允许有多个默认方法和静态方法。
 */
@FunctionalInterface
interface AnnotationFunctionalInterface{
    void m();

    default void run(){
        System.out.println("默认方法是可以的");
    }

    static void doSome(){
        System.out.println("静态方法");
    }
}

