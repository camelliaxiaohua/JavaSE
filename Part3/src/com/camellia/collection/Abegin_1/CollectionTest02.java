package com.camellia.collection.Abegin_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest02 {
    public static void main(String[] args) {
        //创建集合对象
        Collection collection = new ArrayList();
        //向集合中添加对象
        collection.add("camellia");
        collection.add("xiaohua");
        collection.add("flowers");
        //遍历集合对象
            //1、获取当前集合依赖的迭代器对象
        Iterator it = collection.iterator();
            //2、编写循环
        while (it.hasNext()){
            //3、将光标指向的当前元素返回，并且将光标指向下一位。
            System.out.println(it.next());
        }


    }
}
