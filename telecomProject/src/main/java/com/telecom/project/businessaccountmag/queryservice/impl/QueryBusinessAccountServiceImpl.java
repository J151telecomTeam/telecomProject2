package com.telecom.project.businessaccountmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.businessaccountmag.querydao.IQueryBusinessAccountDao;
import com.telecom.project.businessaccountmag.queryservice.IQueryBusinessAccountService;


/**
 * 业务管理 业务实现类
 * @author 
 *
 */
@Service
public class QueryBusinessAccountServiceImpl implements IQueryBusinessAccountService {

	@Resource
	private IQueryBusinessAccountDao queryBusinessAccountDaoImpl;
	@Override
	public BusinessAccountBean findByid(long id) {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.findByid(id);
	}

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		long totalRows = queryBusinessAccountDaoImpl.countByParams2PageBean(params);
		List<?> datas = queryBusinessAccountDaoImpl.findByParams2PageBean(page, params);
		page.setTotalRows(totalRows);
		page.setDatas(datas);
		return page;
	}

	@Override
	public BusinessAccountBean finbyIdLargeBean(long id) {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.finbyIdLargeBean(id);
	}

	@Override
	public BillMonthBean findyByBillMonthBean(String account) {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.findyByBillMonthBean(account);
	}

	@Override
	public List<ServerBean> findyByServicName() {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.findyByServicName();
	}

	@Override
	public ServerBean findServiceByName(Long id) {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.findServiceByName(id);
	}

	@Override
	public DealBean findDealByName(int type) {
		// TODO Auto-generated method stub
		return queryBusinessAccountDaoImpl.findDealByName(type);
	}

	
	
	

}
