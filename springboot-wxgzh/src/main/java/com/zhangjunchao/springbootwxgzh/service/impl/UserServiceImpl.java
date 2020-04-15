package com.zhangjunchao.springbootwxgzh.service.impl;

import com.zhangjunchao.springbootwxgzh.bean.User;
import com.zhangjunchao.springbootwxgzh.mapper.UserMapper;
import com.zhangjunchao.springbootwxgzh.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/13
 */
@Transactional(rollbackFor=Exception.class)
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;



    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int inserUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }




}
