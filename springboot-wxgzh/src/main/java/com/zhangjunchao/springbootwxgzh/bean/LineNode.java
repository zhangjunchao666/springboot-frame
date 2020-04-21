package com.zhangjunchao.springbootwxgzh.bean;

import lombok.Data;
import java.io.Serializable;

/**
 * TODO 节点
 * @author zhangjunchao
 */
@Data
public class LineNode implements Serializable  {
	
	
	private static final long serialVersionUID = 5454155824814635342L;

	/**
	 * ID  UUID
	 */
	private String id;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 上级节点  关联表bas_node
	 */
	private String superNode;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 类型 收费站 车道 服务区 位置桩
	 */
	private String type;
	/**
	 * 是否可用  0:不可用;1:可用
	 */
	private Boolean isValid;
	/**
	 * 描述
	 */
	private String describe;
	/**
	 * lat纬度
	 */
	private Double lat;
	/**
	 * lon经度
	 */
	private Double lon;
	/**
	 * 简称
	 */
	private String shortName;
	/**
	 * 图片
	 */
	private String picList;
	/**
	 * sort
	 */
	private Integer sort;
	/**
	 * 上级节点全路径
	 */
	private String superNodeAll;
	/**
	 * 显示位置
	 */
	private Boolean view;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 修改时间
	 */
	private java.util.Date modifyTime;
	/**
	 * 出口位置
	 */
	private String outPosistion;
	/**
	 * 车道数
	 */
	private String roadNum;
	/**
	 * 高速
	 */
	private String expy;
	/**
	 * 公司
	 */
	private String company;
	/**
	 * 桩号
	 */
	private String mileage;
	/**
	 * 负责人
	 */
	private String nodeHead;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 荣誉
	 */
	private String honor;
	/**
	 * 星级
	 */
	private String starLevel;
	/**
	 * 受影响的id
	 */
	private String nodeIds;

}

	
