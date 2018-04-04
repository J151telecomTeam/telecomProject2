package com.telecom.project.usermag.queryservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.usermag.querydao.IQueryUserDao;
import com.telecom.project.usermag.queryservice.IQueryUserService;

/**
 * 用户查询业务实现类
 * @author 
 *
 */
@Service
public class QueryUserServiceImpl implements IQueryUserService{

	@Resource
	private IQueryUserDao queryUserDaoImpl;
	
	@Override
	public UserBean findByAccountAndPassword(String account, String password) {
		// TODO Auto-generated method stub
		return queryUserDaoImpl.findByAccountAndPassword(account, password);
	}

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		long totalRows = queryUserDaoImpl.countByParams2PageBean(params);
		List<?> datas = queryUserDaoImpl.findByParams2PageBean(page, params);
		page.setTotalRows(totalRows);
		page.setDatas(datas);
		return page;
	}

	@Override
	public UserBean findByid(long id) {
		// TODO Auto-generated method stub
		return queryUserDaoImpl.findByid(id);
	}

	@Override
	public List<UserBean> findUserByService(long id) {
		// TODO Auto-generated method stub
		return queryUserDaoImpl.findUserByService(id);
	}

	@Override
	public UserBean findUserByAccount(String account) {
		// TODO Auto-generated method stub
		return queryUserDaoImpl.findUserByAccount(account);
	}



	


	
	
}
