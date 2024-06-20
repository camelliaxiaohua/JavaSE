package com.camellia.collection.Abegin_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <P>测试java.util.Collection接口中公共的常用方法。</P>
 * <P>因为Collection是接口无法实例化，所以这里用ArrayList实现类测试</P>
 * @author Camellia.xiaohua
 * @date 2024.6.8
 */
public class CollectionTest01 {
    @Test
    public void testCollectionAdd(){
        //创建一个集合对象
        Collection collection = new ArrayList();
        //添加元素
        collection.add(100); //发生自动装箱。
        collection.add(true);
        collection.add("Hello Java");
        //输出集合
        System.out.println("集合中元素个数："+collection.size());
    }

    @Test
    public void testCollectionAddAll(){
        // 创建一个集合对象
        Collection collection = new ArrayList();
        // 再创建一个集合对象
        Collection c1 = new ArrayList();
        c1.add("Hello World!");
        c1.add("Is Ok");
        // 一次添加多个。将一个集合中所有元素添加到当前集合对象中。
        collection.addAll(c1);
        //输出集合
        System.out.println("集合中元素个数："+collection.size());
    }

    @Test
    public void testCollectionContains(){
        Collection collection = new ArrayList();
        collection.add("重剑无锋，大巧无工。");
        collection.add("camellia");
        System.out.println(collection.contains("重剑无锋，大巧无工。"));
        String s = new String("camellia");
        //输出为true，底层调用了indexOfRange(Object o, int start, int end);将字符串拆分成数组，对每个数组元素进行比较。
        System.out.println(collection.contains(s));
    }
}
