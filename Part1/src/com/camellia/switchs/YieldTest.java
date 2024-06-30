package com.camellia.switchs;

import java.util.Scanner;

/**
 * @Datetime: 2024/6/30下午10:36
 * @author: Camellia.xioahua
 */
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
