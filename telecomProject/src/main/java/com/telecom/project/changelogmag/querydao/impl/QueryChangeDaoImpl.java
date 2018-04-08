package com.telecom.project.changelogmag.querydao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.ChangeBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.changelogmag.mapper.ChangeMapper;
import com.telecom.project.changelogmag.querydao.IQueryChangeDao;


@Repository
public class QueryChangeDaoImpl implements IQueryChangeDao{
	
	@Resource
	private ChangeMapper cm;

	@Override
	public List<ChangeBean> findByParams2PageBean(PageBean page,Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return cm.findByParams2PageBean(params);
	}

	@Override
	public long countByParams2PageBean(Map params) {
		// TODO Auto-generated method stub
		return cm.countByParams2PageBean(params);
	}

}
