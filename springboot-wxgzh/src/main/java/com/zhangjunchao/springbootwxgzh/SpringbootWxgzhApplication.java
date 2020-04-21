package com.zhangjunchao.springbootwxgzh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MapperScan：mapper扫描，多个mapper包用逗号(,)隔开即可
 * EnableTransactionManagement：开启声明式事务注解
 * @author zhangjunchao
 * @date 2020-4-9 13:17:40
 */
@MapperScan({"com.zhangjunchao.**.mapper"})
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class SpringbootWxgzhApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWxgzhApplication.class, args);
    }

}
