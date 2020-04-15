package com.zhangjunchao.springbootwxgzh.equip.controller;

import cn.hutool.core.util.IdUtil;
import com.zhangjunchao.springbootwxgzh.equip.entity.Equip;
import com.zhangjunchao.springbootwxgzh.equip.service.EquipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Equip)表控制层
 *
 * @author makejava
 * @since 2020-04-15 09:29:11
 */
@RestController
@RequestMapping("equip")
public class EquipController {
    /**
     * 服务对象
     */
    @Resource
    private EquipService equipService;

    /**
     * 通过主键查询单条数据
     *
     //* @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Equip selectOne(String id) {
        return this.equipService.queryById(id);
    }







}


















