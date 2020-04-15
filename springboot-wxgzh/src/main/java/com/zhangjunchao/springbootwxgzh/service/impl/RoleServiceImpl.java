package com.zhangjunchao.springbootwxgzh.service.impl;

import com.zhangjunchao.springbootwxgzh.bean.Role;
import com.zhangjunchao.springbootwxgzh.mapper.RoleMapper;
import com.zhangjunchao.springbootwxgzh.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/14
 */
@Transactional(rollbackFor=Exception.class)
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public List<Role> getRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> likeRole(String role,String userId) {
        Example example = new Example(Role.class);
        // 排序
        example.setOrderByClause("id desc");

        // 设置要查询的字段，没设置的默认返回null
        example.selectProperties("id", "role");
        // 排除查询的字段，排除的字段默认返回null,优先级低于selectProperties
        //example.excludeProperties("userId");

        Example.Criteria criteria = example.createCriteria();

        // 添加查询条件
        if (StringUtils.isNotBlank(role)) {
            criteria.andLike("role", "%" + role + "%");
        }
        // 手写SQL，添加查询条件
        if (StringUtils.isNotBlank(userId)) {
            criteria.andCondition("user_id = "+"'"+userId+"'");
        }
        // 手写where条件：userId is not null
        //criteria.andCondition("user_id is not null");

        // userId is not null
        example.and(criteria.andIsNotNull("userId"));

        // todo:or条件设置
        //Example.Criteria criteria1 = example.createCriteria();
        //criteria1.andLike("userId", "123");
        //example.or(criteria1);

        return roleMapper.selectByExample(example);
    }
}
