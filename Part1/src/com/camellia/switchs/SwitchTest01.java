package com.camellia.switchs;

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
