package com.zhangjunchao.springbootwxgzh.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO：拓扑图关系json
 *
 * @author zhangjunchao
 * @date 2020/4/17
 */
@Data
public class GplotRelation implements Serializable {

    /**
     * 上级节点
     */
    private String source;
    /**
     * 下级节点
     */
    private String target;

}
