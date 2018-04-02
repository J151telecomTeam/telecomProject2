package com.telecom.project.dealmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.dealmag.mapper.DealMapper;
import com.telecom.project.dealmag.querydao.IQueryDealDao;

@Repository
public class QueryDealDaoImpl implements IQueryDealDao{
	
	@Resource
	private DealMapper dm;

	@Override
	public List<DealBean> findByType(PageBean page, Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return dm.findByType(params);
	}

	@Override
	public int countByType(Map params) {
		// TODO Auto-generated method stub
		return dm.countByType(params);
	}

	@Override
	public List<BusinessAccountBean> findByFkDealId(long id) {
		// TODO Auto-generated method stub
		return dm.findByFkDealId(id);
	}

	@Override
	public DealBean findById(long id) {
		// TODO Auto-generated method stub
		return dm.findById(id);
	}

}
