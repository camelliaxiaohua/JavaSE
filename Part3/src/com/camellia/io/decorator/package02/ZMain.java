package com.camellia.io.decorator.package02;

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
