package com.telecom.project.loginlogmag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.PageBean;
import com.telecom.project.loginlogmag.queryloginlogservice.IQueryLoginlogService;

@RequestMapping("/loginlog")
@RestController
public class LoginLogController {
	
	@Resource
	private IQueryLoginlogService queryLoginlogServiceImpl;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/find",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findAllLoginLog(PageBean page) {
		log.info(page);
		Map params = new HashMap();
		try {
			PageBean bean = queryLoginlogServiceImpl.findByParams2PageBean(page, params);
			params.put("total",bean.getTotalRows());
			params.put("rows", bean.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("ChangeController-------findByParams2PageBean",e);
		}
		return params;
	}
	
	@RequestMapping(value="/findByParams",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findByParams2PageBean(PageBean page,@RequestParam Map param) {
		log.info(page);
		log.info(param);
		Map params = new HashMap();
		String name = param.get("name").toString();
		params.put("name", name);
//		String onDate = param.get("ontime").toString();
//		String endDate = param.get("endtime").toString();
//		params.put("onDate", onDate);
//		params.put("endDate", endDate);
		try {
			PageBean bean = queryLoginlogServiceImpl.findByParams2PageBean(page, params);
			params.put("total",bean.getTotalRows());
			params.put("rows", bean.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("LoginLogController-------findByParams2PageBean",e);
		}
		return params;
	}
}
