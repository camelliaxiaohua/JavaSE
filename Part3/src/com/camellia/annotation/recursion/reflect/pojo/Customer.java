package com.camellia.annotation.recursion.reflect.pojo;

import com.camellia.annotation.recursion.reflect.annotation.Column;
import com.camellia.annotation.recursion.reflect.annotation.Table;

/**
 * @Datetime: 2024/6/26下午8:07
 * @author: Camellia.xioahua
 */
@Table("t_customer")
public class Customer {
    @Column(name = "cid")
    private String cid;
    @Column(name = "name")
    private String name;
    @Column(name = "age", type = "int")
    private int age;
    @Column(name = "addr")
    private String address;
}