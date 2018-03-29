package com.telecom.project.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.servermag.operationservice.IOperationServerService;
import com.telecom.project.servermag.queryservice.IQueryServerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestQueryServer {
	
	@Resource
	private IQueryServerService queryServerServiceImpl;
	
	@Resource
	private IOperationServerService operationServerServiceImpl;
	
	@Test
	public void testFindByServerId() {
		PageBean page = new PageBean(1,3);
		Map map = new HashMap();
		map.put("name", "b");
		List<ServerBean> list = queryServerServiceImpl.findAllServer();
		System.out.println(list);
	}
	
	@Test
	public void testAddServer() {
		ServerBean bean = new ServerBean();
		bean.setName("b");
		
		List<ServerBean> list = new ArrayList<ServerBean>();
		operationServerServiceImpl.deleteBatchServerBean(queryServerServiceImpl.findAllServer());
	}
}
