package com.telecom.project.servermag.queryservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.servermag.querydao.IQueryServerDao;
import com.telecom.project.servermag.queryservice.IQueryServerService;

/**
 * 服务器查询接口实现类
 * @author 
 *
 */
@Service
public class QueryServerServiceImpl implements IQueryServerService{

	@Resource
	private IQueryServerDao queryServerDaoImpl;
	
	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		long totalRows = queryServerDaoImpl.findServerByPage(params);
		page.setDatas(queryServerDaoImpl.findByParams2PageBean(page, params));
		page.setTotalRows(totalRows);
		return page;
	}

	@Override
	public ServerBean findByServerId(long id) {
		// TODO Auto-generated method stub
		return queryServerDaoImpl.findServerId(id);
	}

	@Override
	public List<ServerBean> findServerByUser(long id) {
		// TODO Auto-generated method stub
		return queryServerDaoImpl.findServerByUser(id);
	}

	@Override
	public PageBean findAllServerPage(PageBean page) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		long totalRows = queryServerDaoImpl.findServerByPage(map);
		page.setDatas(queryServerDaoImpl.findAllServerPage(page));
		page.setTotalRows(totalRows);
		return page;
	}

	@Override
	public List<ServerBean> findAllServer() {
		// TODO Auto-generated method stub
		return queryServerDaoImpl.findAllServer();
	}

	@Override
	public List<ServerBean> findServerByDeal(long id) {
		// TODO Auto-generated method stub
		return queryServerDaoImpl.findServerByDeal(id);
	}

}
