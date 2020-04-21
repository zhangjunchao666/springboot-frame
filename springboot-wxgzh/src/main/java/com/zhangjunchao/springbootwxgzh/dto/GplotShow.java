package com.zhangjunchao.springbootwxgzh.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO：展示
 *
 * @author zhangjunchao
 * @date 2020/4/17
 */
@Data
public class GplotShow implements Serializable {

    /**
     * id
     */
    private String id;
    /**
     * 展示字段
     */
    private String name;




}
