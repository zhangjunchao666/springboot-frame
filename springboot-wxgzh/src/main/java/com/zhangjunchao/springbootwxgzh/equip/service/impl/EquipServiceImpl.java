package com.zhangjunchao.springbootwxgzh.equip.service.impl;

import com.zhangjunchao.springbootwxgzh.equip.entity.Equip;
import com.zhangjunchao.springbootwxgzh.equip.dao.EquipDao;
import com.zhangjunchao.springbootwxgzh.equip.service.EquipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Equip)表服务实现类
 *
 * @author makejava
 * @since 2020-04-15 09:29:10
 */
@Service("equipService")
public class EquipServiceImpl implements EquipService {
    @Resource
    private EquipDao equipDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Equip queryById(String id) {
        return this.equipDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Equip> queryAllByLimit(int offset, int limit) {
        return this.equipDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param equip 实例对象
     * @return 实例对象
     */
    @Override
    public Equip insert(Equip equip) {
        // 使用通用mapper重写此方法
        this.equipDao.insertSelective(equip);
        return equip;
    }

    /**
     * 修改数据
     *
     * @param equip 实例对象
     * @return 实例对象
     */
    @Override
    public Equip update(Equip equip) {
        this.equipDao.update(equip);
        return this.queryById(equip.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.equipDao.deleteById(id) > 0;
    }

    @Override
    public List<Equip> queryAllUser() {
        return equipDao.selectAll();
    }
}