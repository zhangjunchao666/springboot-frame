package com.zhangjunchao.springbootwxgzh.equip.dao;

import com.zhangjunchao.springbootwxgzh.equip.entity.Equip;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (Equip)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-15 09:29:09
 */
public interface EquipDao extends Mapper<Equip> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equip queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Equip> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param equip 实例对象
     * @return 对象列表
     */
    List<Equip> queryAll(Equip equip);

    /**
     * 新增数据
     *
     * @param equip 实例对象
     * @return 影响行数
     */
    @Override
    int insert(Equip equip);

    /**
     * 修改数据
     *
     * @param equip 实例对象
     * @return 影响行数
     */
    int update(Equip equip);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}