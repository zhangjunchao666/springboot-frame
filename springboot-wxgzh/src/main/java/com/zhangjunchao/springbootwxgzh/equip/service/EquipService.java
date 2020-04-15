package com.zhangjunchao.springbootwxgzh.equip.service;

import com.zhangjunchao.springbootwxgzh.equip.entity.Equip;
import java.util.List;

/**
 * (Equip)表服务接口
 *
 * @author makejava
 * @since 2020-04-15 09:29:10
 */
public interface EquipService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equip queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Equip> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param equip 实例对象
     * @return 实例对象
     */
    Equip insert(Equip equip);

    /**
     * 修改数据
     *
     * @param equip 实例对象
     * @return 实例对象
     */
    Equip update(Equip equip);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);


    List<Equip> queryAllUser();
}