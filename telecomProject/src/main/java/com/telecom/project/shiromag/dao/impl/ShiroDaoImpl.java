package com.telecom.project.shiromag.dao.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.shiromag.dao.IShiroDao;
import com.telecom.project.shiromag.mapper.ShiroMapper;

@Repository
public class ShiroDaoImpl implements IShiroDao{
	
	@Resource
	private ShiroMapper sm;

	@Override
	public AdminBean findAdminByName(String adminName) {
		// TODO Auto-generated method stub
		return sm.findAdminByName(adminName);
	}

	@Override
	public Set<String> findRoleName(String adminName) {
		// TODO Auto-generated method stub
		return sm.findRoleName(adminName);
	}

	@Override
	public Set<String> findPermission(String adminName) {
		// TODO Auto-generated method stub
		return sm.findPermission(adminName);
	}
	
}
