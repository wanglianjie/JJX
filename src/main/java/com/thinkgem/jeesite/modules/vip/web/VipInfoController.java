/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.vip.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.vip.entity.VipInfo;
import com.thinkgem.jeesite.modules.vip.service.VipInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 会员信息Controller
 * @author WLJ
 * @version 2018-04-24
 */
@Controller
@RequestMapping(value = "${adminPath}/vip/vipInfo")
@Api(tags = "VipInfoController", description = "会员信息相关")  
public class VipInfoController extends BaseController {

	@Autowired
	private VipInfoService vipInfoService;
	
	@ModelAttribute
	public VipInfo get(@RequestParam(required=false) String id) {
		VipInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vipInfoService.get(id);
		}
		if (entity == null){
			entity = new VipInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("vip:vipInfo:view")
	@RequestMapping(value = {"list", ""})
	@ApiOperation(value = "获取会员信息", httpMethod = "GET", notes = "获取会员信息")  
	public String list(VipInfo vipInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VipInfo> page = vipInfoService.findPage(new Page<VipInfo>(request, response), vipInfo); 
		model.addAttribute("page", page);
		return "modules/vip/vipInfoList";
	}

	@RequiresPermissions("vip:vipInfo:view")
	@RequestMapping(value = "form")
	public String form(VipInfo vipInfo, Model model) {
		model.addAttribute("vipInfo", vipInfo);
		return "modules/vip/vipInfoForm";
	}

	@RequiresPermissions("vip:vipInfo:edit")
	@RequestMapping(value = "save")
	public String save(VipInfo vipInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, vipInfo)){
			return form(vipInfo, model);
		}
		vipInfoService.save(vipInfo);
		addMessage(redirectAttributes, "保存保存会员信息成功成功");
		return "redirect:"+Global.getAdminPath()+"/vip/vipInfo/?repage";
	}
	
	@RequiresPermissions("vip:vipInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(VipInfo vipInfo, RedirectAttributes redirectAttributes) {
		vipInfoService.delete(vipInfo);
		addMessage(redirectAttributes, "删除保存会员信息成功成功");
		return "redirect:"+Global.getAdminPath()+"/vip/vipInfo/?repage";
	}
	
	
	@RequiresPermissions("vip:vipInfo:edit")
	@RequestMapping(value = "cousume")
	public String cousume(VipInfo vipInfo, int consumeCount, RedirectAttributes redirectAttributes) {
		String msg = vipInfoService.cousume(vipInfo, consumeCount);
		addMessage(redirectAttributes, msg);
		return "redirect:"+Global.getAdminPath()+"/vip/vipInfo/?repage";
	}

}