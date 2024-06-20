package com.camellia.io.decorator.package03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * LogDecorator 类是一个具体的装饰者，用于在 Flyable 对象的飞行过程中添加日志功能。
 * 它在飞行前后记录日志信息。
 */
public class LogDecorator extends FlyableDecorator {
    /**
     * 构造函数，接受一个 Flyable 对象。
     * 通过组合的方式，包含被装饰者的引用。
     *
     * @param flyable 被装饰的对象，实现了 Flyable 接口
     */
    public LogDecorator(Flyable flyable) {
        super(flyable);
    }

    /**
     * 重写 fly 方法，在飞行前后记录日志。
     * 在调用被装饰者的 fly 方法之前，记录起飞前的日志信息；
     * 在调用被装饰者的 fly 方法之后，记录降落后的日志信息。
     */
    @Override
    public void fly() {
        // 获取当前时间
        Date now = new Date();
        // 创建日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // 打印起飞前的日志信息
        System.out.println(sdf.format(now) + ": 起飞前的准备");

        // 调用被装饰者的 fly 方法，执行飞行操作
        super.fly();

        // 获取当前时间
        now = new Date();
        // 打印降落后的日志信息
        System.out.println(sdf.format(now) + ": 安全降落");
    }
}
