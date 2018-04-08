package com.telecom.project.rolemag.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.operationservice.IOperationRoleService;
import com.telecom.project.rolemag.queryservice.IQueryRoleService;

@RequestMapping("/Role")
@RestController
public class RoleController {

	@Resource
	IOperationRoleService ioperationRoleServiceImpl;
	@Resource
	IQueryRoleService iqueryRoleServicImpl;
 
	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/findRoleAllPage", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public Map findPowerListByObject2PageBean(PageBean page, RoleBean bean) {
		System.out.println(bean);
	
		Map map = new HashMap();
		Map map1 = new HashMap();
		map1.put("Name", bean.getName());
		map1.put("Founder", bean.getFounder());
		try {
		Long index = (page.getPage()-1)*page.getRows();
		page.setIndex(index);
			page = iqueryRoleServicImpl.findByParams2PageBean(page, map1);
			map.put("total", page.getTotalPage());
			map.put("rows", page.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(map);
		return map;
	}

	@RequestMapping(value = "/addRoleBean", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public Messager SaveRoleBean(RoleBean bean) {
		System.out.println(1);
		Messager msg = new Messager(true, "操作成功！");
		Date day=new Date();
		bean.setCreateTime(day);

		try {
			if(iqueryRoleServicImpl.findRoleByName(bean.getName())) {
				ioperationRoleServiceImpl.saveRole(bean);
				iqueryRoleServicImpl.saveMiddle(bean);
			}else {
				msg.setInformation("角色名重复,请重新添加");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}

		return msg;

	}

	@RequestMapping(value = "/deleteBatchRoleBean", method = { RequestMethod.DELETE }, produces = {
			"application/json;charset=utf-8" })
	public Messager deleteRoleBean(@RequestBody List<RoleBean> powers) {
		System.out.println(1);
		Messager msg = new Messager(true, "操作成功！");
		try {
			ioperationRoleServiceImpl.deleteBatchRole(powers);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}

		return msg;
	}

	@RequestMapping(value = "/updateRoleBean"+"/{id}", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public Messager updateRoleBean(@RequestParam Map map) {
//		public Messager updateRoleBean(RoleBean bean, PowerBean power) {
		Messager msg = new Messager(true, "操作成功！");
		RoleBean bean=new RoleBean();
		PowerBean power=new PowerBean();
		bean.setId(Long.valueOf(map.get("id").toString()));
		bean.setName((String) map.get("name"));
		bean.setDescribe((String) map.get("describe"));
		power.setId(Long.valueOf(map.get("powerAll").toString()));
		try {
			ioperationRoleServiceImpl.updateRole(bean);
			iqueryRoleServicImpl.updatePowerByRole(bean, power);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
	}

	/**
	 * 下拉框值准备
	 */
	@RequestMapping(value = "/findAllPowerName", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	
	public List findALLpower() {
		
		List<Map> list = new ArrayList();
		List<PowerBean>	data = iqueryRoleServicImpl.findAllpower();
		
		for (int i = 0; i < data.size(); i++) {
			Map map = new HashMap();
			map.put("id", data.get(i).getId());
			map.put("text", data.get(i).getName());
			list.add(map);
		}
		
		return list;
	}
		
	
}
