package com.zhangjunchao.springbootwxgzh.equip.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Equip)实体类
 *
 * @author makejava
 * @since 2020-04-15 09:29:08
 */
@Data
public class Equip implements Serializable {
    private static final long serialVersionUID = 798551958978300328L;
    /**
    * 主键
    */
    private String id;
    /**
    * 设备名称
    */
    private String equipName;
    /**
    * 设备管理员
    */
    private String managerUser;



}