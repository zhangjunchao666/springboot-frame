
package com.zhangjunchao.springbootwxgzh.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO 设备信息
 * @author zhangjunchao
 */
@Data
public class Equip implements Serializable {
	
	private static final long serialVersionUID = 5454155825314635342L;

		/**
		 * 设备编号
		 */
		private String id;
		/**
		 * 名称
		 */
		private String name;
		/**
		 * 品牌型号
		 */
		private String brand;
		/**
		 * 描述
		 */
		private String describe;
		/**
		 * 型号
		 */
		private String type;
		/**
		 * 创建时间
		 */
		private java.util.Date createTime;
		/**
		 * 修改时间
		 */
		private java.util.Date modifyTime;
		/**
		 * 0不展示，1展示
		 */
		private Boolean status;
		/**
		 * equipModel
		 */
		private String equipModel;
		/**
		 * equipSn
		 */
		private String equipSn;
		/**
		 * company
		 */
		private String company;
		/**
		 * parameter
		 */
		private String parameter;
		/**
		 * installTime
		 */
		private java.util.Date installTime;
		/**
		 * manufacturer
		 */
		private String manufacturer;
		/**
		 * servicePhone
		 */
		private String servicePhone;
		/**
		 * system
		 */
		private String system;
		/**
		 * 设备类型，如情报板、摄像机
		 */
		private String equipType;
		/**
		 * 阈值
		 */
		private Integer min;
		/**
		 * 备件类型
		 */
		private String partsType;
		/**
		 * 所属部门
		 */
		private String department;
		/**
		 * 所属部门
		 */
		private String skillParameter;
		/**
		 * 出厂日期
		 */
		private java.util.Date productionTime;
		/**
		 * 安全阀值
		 */
		private String threshold;
		/**
		 * 故障字典
		 */
		private String faultDict;
		/**
		 * 重要度评估
		 */
		private String importantLevel;
		/**
		 * 巡检类型
		 */
		private String inspectType;
		/**
		 * 是否巡检
		 */
		private String earlyWarning;
		/**
		 * 照片
		 */
		private String img;
		/**
		 * 备注
		 */
		private String remark;

}

	
