package com.zhangjunchao.springbootwxgzh.usergroup.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhangjunchao.springbootwxgzh.common.HttpClientUtil;
import com.zhangjunchao.springbootwxgzh.common.WeiXinUrl;
import com.zhangjunchao.springbootwxgzh.usergroup.bean.WinXinGroup;
import com.zhangjunchao.springbootwxgzh.usergroup.service.WeiXinGroupService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * TODO：
 *
 * @author zhangjunchao
 * @date 2020/3/24
 */
@Service
public class WeiXinGroupServiceImpl implements WeiXinGroupService {


    @Override
    public String add(WinXinGroup weiXinGroup) {

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("tag", weiXinGroup);
        String json = JSON.toJSONString(map);
        String result = HttpClientUtil.doPost(WeiXinUrl.replaceAccessTokenUrl(WeiXinUrl.ADD_TAGS), json, "appplication/json");
        System.out.println(result);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WinXinGroup> queryAll() {

        String s = HttpClientUtil.doGet(WeiXinUrl.replaceAccessTokenUrl(WeiXinUrl.QUERY_ALL_TAGS));
        Map<String, List> maps =(Map<String, List>) JSON.parseObject(s, Map.class);
        List<Map> listMap = Objects.requireNonNull(maps).get("tags");
        List<WinXinGroup> wgs = new ArrayList<>();
        for (Map m : listMap) {
            WinXinGroup w = new WinXinGroup();
            w.setId((Integer) m.get("id"));
            w.setName((String) m.get("name"));
            w.setCount((Integer) m.get("count"));
            wgs.add(w);
        }
        return wgs;
    }

    @Override
    public WinXinGroup queryUserGroup(String openid) {

        return null;
    }

    @Override
    public void updateGroupName(int groupid, String groupName) {

    }

    @Override
    public void moveUserToGroup(String openid, int groupId) {

    }

    @Override
    public void moveUsersToGroup(List<String> openids, int groupid) {

    }

    @Override
    public void deleteGroup(int groupid) {

    }
}
