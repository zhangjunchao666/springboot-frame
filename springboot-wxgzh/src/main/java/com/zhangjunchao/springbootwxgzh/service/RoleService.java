package com.zhangjunchao.springbootwxgzh.service;

import com.zhangjunchao.springbootwxgzh.bean.Role;

import java.util.List;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/4/14
 */
public interface RoleService {


    List<Role> getRoles();

    List<Role> likeRole(String role,String userId);
}
