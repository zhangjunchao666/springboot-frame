package com.zhangjunchao.springbootwxgzh.mapper;

import com.zhangjunchao.springbootwxgzh.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * TODO：接口SQL || 映射文件
 *
 * @author zhangjunchao
 * @date 2020/4/13
 */
public interface UserMapper extends Mapper<User> {



    /**
     * 获取所有用户
     *
     * @return List<User>
     */
    @Select("select * from user")
    List<User> getUsers();

    /**
     * 根据id查询用户（使用映射实现）
     * @param id id
     * @return User
     */
    User getUserById(String id);


    /**
     * 插入用户
     * @param user user
     * @return int,影响的条数
     */
    @Insert("insert into user (id, userName, age) VALUES (#{id} ,#{userName} ,#{age})")
    int insertUser(User user);


}