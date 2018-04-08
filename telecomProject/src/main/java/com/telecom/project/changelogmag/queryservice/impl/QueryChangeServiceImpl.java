package com.telecom.project.changelogmag.queryservice.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.PageBean;
import com.telecom.project.changelogmag.querydao.IQueryChangeDao;
import com.telecom.project.changelogmag.queryservice.IQueryChangeService;

/**
 * 操作日志查询接口实现类
 * @author 
 *
 */
@Service
public class QueryChangeServiceImpl implements IQueryChangeService{
	
	@Resource
	private IQueryChangeDao queryChangeDaoImpl;

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		page.setTotalRows(queryChangeDaoImpl.countByParams2PageBean(params));
		page.setDatas(queryChangeDaoImpl.findByParams2PageBean(page,params));
		return page;
	}

}
