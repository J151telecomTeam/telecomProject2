package com.telecom.project.powermag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.powermag.querydao.IQueryPowerDao;
import com.telecom.project.powermag.queryservice.IQueryPowerService;
@Service
public class QueryPowerServiceImpl implements IQueryPowerService {


	@Resource
	private IQueryPowerDao QueryPowerDaoImpl;
	
		/**
		 * 根据角色查权限
		 */
	@Override
	public List<PowerBean> findPowerByRole(RoleBean role) {
		// TODO Auto-generated method stub
		return QueryPowerDaoImpl.findPowerByRole(role);
	}

	/**
	 * 根据ID查权限
	 */
	@Override
	public PowerBean findPowerById(long id) {
		// TODO Auto-generated method stub
		return QueryPowerDaoImpl.findPowerById(id);
	}

	/**
	 * 查询所有和条件查询，有分页功能
	 */
	@Override
	public PageBean findByParams2PageBean(PageBean page, Map map) {
		// TODO Auto-generated method stub
		if(map.get("Name").equals("")) {
			map.put("Name", null);
		}
		if(map.get("Founder").equals("")) {
			map.put("Founder", null);
		}
		long totalRows =QueryPowerDaoImpl.countByParams2PageBean(map);
		List<?> datas =QueryPowerDaoImpl.findByParams2PageBean(page, map); 
		page.setTotalPage(totalRows);
		page.setDatas(datas);
		
		return page;
	}

	
	
}
