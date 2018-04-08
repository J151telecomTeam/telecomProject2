package com.telecom.project.changelogmag.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.PageBean;
import com.telecom.project.changelogmag.queryservice.IQueryChangeService;
import com.telecom.project.utils.DateConverter;

@RequestMapping("/change")
@RestController
public class ChangeController {
	
	@Resource
	private IQueryChangeService queryChangeServiceImpl;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@RequestMapping(value="/page",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findAllChange(PageBean page) {
		log.info(page);
		Map params = new HashMap();
		try {
			PageBean bean  = queryChangeServiceImpl.findByParams2PageBean(page, params);
			params.put("total", bean.getTotalRows());
			params.put("rows", bean.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("ChangeController-------findAllChange",e);
		}
		return params;
	}
	
	@RequestMapping(value="/findByParams",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findByParams2PageBean(PageBean page,@RequestParam Map param) throws ParseException {
		log.info(page);
		log.info(param);
		Map params = new HashMap();
		String name = param.get("name").toString();
		
		
//		if(param.get("ontime").equals("")||param.get("ontime")!=null) {
//			String date = param.get("ontime").toString();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date ontime = sdf.parse(date);
//			params.put("ontime", ontime);
//		}
//		if(param.get("endtime").equals("")||param.get("endtime")!=null) {
//			String date1 = param.get("endtime").toString();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date endtime = sdf.parse(date1);
//			params.put("endtime", endtime);
//		}
		params.put("name", name);
		try {
			PageBean bean = queryChangeServiceImpl.findByParams2PageBean(page, params);
			params.put("total",bean.getTotalRows());
			params.put("rows", bean.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("ChangeController-------findByParams2PageBean",e);
		}
		return params;
	}
}
