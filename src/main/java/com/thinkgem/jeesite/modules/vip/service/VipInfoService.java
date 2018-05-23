/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.vip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.vip.dao.VipInfoDao;
import com.thinkgem.jeesite.modules.vip.entity.VipInfo;

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
		logger.warn("VipInfoService.findList param:vipInfo={}",vipInfo);
		return super.findList(vipInfo);
	}
	
	public Page<VipInfo> findPage(Page<VipInfo> page, VipInfo vipInfo) {
		logger.warn("VipInfoService.findPage param:page={} vipInfo={}",page, vipInfo);
		return super.findPage(page, vipInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(VipInfo vipInfo) {
		logger.warn("VipInfoService.save param:vipInfo={}",vipInfo);
		super.save(vipInfo);
	}
	
	@Transactional(readOnly = false)
	public void update(VipInfo vipInfo) {
		logger.warn("VipInfoService.update param:vipInfo={}",vipInfo);
		super.update(vipInfo);
	}
	
	
	
	@Transactional(readOnly = false)
	public void delete(VipInfo vipInfo) {
		logger.warn("VipInfoService.delete param:vipInfo={}",vipInfo);
		super.delete(vipInfo);
	}

	@Transactional(readOnly = false)
	public String cousume(VipInfo vipInfo, int consumeCount) {
		logger.warn("VipInfoService.cousume param:vipInfo={} consumeCount={}", vipInfo, consumeCount);
		VipInfo consumeVip = get(vipInfo);
		if(consumeVip == null){
			logger.warn("该会员不存在！ vipInfo={}", vipInfo);
			throw new RuntimeException("该会员不存在！");
		}
		if(consumeCount > consumeVip.getCurrentTimes()){
			logger.warn("该会员剩余次数不足，无法消费！ vipInfo={} consumeCount={}", vipInfo, consumeCount);
			throw new RuntimeException("该会员剩余次数不足，无法消费！");
		}
		return "消费成功！";
	}
	
}