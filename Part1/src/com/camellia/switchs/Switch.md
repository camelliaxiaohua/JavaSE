---
title: Switch语句
date: 2024-04-25 23:15:30
tags:
categories:
- Java SE

---


# Switch 语句

---



## 一、case 语句可以合并

---

case 后面只能是字面量值这样的值，不能使用变量。

```java
import java.util.Scanner;

public class SwitchTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer month = sc.nextInt();
        String str;
        switch(month) {
            case 3: case 4: case 5:
                str="春天";
                break;
            case 6 : case 7: case 8:
                str="夏天";
                break;
            case 9: case 10: case 11:
                str="秋天";
                break;
            case 12: case 1: case 2:
                str="冬天";
                break;
            default: str="请输入正确月份";
        }
        System.out.println(str);
    }
}
```

---



## 二、Java12 中 switch 的新特性

---

增强的 switch 语句是 Java 12 中引入的一项语言特性，它在 Java 14 中得到了进一步改进。这个特性的目的是提供更简洁、灵活和易读的 switch 语法。

传统的 switch 语句在处理多个条件分支时可能存在一些问题，例如需要使用 break 语句显式地结束每个分支，容易出现忘记添加 break 而导致多个分支执行的情况。

增强的 switch 语句解决了这些问题，并引入了一些新的语法特性。

**增强的 switch 语句的特点如下：**
- 使用表达式作为分支条件：增强的 switch 语句允许在每个 case 分支中使用表达式，而不仅限于常量。这使得代码更加灵活，可以更方便地处理各种条件。
- 无需显式 break：在传统的 switch 语句中，每个 case 分支必须以 break 语句结束，否则会继续执行下一个分支。而增强的 switch 语句不需要显式地使用 break，每个分支会自动结束，不会继续执行下一个分支。
- 使用箭头(->)：在增强的 switch 语句中，分支的语法使用箭头(->)来连接分支的条件和执行语句，这使得代码更加简洁和易读。
- 引入 yield 关键字：在 Java 14 中，增强的 switch 语句引入了 yield 关键字，用于在分支中返回值。这使得 switch 语句可以像表达式一样返回值，增强了其功能性。

```java
public class YieldTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = sc.nextInt();
        System.out.println("请输入月份");
       int month = sc.nextInt();
       int days = switch (month) {
           case 1,3,5,7,8,10,12 ->31;
           case 4,6,9,11->30;
           case 2->{
               if(year%4==0&&year%100!=0&&year%400==0)yield 29;
               else yield 28;
           }
           default -> {
               yield -1;
           }
       };
        System.out.println("这个月的天数:"+days);
    }
}

```

```java
class Switch01{
    public static void main(String[] args) {
        switch(expression){
            case 1-> System.out.println("switch");
            case 2 -> System.out.println("Change in");
            case 3 -> System.out.println("Java12");
            default -> System.out.println("default");
        }
    }
}
```