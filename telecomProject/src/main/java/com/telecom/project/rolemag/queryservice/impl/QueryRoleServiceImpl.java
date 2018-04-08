package com.telecom.project.rolemag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.querydao.IQueryRoleDao;
import com.telecom.project.rolemag.queryservice.IQueryRoleService;
@Service
public class QueryRoleServiceImpl implements IQueryRoleService {

	@Resource
	private IQueryRoleDao dao;
	@Override
	public List<RoleBean> findRoleByUser(AdminBean admin) {
		// TODO Auto-generated method stub
		return dao.findRoleByUser(admin);
	}

	@Override
	public RoleBean findRoleById(long id) {
		// TODO Auto-generated method stub
		return dao.findRoleById(id);
	}

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map map) {
		// TODO Auto-generated method stub
		if(map.get("Name").equals("")) {
			map.put("Name", null);
		}
		if(map.get("Founder").equals("")) {
			map.put("Founder", null);
		}
		long totalRows=dao.countByParams2PageBean(map);
		List<?> datas=dao.findByParams2PageBean(page, map);
		page.setTotalPage(totalRows);
		page.setDatas(datas);
		return page;
	}

	@Override
	public void updatePowerByRole(RoleBean role, PowerBean power) {
		// TODO Auto-generated method stub
		dao.updatePowerByRole(role, power);
	}

	@Override
	public List<PowerBean> findAllpower() {
		// TODO Auto-generated method stub
		return dao.findAllpower();
	}

	@Override
	public List<RoleBean> findAllRole() {
		// TODO Auto-generated method stub
		return dao.findAllRole();
	}

	@Override
	public boolean findRoleByName(String name) {
		// TODO Auto-generated method stub
	    List<RoleBean> list =dao.findRoleByName(name);
		if(list.size()!=0) {
			return false;	
		}else {
			return true;
		}
		
		
	}

	@Override
	public void saveMiddle(RoleBean role) {
		// TODO Auto-generated method stub
		dao.saveMiddle(role);
	}

}
