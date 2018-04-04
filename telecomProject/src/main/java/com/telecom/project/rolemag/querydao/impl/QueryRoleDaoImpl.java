package com.telecom.project.rolemag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.mapper.RoleMapper;
import com.telecom.project.rolemag.querydao.IQueryRoleDao;
@Repository
public class QueryRoleDaoImpl implements IQueryRoleDao {

	@Resource
	private RoleMapper rm;
	@Override
	public List<RoleBean> findRoleByUser(AdminBean admin) {
		// TODO Auto-generated method stub
		return rm.findRoleByUser(admin);
	}



	@Override
	public long countByParams2PageBean(Map map) {
		// TODO Auto-generated method stub
		return rm.countByParams2PageBean(map);
	}

	@Override
	public List<RoleBean> findByParams2PageBean(PageBean page,Map map) {
		// TODO Auto-generated method stub
		map.put("index", page.getIndex());
		map.put("rows", page.getRows());
		return rm.findByParams2PageBean(map);
	}

	@Override
	public void updatePowerByRole(RoleBean role, PowerBean power) {
		// TODO Auto-generated method stub
          rm.updatePowerByRole(role, power);
	}

	@Override
	public List<PowerBean> findAllpower() {
		// TODO Auto-generated method stub
		
		return rm.findAllpower();
	}


	@Override
	public RoleBean findRoleById(long id) {
		// TODO Auto-generated method stub
		return rm.findRoleBeanById(id);
	}
	
	@Override
	public List<RoleBean> findAllRole() {
		// TODO Auto-generated method stub
		return rm.findAllRole();
	}


}
