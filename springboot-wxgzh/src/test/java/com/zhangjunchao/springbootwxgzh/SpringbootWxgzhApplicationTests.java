package com.zhangjunchao.springbootwxgzh;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import com.zhangjunchao.springbootwxgzh.equip.dao.EquipDao;
import com.zhangjunchao.springbootwxgzh.equip.entity.Equip;
import com.zhangjunchao.springbootwxgzh.equip.service.EquipService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootWxgzhApplicationTests {

    @Resource
    EquipService equipService;


    /**
     * 测试easy code 插件，要重写insert方法，因为此插件默认id是自增的。
     */
    @Test
    void equipInserTest() {
        Equip equip = new Equip();
        equip.setId(IdUtil.fastSimpleUUID());
        equip.setEquipName("电脑");
        equip.setManagerUser("老大");

        equipService.insert(equip);
    }

    @Test
    void equipUpdateTest() {
        Equip equip = new Equip();
        equip.setId("6e1e3fa6a71d4e8484a06747f2af703b");
        equip.setEquipName("电脑");
        equip.setManagerUser("老二");

        equipService.update(equip);
    }

    @Test
    void equipDeleteTest() {
        equipService.deleteById("6e1e3fa6a71d4e8484a06747f2af703b");
    }

    @Test
    void equipSelectTest() {
        List<Equip> equips =  equipService.queryAllUser();
        System.out.println(equips);

    }


    @Test
    void contextLoads() {
    }

}
