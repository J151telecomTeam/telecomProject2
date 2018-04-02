package com.telecom.project.rolemag.queryroledao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.mapper.RoleMapper;
import com.telecom.project.rolemag.queryroledao.IQueryRoleDao;

@Repository
public class QueryRoleDaoImpl implements IQueryRoleDao {
	
	
	@Resource
	private RoleMapper roleMapper;

	@Override
	public PageBean findAllRolePage(PageBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean findRoleByConPage(Map map, PageBean page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleBean> findRoleByAdmin(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleBean findRoleById(long id) {
		// TODO Auto-generated method stub
		return roleMapper.findRoleBeanById(id);
	}
	
	@Override
	public List<RoleBean> findAllRole() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRole();
	}

}
