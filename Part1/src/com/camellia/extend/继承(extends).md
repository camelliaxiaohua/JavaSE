---
title: 继承
date: 2024-05-02 23:36:12
tags:
categories:
- Java SE

---


# 继承
## 一、继承的基本语法
1、**继承概念：** 在Java中，继承是面向对象编程中的一个重要概念，它允许一个类（称为子类或派生类）继承另一个类（称为父类或基类）的属性和方法。
Java中的继承通过关键字extends来实现。
> * <u>Java只支持单继承，一个类只能直接继承一个类。</u>
> * Java不支持多继承，但是支持多重继承。
> * 子类继承父类，<u>除了**私有的不支持继承**、**构造方法不支持继承**</u>，其他的全部都能继承。
> * 一个类没有显示的继承任何类，默认继承java.lang.Object类。
> * Object是老祖宗，是JDK类库中的根类。

2、**继承在Java中的实现：**
```java
class Subclass extends Superclass {
    // 子类的成员变量和方法
}
```
3、**继承的相关术语**
* 父类也可以叫做超类、基类、superclass。
* 子类也可叫做派生类、subclass。

## 二、方法覆盖/Override/方法重写/Overwrite
1. 什么时候使用方法重写？   
   当从父类继承来的方法，无法满足子类业务需求时。
2. 当满足什么条件的时候，构成方法重写？
   * 方法覆盖发生在具有继承关系的父子类之间。
   * 具有相同的方法名（必须严格一样）
   * 具有相同的形参列表（必须严格一样）
   * 具有相同的返回值类型（可以是子类型）
3. 关于方法重写的细节
   * 当子类将父类方法覆盖之后，将来子类对象调用方法的时候，一定会执行重写之后的方法。
   * 在java语言中，有一个注解，这个注解可以在编译阶段检查这个方法是否是重写了父类的方法。@Override注解是JDK5引入，用来标注方法，被标注的方法必须是重写父类的方法，如果不是重写的方法，编译器会报错。@Override注解只在编译阶段有用，和运行期无关。
   * 如果返回值类型是引用数据类型，那么这个返回值类型可以是原类型的子类型
```java
         public class Animal{
        public Object getObj(int a,String b){
                retrun;
           }
        }
```

```java
public class Bird{
@Override
public String getObj(int a,String b){   //返回值String是Object的子类。            return ;
   }   
}
```
4. 当在子类中重写父类方法时，访问权限可以变得更高，但不能变得更低。这是因为子类中的方法必须能够访问父类中的方法，否则就会破坏继承关系。
  ```java
    class Animal {
        // 父类中的方法使用protected访问修饰符
        protected void sound() {
            System.out.println("Animal makes a sound");
        }
    }
      
     class Dog extends Animal {
         // 子类中的方法将访问权限从protected提升为public
        public void sound() {
            System.out.println("Dog barks");
        }
    }
  ```
5. <u>抛出异常不能变多，可以变少。</u>（后面学习异常的时候再说。）

6. 私有的方法，以及构造方法不能继承，因此他们不存在方法覆盖。

7. 方法覆盖针对的是实例方法。和静态方法无关。（讲完多态再说。）

   

