package com.camellia.annotation.recursion.reflect.pojo;

import com.camellia.annotation.recursion.reflect.annotation.Column;
import com.camellia.annotation.recursion.reflect.annotation.Table;

/**
 * @Datetime: 2024/6/26下午7:57
 * @author: Camellia.xioahua
 */

@Table(value = "t_user")
public class User {

    @Column(name = "uid")
    private String userid;

    @Column(name = "uname")
    private String username;

    @Column(name = "pwd")
    private String password;

    @Column(name = "age",type = "int")
    private int age;

    private String email;

}
