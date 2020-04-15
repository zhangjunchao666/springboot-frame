package com.zhangjunchao.springbootwxgzh.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.zhangjunchao.springbootwxgzh.usergroup.bean.WinXinGroup;
import com.zhangjunchao.springbootwxgzh.usergroup.service.WeiXinGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/3/25
 */
@Api(tags = "2-用户管理")
@RestController
public class WeiXinUserManage {

    @Resource
    private WeiXinGroupService weiXinGroupService;


    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("添加分组")
    @PostMapping("/addTag")
    public String addGroup() {
        WinXinGroup winXinGroup = new WinXinGroup();
        winXinGroup.setId(104);
        winXinGroup.setName("测试组004");
        return weiXinGroupService.add(winXinGroup);
    }

    @ApiOperationSupport(author = "zhangjunchao")
    @ApiOperation("获取所有分组")
    @GetMapping("/queryAllTags")
    public List<WinXinGroup> queryAllTags(){

        return weiXinGroupService.queryAll();
    }









}
