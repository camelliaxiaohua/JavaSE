package com.camellia.io.decorator.package03;

/**
 * 所有的装饰者应该有一个共同的父类。这个父类通常是一个抽象类。
 * FlyableDecorator 作为所有装饰者的基类，包含被装饰者的引用。
 */
public abstract class FlyableDecorator implements Flyable {
    private Flyable flyable;

    /**
     * 构造函数，接受一个Flyable对象。
     * 通过组合的方式，包含被装饰者的引用。
     *
     * @param flyable 被装饰的对象，实现了Flyable接口
     */
    public FlyableDecorator(Flyable flyable) {
        this.flyable = flyable;
    }

    /**
     * 实现Flyable接口的fly方法。
     * 调用被装饰者的fly方法，以实现基本的飞行功能。
     */
    @Override
    public void fly() {
        flyable.fly();
    }
}
