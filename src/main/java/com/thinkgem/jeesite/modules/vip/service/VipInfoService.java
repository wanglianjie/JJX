/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.vip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.vip.entity.VipInfo;
import com.thinkgem.jeesite.modules.vip.dao.VipInfoDao;

/**
 * 会员信息Service
 * @author WLJ
 * @version 2018-04-24
 */
@Service
@Transactional(readOnly = true)
public class VipInfoService extends CrudService<VipInfoDao, VipInfo> {

	public VipInfo get(String id) {
		return super.get(id);
	}
	
	public List<VipInfo> findList(VipInfo vipInfo) {
		return super.findList(vipInfo);
	}
	
	public Page<VipInfo> findPage(Page<VipInfo> page, VipInfo vipInfo) {
		return super.findPage(page, vipInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(VipInfo vipInfo) {
		super.save(vipInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(VipInfo vipInfo) {
		super.delete(vipInfo);
	}
	
}