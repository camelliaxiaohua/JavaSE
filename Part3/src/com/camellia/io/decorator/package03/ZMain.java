package com.camellia.io.decorator.package03;

/**
 * Main 类演示了装饰器设计模式的使用。
 * 主要目标是在松耦合的前提下，扩展对象的功能。
 *
 * 0. 装饰器设计模式的主要目标：在松耦合的前提下，能够完成功能的扩展。
 * 1. 在装饰器设计模式中有两个非常重要的角色：装饰者，被装饰者。
 * 2. 装饰器设计模式当中要求：装饰者与被装饰者应实现同一个接口/同一些接口，或继承同一个抽象类。
 * 3. 为什么装饰者与被装饰者要实现同一个接口？
 *    因为实现了同一个接口之后，对于客户端程序来说，使用装饰者的时候就像在使用被装饰者一样。
 * 4. 装饰者含有被装饰者的引用。(A has a B。尽量使用 has a【耦合度低一些】。不要使用 is a。)
 */
public class ZMain {
    public static void main(String[] args) {
        // 使用装饰器为 Cat 对象添加计时功能
        Flyable flyable1 = new TimerDecorator(new Cat());
        flyable1.fly();

        // 使用装饰器为 Bird 对象添加日志功能
        Flyable flyable2 = new LogDecorator(new Bird());
        flyable2.fly();
    }
}
