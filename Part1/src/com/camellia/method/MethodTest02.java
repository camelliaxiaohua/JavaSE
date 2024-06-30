package com.camellia.method;

/*
1.方法如果只定义，不调用是不会分配内存空间。（从Java8开始，方法的字节码指令存储在元空间metaspace当中。元空间使用的是本地内存。）
2.方法调用的瞬间，会在JVM的栈内存当中分配活动场所，此时发生压栈动作。
3.方法一旦结束，给该方法分配的内存空间就会释放。此时发生弹栈动作。
*/
public class MethodTest02{
    public static void main(String[] args){
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    public static void m1(){
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    public static void m2(){
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    public static void m3(){
        System.out.println("m3 begin");
        System.out.println("m3 over");
    }
}

/*
main begin
m1 begin
m2 begin
m3 begin
m3 over
m2 over
m1 over
main over
*/

/**
 * Java 的元空间（Metaspace）是 Java 虚拟机（JVM）用来存储类元数据的内存区域。在传统的 Java 虚拟机实现中，类元数据通常存储在永久代（Permanent Generation）中。但是，从 JDK 8 开始，永久代被移除，取而代之的是元空间。
 *
 * 元空间与永久代相比有几个显著的不同点：
 *
 * 内存位置： 元空间不是在 Java 虚拟机的堆内存中，而是位于本地内存中。这使得元空间的大小不受堆内存的限制，可以动态地根据应用程序的需要调整大小。
 * 自动调整大小： 元空间的大小可以根据应用程序的需要动态调整，因此不容易出现类加载溢出的情况。在使用元空间时，不需要手动设置元空间的大小，JVM 会根据应用程序的需求自动调整。
 * 内存回收： 元空间的内存是由 JVM 进行管理的，不需要像永久代一样手动进行垃圾回收。当类加载器不再需要某些类的元数据时，JVM 会自动进行回收，而不会出现永久代中的内存泄漏问题。
 * 垃圾收集器： 元空间的垃圾收集与堆内存的垃圾收集不同，通常不会触发 Full GC。类加载器卸载类时，相关的元数据会被及时回收，不会等待垃圾收集器的触发。
 */