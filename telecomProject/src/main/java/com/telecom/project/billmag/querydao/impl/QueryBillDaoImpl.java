package com.telecom.project.billmag.querydao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessMonthBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerUseMoneyBean;
import com.telecom.project.billmag.mapper.BillMapper;
import com.telecom.project.billmag.querydao.IQueryBillDao;

/**
 * 账单查询接口实现类
 * @author 
 *
 */
@Repository
public class QueryBillDaoImpl implements IQueryBillDao{
	
	@Resource
	private BillMapper bm;

	


	@Override
	public List<BillMonthBean> findAllBillMonth(PageBean page) {
		// TODO Auto-generated method stub
		return bm.findAllBillMonth(page);
	}



	@Override
	public int countByBillMonth(Map params) {
		// TODO Auto-generated method stub
		return bm.countByBillMonth(params);
	}


	@Override
	public List<BillMonthBean> findByPageAndParams(Map params,PageBean page) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		System.out.println(params.get("zwAccount"));
		return bm.findByPageAndParams(params);
	}



	@Override
	public BillMonthBean findById(long id) {
		// TODO Auto-generated method stub
		return bm.findById(id);
	}



	@Override
	public List<BusinessMonthBean> findAllBusinessMonth(String zwAccount,PageBean page) {
		// TODO Auto-generated method stub
		Map params = new HashMap<>();
		params.put("zwAccount", zwAccount);
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return bm.findAllBusinessMonth(params);
	}



	@Override
	public int countByServiceMonth(String zwAccount) {
		// TODO Auto-generated method stub
		return bm.countByServiceMonth(zwAccount);
	}



	@Override
	public DealBean findByDealId(long id) {
		// TODO Auto-generated method stub
		return bm.findByDealId(id);
	}


	@Override
	public ServerUseMoneyBean findByServerUseMoney(String osAccount) {
		// TODO Auto-generated method stub
		return bm.findByServerUseMoney(osAccount);
	}

	

}
