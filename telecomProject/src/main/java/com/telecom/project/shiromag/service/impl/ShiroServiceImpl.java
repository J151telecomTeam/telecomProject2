package com.telecom.project.shiromag.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.shiromag.dao.IShiroDao;
import com.telecom.project.shiromag.service.IShiroService;

@Service
public class ShiroServiceImpl implements IShiroService{
	
	@Resource
	private IShiroDao shiroDaoImpl;

	@Override
	public AdminBean findAdminByName(String adminName) {
		// TODO Auto-generated method stub
		return shiroDaoImpl.findAdminByName(adminName);
	}

	@Override
	public Set<String> findRoleName(String adminName) {
		// TODO Auto-generated method stub
		return shiroDaoImpl.findRoleName(adminName);
	}

	@Override
	public Set<String> findPermission(String adminName) {
		// TODO Auto-generated method stub
		return shiroDaoImpl.findPermission(adminName);
	}
	
}
