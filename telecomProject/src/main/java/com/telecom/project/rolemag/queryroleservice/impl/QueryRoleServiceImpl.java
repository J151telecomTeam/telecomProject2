package com.telecom.project.rolemag.queryroleservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.queryroledao.IQueryRoleDao;
import com.telecom.project.rolemag.queryroleservice.IQueryRoleService;

@Service
public class QueryRoleServiceImpl implements IQueryRoleService {
	@Resource
	private IQueryRoleDao  queryRoleDao;

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
	public RoleBean findRoleByUser(AdminBean admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleBean findRoleById(long id) {
		// TODO Auto-generated method stub
		return queryRoleDao.findRoleById(id);
	}

	@Override
	public List<RoleBean> findAllRole() {
		// TODO Auto-generated method stub
		return queryRoleDao.findAllRole();
	}
	

}
