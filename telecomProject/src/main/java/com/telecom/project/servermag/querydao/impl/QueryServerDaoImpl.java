package com.telecom.project.servermag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.ServerUseMoneyBean;
import com.telecom.project.servermag.mapper.ServerMapper;
import com.telecom.project.servermag.querydao.IQueryServerDao;

/**
 * 服务器查询接口实现类
 * @author 
 *
 */
@Repository
public class QueryServerDaoImpl implements IQueryServerDao{
	
	@Resource
	private ServerMapper sm;
	

	@Override
	public List<ServerBean> findByParams2PageBean(PageBean page, Map map) {
		// TODO Auto-generated method stub
		map.put("index", page.getIndex());
		map.put("rows", page.getRows());
		return sm.findByParams2PageBean(map);
	}

	@Override
	public List<ServerBean> findServerByUser(long id) {
		// TODO Auto-generated method stub
		return sm.findServerByUser(id);
	}

	@Override
	public List<ServerBean> findAllServerPage(PageBean page) {
		// TODO Auto-generated method stub
		return sm.findAllServerPage(page);
	}

	@Override
	public List<ServerBean> findAllServer() {
		// TODO Auto-generated method stub
		return sm.findAllServer();
	}

	@Override
	public ServerBean findServerId(long id) {
		// TODO Auto-generated method stub
		return sm.findServerId(id);
	}

	@Override
	public long findServerByPage(Map map) {
		// TODO Auto-generated method stub
		return sm.findServerByPage(map);
	}

	@Override
	public List<ServerBean> findServerByDeal(long id) {
		// TODO Auto-generated method stub
		return sm.findServerByDeal(id);
	}

}
