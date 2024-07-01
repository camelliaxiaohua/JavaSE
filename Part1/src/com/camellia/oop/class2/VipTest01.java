package com.camellia.oop.class2;

public class VipTest01 {
    public static void main(String[] args) {
        // 创建一个Vip对象
        Vip vip1 = new Vip();

        // 给name和age属性赋值
        vip1.name = "jack";
        vip1.age = 20;

        System.out.println("name = " + vip1.name);
        System.out.println("age = " + vip1.age);

        // 去购物
        vip1.shopping();

        // 再创建一个Vip对象
        Vip vip2 = new Vip();
        vip2.name = "lisi";
        vip2.age = 15;

        System.out.println("name = " + vip2.name);
        System.out.println("age = " + vip2.age);

        // 去购物
        // 实例方法需要使用“引用.”来调用。
        vip2.shopping();

        // 为什么name和age不能使用“类名.”访问。
        // 实例变量要想访问，必须先new对象。通过引用来访问实例变量。
        // 实例变量是不能通过类名直接访问的。
        //System.out.println(Vip.name);
        //System.out.println(Vip.age);

        // 编译报错。实例方法不能使用“类名.”去调用。
        //Vip.shopping();

    }
}