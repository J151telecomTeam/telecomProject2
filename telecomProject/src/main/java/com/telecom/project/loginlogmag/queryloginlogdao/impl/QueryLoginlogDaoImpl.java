package com.telecom.project.loginlogmag.queryloginlogdao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.loginlogmag.mapper.LoginlogMapper;
import com.telecom.project.loginlogmag.queryloginlogdao.IQueryLoginlogDao;

@Repository
public class QueryLoginlogDaoImpl implements IQueryLoginlogDao {

	@Resource
	private LoginlogMapper lm;
	
	@Override
	public long countByParams2PageBean(Map params) {
		// TODO Auto-generated method stub
		return lm.countByParams2PageBean(params);
	}

	@Override
	public List<LoginLogBean> findByParams2PageBean(PageBean page,Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return lm.findByParams2PageBean(params);
	}

}
