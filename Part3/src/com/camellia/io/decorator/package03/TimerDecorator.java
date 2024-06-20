package com.camellia.io.decorator.package03;

/**
 * TimerDecorator 类是一个具体的装饰者，用于在 Flyable 对象的飞行过程中添加计时功能。
 * 它在飞行前后记录时间，并计算飞行耗时。
 */
public class TimerDecorator extends FlyableDecorator {

    /**
     * 构造函数，接受一个 Flyable 对象。
     * 通过组合的方式，包含被装饰者的引用。
     *
     * @param flyable 被装饰的对象，实现了 Flyable 接口
     */
    public TimerDecorator(Flyable flyable) {
        super(flyable);
    }

    /**
     * 重写 fly 方法，在飞行前后记录时间，并计算飞行耗时。
     * 在调用被装饰者的 fly 方法之前，记录起始时间；
     * 在调用被装饰者的 fly 方法之后，记录结束时间，并计算和打印飞行耗时。
     */
    @Override
    public void fly() {
        // 记录起始时间（前增强）
        long begin = System.currentTimeMillis();

        // 调用被装饰者的 fly 方法，执行飞行操作
        super.fly();

        // 记录结束时间（后增强）
        long end = System.currentTimeMillis();

        // 打印飞行耗时
        System.out.println("耗时 " + (end - begin) + " 毫秒");
    }
}
