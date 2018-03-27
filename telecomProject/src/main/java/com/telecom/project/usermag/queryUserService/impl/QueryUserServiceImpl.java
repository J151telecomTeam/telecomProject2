package com.telecom.project.usermag.queryUserService.impl;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.usermag.queryUserService.IQueryUserService;

/**
 * 用户查询业务实现类
 * @author 
 *
 */
public class QueryUserServiceImpl implements IQueryUserService{

	@Override
	public UserBean findByAccountAndPassword(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean findByid(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> findUserByService(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean findUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

}
