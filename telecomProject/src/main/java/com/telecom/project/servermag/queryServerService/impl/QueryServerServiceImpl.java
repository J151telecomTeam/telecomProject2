package com.telecom.project.servermag.queryServerService.impl;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.ServerUseMoneyBean;
import com.telecom.project.servermag.queryServerService.IQueryServerService;

/**
 * 服务器查询接口实现类
 * @author 
 *
 */
public class QueryServerServiceImpl implements IQueryServerService{

	
	
	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerUseMoneyBean findByServerId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerBean> findServerByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean findAllServerPage(PageBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerBean> findAllServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerBean findServerByDeal(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
