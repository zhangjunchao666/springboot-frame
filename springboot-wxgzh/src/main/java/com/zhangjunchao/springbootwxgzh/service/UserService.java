package com.zhangjunchao.springbootwxgzh.service;

import com.zhangjunchao.springbootwxgzh.bean.User;

import java.util.List;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/13
 */
public interface UserService {


    /**
     * 获取所有用户
     * @return List<User>
     */
    List<User> getUsers();

    /**
     * 插入用户
     * @param user 用户
     * @return int：影响的条数
     */
    int inserUser(User user);

    /**
     * 根据id查询用户
     * @param id id
     * @return user
     */
    User getUserById(String id);




}
