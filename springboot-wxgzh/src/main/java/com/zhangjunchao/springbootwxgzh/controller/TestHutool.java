package com.zhangjunchao.springbootwxgzh.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.zhangjunchao.springbootwxgzh.bean.Role;
import com.zhangjunchao.springbootwxgzh.bean.User;
import com.zhangjunchao.springbootwxgzh.dto.UserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO：测试Hutool工具类
 *
 * @author zhangjunchao
 * @date 2020/4/9
 */
@Api(tags = "2-测试Hutool")
@RestController
public class TestHutool {

    private static Db db = Db.use();


    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("查询所有用户")
    @GetMapping("/getAllUser")
    public List<User> getAllUser() throws SQLException {

        // 查询所有用户，未分页
        List<User> users = db.findAll(Entity.create("user"), User.class);

        System.out.println(users);
        return users;
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("条件查询，拼接entity")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "age", value = "年龄")
    })
    @GetMapping("/conditionQueryUser ")
    public JSONArray conditionQueryUser(HttpServletRequest request) throws SQLException {
        String age = request.getParameter("age");
        String name = request.getParameter("name");

        // 根据条件拼接SQL
        Entity entity = Entity.create("user");
        if (StrUtil.isNotBlank(age)) {
            entity.set("age", age);
        }
        if (StrUtil.isNotBlank(name)) {
            entity.set("name", name);
        }

        // 执行查询
        List<Entity> all = db.findAll(entity);

        // Convert转换成JSONArray
        List<User> list1 = Convert.convert(new TypeReference<List<User>>() {}, all);
        JSONArray jsonArray = JSONUtil.parseArray(list1);

        System.out.println(jsonArray);
        return jsonArray;
    }


    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("条件查询，拼接SQL语句")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "姓名"),
            @ApiImplicitParam(name = "age", value = "年龄")
    })
    @GetMapping("/concatSql")
    public List<User> concatSql(HttpServletRequest request) throws SQLException {
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");

        String sql = "select * from user where 1=1 ";

        if (!StringUtils.isEmpty(userName)) {
            sql = sql + "and userName like '" + userName + "%'";
        }
        if (!StringUtils.isEmpty(age)) {
            sql = sql + "and age = " + age;
        }

        System.out.println(sql);
        // 执行sql语句，反射成bean对象
        List<User> all = db.query(sql, User.class);

        System.out.println(all);
        return all;
    }


    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "age", value = "年龄")
    })
    @GetMapping("/likeQuery")
    public JSONArray likeQuery(HttpServletRequest request) throws SQLException {

        String age = request.getParameter("age");
        String name = request.getParameter("name");

        // 模糊查询,根据条件拼接SQL
        Entity entity = Entity.create("user");
        if (StrUtil.isNotBlank(age)) {
            entity.set("age", new Condition("age", age, Condition.LikeType.Contains));
        }
        if (StrUtil.isNotBlank(name)) {
            entity.set("age", "is not null");
            entity.set("name", "like ".concat(name).concat("%"));
        }

        List<Entity> results = db.findAll(entity);
        JSONArray jsonArray = JSONUtil.parseArray(results);

        System.out.println(jsonArray);
        return jsonArray;
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("关联查询")
    @GetMapping("/leftQuery")
    public List<UserRole> leftQuery() throws SQLException {

        List<UserRole> users = db.query("select user.id,user.userName,user.age,role.role from user left join " +
                "role on user.id=role.userId", UserRole.class);
        // 排序
        List<UserRole> userRoleList =
                users.stream().sorted(Comparator.comparing(UserRole::getAge).reversed()).collect(Collectors.toList());

        System.out.println(userRoleList);
        return userRoleList;
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("插入用户数据,返回影响的条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "姓名"),
            @ApiImplicitParam(name = "age", value = "年龄"),
            @ApiImplicitParam(name = "role", value = "角色")
    })
    @PostMapping("/inserUser")
    public int[] inserUser(User user,HttpServletRequest request) throws SQLException {
        String role = request.getParameter("role");

        user.setId(IdUtil.fastSimpleUUID());
        int[] i = db.insert(CollUtil.newArrayList(Entity.parse(user)));

        // 设置角色
        Role userRole = new Role();
        userRole.setId(IdUtil.fastSimpleUUID());
        userRole.setRole(role);
        userRole.setUserId(user.getId());
        int[] i1 = db.insert(CollUtil.newArrayList(Entity.parse(userRole)));

        System.out.println(Arrays.toString(i));
        return i;
    }






    public static void main(String[] args) throws SQLException {
        //List<User> users = db.findAll(Entity.create("user"), User.class);
        //System.out.println(users);

        //Role role = new Role();
        //role.setId(IdUtil.fastSimpleUUID());
        //role.setRole("老大");
        //role.setUserId(IdUtil.fastSimpleUUID());
        //
        //db.insert(CollUtil.newArrayList(Entity.parse(role)));





        System.out.println("randomUUID："+IdUtil.randomUUID());// fafbc476-a7a9-4d1a-92c5-304201de3050

        System.out.println("simpleUUID："+IdUtil.simpleUUID());// 6e669e1a5e894864a8b2d11298bc9cba

        System.out.println("fastUUID："+IdUtil.fastUUID()); // 3e76694d-be59-4696-8d36-9a142ec2b31a


        // 使用此方法生成UUID
        System.out.println("fastSimpleUUID："+IdUtil.fastSimpleUUID()); // cafd4906ad40441e951371a57d0c2217





    }












}
