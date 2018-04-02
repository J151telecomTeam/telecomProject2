package com.telecom.project.adminmag.queryServerDao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.adminmag.mapper.AdminMapper;
import com.telecom.project.adminmag.queryServerDao.IQueryAdminDao;
import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

/**
 * 服务器查询接口实现类
 * @author 
 *
 */
@Repository
public class QueryAdminDaoImpl implements IQueryAdminDao{
	@Resource
	private AdminMapper am;

	@Override
	public List<AdminBean> findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return am.findByParams2PageBean(params);
	}



	@Override
	public List<AdminBean> findAdminById(long id) {
		// TODO Auto-generated method stub
		return am.findAdminById(id);
	}

	@Override
	public List<AdminBean> findAdminAll() {
		// TODO Auto-generated method stub
		return am.findAdminAll();
	}

	@Override
	public long countByParams2PageBean(Map params) {
		// TODO Auto-generated method stub
		return am.countByParams2PageBean(params);
	}



	@Override
	public List<AdminBean> findAdminByRole(RoleBean role) {
		// TODO Auto-generated method stub
		return am.findAdminByRole(role);
	}

}
