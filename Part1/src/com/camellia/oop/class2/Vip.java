package com.camellia.oop.class2;

// 会员类
public class Vip {

    // 类 = 属性 + 方法
    // 属性：描述的是状态。
    // 方法：描述的是行为。

    // 姓名
    String name; // 实例变量(对象变量)
    // 年龄
    int age; // 实例变量（对象变量）

    // 会员行为动作
    // 购物行为
    // 先记住：我们通常描述一个对象的行为动作时，不加static。
    // 没有添加static的方法，被叫做：实例方法。（对象方法）
    public void shopping(){
        System.out.println("正在购物！");
    }
}
