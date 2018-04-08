package com.telecom.project.servermag.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.servermag.operationservice.IOperationServerService;
import com.telecom.project.servermag.queryservice.IQueryServerService;

@RequestMapping("/server")
@RestController
public class ServerController {
	
	@Resource
	private IQueryServerService queryServerServiceImpl;
	
	@Resource
	private IOperationServerService operationServerServiceImpl;
	
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/page",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findServerAllByPage(PageBean page) {
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
	
	@RequestMapping(value="/add",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Messager saveServerBean(ServerBean server) {
		log.info(server);
		Messager msg = new Messager(true, "操作成功！");
		try {
			server.setState("关闭");
			server.setMaintain("正常");
			operationServerServiceImpl.saveServerBean(server);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----saveServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/{id}",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public Messager deleteServerBean(ServerBean server) {
		log.info(server);
		Messager msg = new Messager(true, "操作成功！");
		try {
			operationServerServiceImpl.deleteServerBeanById(server.getId());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----deleteServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/batch",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public Messager deleteBatchServerBean(@RequestBody List<ServerBean> servers) {
		log.info(servers);
		Messager msg = new Messager(true, "操作成功！");
		try {
			operationServerServiceImpl.deleteBatchServerBean(servers);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----deleteBatchServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/conPage",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Map findServerConByPage(PageBean page,ServerBean server) {
		Map map = new HashMap();
		Map map2 = new HashMap();
		map.put("name", server.getName());
		map.put("state", server.getState());
		log.info(server);
		try {
			Long index = (page.getPage()-1)*page.getRows();
			page.setIndex(index);
			page = queryServerServiceImpl.findByParams2PageBean(page, map);
			map2.put("total", page.getTotalRows());
			map2.put("rows", page.getDatas());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----findServerConByPage()", e);
		}
		return map2;
	}
	
	@RequestMapping(value="/update/{id}",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Messager updateServerBean(ServerBean server) {
		log.info(server);
		Messager msg = new Messager(true, "操作成功！");
		try {
			long id = server.getId();
			ServerBean bean = queryServerServiceImpl.findByServerId(id);
			System.out.println(bean);
			if(!server.getName().trim().equals("") && !server.getName().equals(null)) {
				bean.setName(server.getName());
			}
			if(!server.getIp().trim().equals("") && !server.getIp().equals(null)) {
				bean.setIp(server.getIp());
			}
			operationServerServiceImpl.updateServerBean(bean);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----updateServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/open/{id}",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Messager openServerBean(ServerBean server) {
		log.info(server);
		Messager msg = new Messager(true, "操作成功！");
		server = queryServerServiceImpl.findByServerId(server.getId());
		try {
			server.setState("开启");
			operationServerServiceImpl.updateServerBean(server);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----openServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	@RequestMapping(value="/off/{id}",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Messager offServerBean(ServerBean server) {
		log.info(server);
		Messager msg = new Messager(true, "操作成功！");
		server = queryServerServiceImpl.findByServerId(server.getId());
		try {
			server.setState("关闭");
			operationServerServiceImpl.updateServerBean(server);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("ServerController-----offServerBean()", e);
			msg.setStatus(false);
			msg.setInformation("系统繁忙，请稍后重试！");
		}
		return msg;
	}
	
	
	
}
