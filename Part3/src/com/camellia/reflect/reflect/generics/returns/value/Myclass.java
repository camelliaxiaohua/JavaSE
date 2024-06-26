package com.camellia.reflect.reflect.generics.returns.value;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取方法返回值上的泛型
 */
public class Myclass {
    public Map<String,Integer> m(){
        return new HashMap<String,Integer>();
    }
}
