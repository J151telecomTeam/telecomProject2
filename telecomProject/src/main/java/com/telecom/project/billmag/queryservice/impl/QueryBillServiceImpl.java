package com.telecom.project.billmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessMonthBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerUseMoneyBean;
import com.telecom.project.billmag.querydao.IQueryBillDao;
import com.telecom.project.billmag.queryservice.IQueryBillService;

/**
 * 账单查询接口实现类
 * @author 
 *
 */
@Service
public class QueryBillServiceImpl implements IQueryBillService{

	@Resource
	private IQueryBillDao queryBillDaoImpl;
	
	@Override
	public PageBean findByBillMonthPage(Map params,PageBean page) {
		// TODO Auto-generated method stub
		int allRows = queryBillDaoImpl.countByBillMonth(params);
		List<BillMonthBean> bills = queryBillDaoImpl.findByPageAndParams(params, page);
		page.setTotalPage(allRows);
		page.setDatas(bills);
		return page;
	}

	@Override
	public PageBean findAllBillPage(PageBean page) {
		// TODO Auto-generated method stub
		List<BillMonthBean> bills = queryBillDaoImpl.findAllBillMonth(page);
		int allRows = bills.size();
		page.setTotalRows(allRows);
		page.setDatas(bills);
		return page;
	}

	@Override
	public BillMonthBean findById(long id) {
		// TODO Auto-generated method stub
		return queryBillDaoImpl.findById(id);
	}

	@Override
	public PageBean findByServiceMonthPage(PageBean page,String zwAccount) {
		// TODO Auto-generated method stub
		int rows = queryBillDaoImpl.countByServiceMonth(zwAccount);
		List<BusinessMonthBean> buss = queryBillDaoImpl.findAllBusinessMonth(zwAccount, page);
		page.setTotalRows(rows);
		page.setDatas(buss);
		return page;
	}

	@Override
	public DealBean findByDealId(long id) {
		// TODO Auto-generated method stub
		return queryBillDaoImpl.findByDealId(id);
	}

	@Override
	public ServerUseMoneyBean findByServerUseMoney(String osAccount) {
		// TODO Auto-generated method stub
		return queryBillDaoImpl.findByServerUseMoney(osAccount);
	}

}
