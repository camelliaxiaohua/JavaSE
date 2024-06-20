package com.camellia.io.decorator.package01;
/**
 * 使用子类对父类的方法进行扩展。
 * 这种功能扩展方式，虽然符合OCP。没有修改之前的原代码。
 * 但是这种继承导致的问题有两个：
 *      第一个：代码耦合度高。
 *      第二个：类爆炸问题。
 */
public class CatSub extends Cat{
    @Override
    public void fly() {
        super.fly();
        System.out.println("Cat 新方法");
    }
}
