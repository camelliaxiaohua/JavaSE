package com.camellia.method;

/*
当一个程序满足怎样的条件时，代码就构成了方法重载呢？
	条件1：在同一个类中。
	条件2：方法名一致。
	条件3：形式参数列表不同：
			类型不同算不同
			顺序不同算不同
			个数不同算不同

方法重载是编译阶段的机制还是运行阶段的机制？
	方法重载机制是编译阶段的机制。
	在编译阶段已经完成了方法的绑定。
	在编译阶段已经确定了要调用哪个方法了。

什么情况下我们考虑使用方法重载呢？
	在以后的开发中，在一个类中，如果两个方法的功能相似，建议将方法名定义为同一个名字。
	此时就使用了方法重载机制。
*/
public class MethodOverloadTest01 {
    public static void main(String[] args){
        m1();
        m1("abc");

        m2(10, 20);
        m2(10L, 20L);

        m3("x", 10);
        m3(10, "x");
    }

    // 形参的个数不同
    public static void m1(){
        System.out.println("m1()");
    }
    public static void m1(String s){
        System.out.println("m1(String s)");
    }

    // 形参类型不同
    public static void m2(int a, int b){
        System.out.println("m2(int a, int b)");
    }
    public static void m2(long a, long b){
        System.out.println("m2(long a, long b)");
    }

    // 形参顺序不同
    public static void m3(String s, int a){
        System.out.println("m3(String s, int a)");
    }
    public static void m3(int a, String s){
        System.out.println("m3(int a, String s)");
    }

    // 以下这两个方法没有构成方法重载，属于方法重复定义了。语法错误，编译器报错。
	/*
	public static void doSome(int a, int b){
	
	}
	public static void doSome(int x, int y){
	
	}
	*/
}