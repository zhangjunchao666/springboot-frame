package com.zhangjunchao.springbootwxgzh.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/10
 */
@Data
public class UserRole implements Serializable {

    private String id;
    private String userName;
    private int age;
    private String role;



}
