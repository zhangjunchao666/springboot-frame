package com.zhangjunchao.springbootwxgzh.controller;


import cn.hutool.core.util.IdUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.zhangjunchao.springbootwxgzh.bean.Role;
import com.zhangjunchao.springbootwxgzh.bean.User;
import com.zhangjunchao.springbootwxgzh.service.RoleService;
import com.zhangjunchao.springbootwxgzh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO：springboot集成mybatis测试
 *
 * @author zhangjunchao
 * @date 2020/4/13
 */
@Api(tags = "3-测试MyBatis")
@RestController
public class TestMybatis {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("获取所有用户")
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("根据id获取用户")
    @GetMapping("/getUserById")
    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("插入用户数据,返回影响的条数")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName", value = "姓名"), @ApiImplicitParam(name = "age", value =
            "年龄")})
    @PostMapping("/insUser")
    public String inserUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");
        User user = new User();
        user.setId(IdUtil.fastSimpleUUID());
        user.setUserName(userName);
        user.setAge(Integer.parseInt(age));

        int i = userService.inserUser(user);
        if (i > 0) {
            return "成功插入".concat(String.valueOf(i)).concat("条数据");
        } else {
            return "插入失败";
        }
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("tk获取所有角色")
    @GetMapping("/getRoles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }


    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("tk模糊查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色"),
            @ApiImplicitParam(name = "userId", value = "userId")
    })
    @GetMapping("/likeRole")
    public List<Role> likeRole(String role,String userId) {
        return roleService.likeRole(role,userId);
    }


}
