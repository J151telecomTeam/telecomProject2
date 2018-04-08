package com.telecom.project.userservermag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.PageBean;
import com.telecom.project.servermag.queryservice.IQueryServerService;

@RequestMapping("/userServer")
@RestController
public class UserServerController {
	
	@Resource
	private IQueryServerService queryServerServiceImpl;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/page",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findServerAllByPage(PageBean page,String name,String acc) {
		Map map = new HashMap();
		log.info(page);
		try {
			Long index = (page.getPage()-1)*page.getRows();
			page.setIndex(index);
			page = queryServerServiceImpl.findAllServerPage(page);
			map.put("total", page.getTotalRows());
			map.put("rows", page.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----findServerConByPage()", e);
		}
		return map;
	}
	
	
}
