/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.vip.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会员信息Entity
 * 
 * @author WLJ
 * @version 2018-04-24
 */
public class VipInfo extends DataEntity<VipInfo> {
	private static final long serialVersionUID = 807427964805611069L;
	private String name; // 名称
	private String sex; // 性别(1: 男 2：女)
	private Integer currentTimes; // 当前次数
	private String mobile; // 手机号

	public VipInfo() {
		super();
	}

	public VipInfo(String id) {
		super(id);
	}

	@Length(min = 1, max = 100, message = "名称长度必须介于 1 和 10 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 1, max = 1, message = "性别(1: 男  2：女)长度必须介于 1 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@NotNull(message = "当前次数不能为空")
	public Integer getCurrentTimes() {
		return currentTimes;
	}

	public void setCurrentTimes(Integer currentTimes) {
		this.currentTimes = currentTimes;
	}

	@Length(min = 0, max = 11, message = "手机号长度必须介于 0 和 11 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "VipInfo [name=" + name + ", sex=" + sex + ", currentTimes=" + currentTimes + ", mobile=" + mobile + "]";
	}

}