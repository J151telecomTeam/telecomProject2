package com.telecom.project.businessaccountmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.businessaccountmag.mapper.BusinessAccountBeanMapper;
import com.telecom.project.businessaccountmag.querydao.IQueryBusinessAccountDao;

/**
 * 业务持久层实现类
 * @author Administrator
 *
 */
@Repository
public class QueryBusinessAccountDaoImpl implements IQueryBusinessAccountDao{

	@Resource
	private BusinessAccountBeanMapper ba;
	@Override
	public BusinessAccountBean findByid(long id) {
		// TODO Auto-generated method stub
		return ba.findByid(id);
	}

	@Override
	public long countByParams2PageBean(Map params) {
		// TODO Auto-generated method stub
		return ba.countByParams2PageBean(params);
	}

	@Override
	public List<BusinessAccountBean> findByParams2PageBean(PageBean page, Map params) {
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return ba.findByParams2PageBean(params);
	}

	@Override
	public BusinessAccountBean finbyIdLargeBean(@Param("id") long id) {
		// TODO Auto-generated method stub
		return ba.finbyIdLargeBean(id);
	}

	@Override
	public BillMonthBean findyByBillMonthBean(String account) {
		// TODO Auto-generated method stub
		return ba.findyByBillMonthBean(account);
	}

	@Override
	public List<ServerBean> findyByServicName() {
		// TODO Auto-generated method stub
		return ba.findyByServicName();
	}

	
	@Override
	public DealBean findDealByName(int type) {
		// TODO Auto-generated method stub
		return ba.findDealByName(type);
	}

	@Override
	public ServerBean findServiceByName(Long id) {
		// TODO Auto-generated method stub
		return ba.findServiceByName(id);
	}

	


}
