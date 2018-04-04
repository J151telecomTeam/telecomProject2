package com.telecom.project.powermag.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.powermag.operationservice.IOperationPowerService;
import com.telecom.project.powermag.queryservice.IQueryPowerService;

@RequestMapping("/power")
@RestController
public class PowerController {

	@Resource
	private IOperationPowerService  IOperationPowerServiceimpl;
	@Resource
	private IQueryPowerService IQueryPowerServiceimpl;
	
	
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@RequestMapping(value="/findAllPage",method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map findPowerListByObject2PageBean(PageBean page,PowerBean bean) {
	
		Map map = new HashMap();
		Map map1 = new HashMap();
		map1.put("Name", bean.getName());
		map1.put("Founder", bean.getFounder());
		try {
		Long index = (page.getPage()-1)*page.getRows();
		page.setIndex(index);
		page=IQueryPowerServiceimpl.findByParams2PageBean(page, map1);
		map.put("total", page.getTotalPage());
		map.put("rows", page.getDatas());
	
		
		} catch (Exception e) {		
			
		}
		
		return map;
	
}
	@RequestMapping(value="/findAllPageByparams",method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map findPowerListByObject2PageBeanByparams(@RequestBody PageBean page,PowerBean bean) {
		System.out.println(2);
		String N =bean.getName();
		String F=bean.getFounder();
		
		Map map1 = new HashMap();
		if(N.equals("")) {
			N=null;
		}else if (F.equals("")){
			F=null;
		}else {
			map1.put("Name", N);
			map1.put("Founder",F);
		}		
		page.setRows(10);
		page.setIndex(0);
		Map map = new HashMap();
		try {
			page=IQueryPowerServiceimpl.findByParams2PageBean(page,map1);
			map.put("total", page.getTotalRows());
			map.put("rows", page.getDatas());
			
		} catch (Exception e) {		
			
		}
		System.out.println(map1);
		System.out.println(page);
		return map;
		
	}
	
	@RequestMapping(value = "/addPowerBean", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public Messager SavePowerBean(PowerBean bean) {
		Messager msg = new Messager(true, "操作成功！");
		
		try {
			Date date = new Date();
			bean.setTime(date);
			bean.setFounder("a");
			IOperationPowerServiceimpl.savePower(bean);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		
		return msg;
		
	}
	
	@RequestMapping(value = "/deleteBatchPowerBean", method = { RequestMethod.DELETE }, produces = { "application/json;charset=utf-8" })
	public Messager deletePowerBean(@RequestBody List<PowerBean> powers) {
		System.out.println(1);
		Messager msg = new Messager(true, "操作成功！");
		try {
			IOperationPowerServiceimpl.deleteBatchPower(powers);;
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		
		return msg;
	}
	
	
	@RequestMapping(value = "/updatePowerBean/{id}", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public Messager updatePowerBean(PowerBean bean) {
		log.info(bean);
		Messager msg = new Messager(true, "操作成功！");
		try {
			IOperationPowerServiceimpl.updatePower(bean);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
		
	}
	
	
}
