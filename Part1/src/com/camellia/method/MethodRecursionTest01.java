package com.camellia.method;

public class MethodRecursionTest01{

    public static void main(String[] args){
        int n = 5;
        int result = jieCheng(n);
        System.out.println("result = " + result);
    }

    public static int jieCheng(int n){
        if(n == 1){
            return 1;
        }
        return n * jieCheng(n - 1);
    }
}