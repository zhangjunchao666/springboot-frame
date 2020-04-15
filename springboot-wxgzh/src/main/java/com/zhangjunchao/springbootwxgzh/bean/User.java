package com.zhangjunchao.springbootwxgzh.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/9
 */
@Data
public class User implements Serializable {


    @Id
    private String id;
    private String userName;
    private int age;



}
