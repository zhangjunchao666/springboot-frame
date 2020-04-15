package com.zhangjunchao.springbootwxgzh.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/9
 */
@Data
@Table(name = "role")
public class Role implements Serializable {

    @Id
    private String id;
    private String role;
    private String userId;



}
