package com.camellia.reflect.reflect.generics.interfaces.generic;

public class Bird implements Flyable<String,Integer>,Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
