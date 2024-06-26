package com.camellia.annotation.recursion.reflect.pojo;

import com.camellia.annotation.recursion.reflect.annotation.Column;
import com.camellia.annotation.recursion.reflect.annotation.Table;

/**
 * @Datetime: 2024/6/26下午8:06
 * @author: Camellia.xioahua
 */
@Table("t_vip")
public class Vip {
    @Column(name = "id")
    private String id;
    //@Column(name = "name")
    private String name;
    //@Column(name = "grade")
    private String grade;
}
