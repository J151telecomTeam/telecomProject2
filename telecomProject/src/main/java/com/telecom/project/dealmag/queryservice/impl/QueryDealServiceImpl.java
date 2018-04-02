package com.telecom.project.dealmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.dealmag.querydao.IQueryDealDao;
import com.telecom.project.dealmag.queryservice.IQueryDealService;

@Service
public class QueryDealServiceImpl implements IQueryDealService{
	
	@Resource
	private IQueryDealDao queryDealDaoImpl;

	@Override
	public PageBean findByType(PageBean page, Map params) {
		// TODO Auto-generated method stub
		int rows = queryDealDaoImpl.countByType(params);
		List<DealBean> deals = queryDealDaoImpl.findByType(page, params);
		page.setTotalRows(rows);
		page.setDatas(deals);
		return page;
	}

	@Override
	public List<BusinessAccountBean> findByFkDealId(long id) {
		// TODO Auto-generated method stub
		return queryDealDaoImpl.findByFkDealId(id);
	}

	@Override
	public DealBean findById(long id) {
		// TODO Auto-generated method stub
		return queryDealDaoImpl.findById(id);
	}

}
