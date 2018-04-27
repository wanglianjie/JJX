/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.vip.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.vip.entity.VipInfo;

/**
 * 会员信息DAO接口
 * @author WLJ
 * @version 2018-04-24
 */
@MyBatisDao
public interface VipInfoDao extends CrudDao<VipInfo> {
	
}