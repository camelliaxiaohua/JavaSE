package com.camellia.operator;

public class ReadClass2 {
    public static void main(String[] args) {
        int i=10;
        int j=++i;
    }
}
/*
Compiled from "ReadClass2.java"
public class ReadClass2 {
    public ReadClass2();
    Code:
            0: aload_0
            1: invokespecial #1                  // Method java/lang/Object."<init>":()V
            4: return

    public static void main(java.lang.String[]);
    Code:
            0: bipush        10
            2: istore_1
            3: iinc          1, 1
            6: iload_1
            7: istore_2
            8: return
}*/
