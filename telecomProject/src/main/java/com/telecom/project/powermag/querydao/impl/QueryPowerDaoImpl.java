package com.telecom.project.powermag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.powermag.mapper.PowerMapper;
import com.telecom.project.powermag.querydao.IQueryPowerDao;
import com.telecom.project.usermag.mapper.UserMapper;

@Repository
public class QueryPowerDaoImpl implements IQueryPowerDao {
	
	@Resource
	private PowerMapper um;
	
	
	/**
	 * 根据角色查权限
	 */

	@Override
	public List<PowerBean> findPowerByRole(RoleBean role) {
		// TODO Auto-generated method stub
		
		return um.findPowerByRole(role);
	}

	/**
	 * 根据Id查权限
	 */
	@Override
	public PowerBean findPowerById(long id) {
		// TODO Auto-generated method stub
		
		return um.findPowerById(id);
	}

	/**
	 * 根据条件查条数
	 */
	@Override
	public long countByParams2PageBean(Map map) {
		// TODO Auto-generated method stub
			
		return um.countByParams2PageBean(map);
	}

	@Override
	public List<PowerBean> findByParams2PageBean(PageBean page, Map map) {
		// TODO Auto-generated method stub
	
		map.put("index", page.getIndex());
		map.put("rows", page.getRows());
		
		return um.findByParams2PageBean(map);
	}

}
