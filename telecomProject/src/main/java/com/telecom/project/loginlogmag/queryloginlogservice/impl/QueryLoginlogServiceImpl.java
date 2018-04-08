package com.telecom.project.loginlogmag.queryloginlogservice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.PageBean;
import com.telecom.project.loginlogmag.queryloginlogdao.IQueryLoginlogDao;
import com.telecom.project.loginlogmag.queryloginlogservice.IQueryLoginlogService;

@Service
public class QueryLoginlogServiceImpl implements IQueryLoginlogService {

	@Resource
	private IQueryLoginlogDao queryLoginlogDaoImpl;
	
	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		page.setTotalRows(queryLoginlogDaoImpl.countByParams2PageBean(params));
		page.setDatas(queryLoginlogDaoImpl.findByParams2PageBean(page, params));
		return page;
	}

	
}
