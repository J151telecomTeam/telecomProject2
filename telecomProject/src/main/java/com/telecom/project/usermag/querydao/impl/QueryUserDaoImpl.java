package com.telecom.project.usermag.querydao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.usermag.mapper.UserMapper;
import com.telecom.project.usermag.querydao.IQueryUserDao;
@Repository
public class QueryUserDaoImpl implements IQueryUserDao{

	@Resource
	private UserMapper um;
  
	@Override
	public UserBean findByAccountAndPassword(String account, String password) {
		
	
		return um.findByAccountAndPassword(account, password);
	}

	@Override
	public UserBean findByid(long id) {
		
		return um.findByid(id);
	}

	@Override
	public long countByParams2PageBean(Map params) {
	
		
		return um.countByParams2PageBean(params);
	}

	@Override
	public List<UserBean> findByParams2PageBean(PageBean page, Map params) {	
		
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return um.findByParams2PageBean(params);
	}

	@Override
	public List<UserBean> findUserByService(long id) {
		
		
		return um.findUserByService(id);
	}

	@Override
	public UserBean findUserByAccount(String account) {
	
		return um.findUserByAccount(account);
	}

	

	
	
	
	

}
