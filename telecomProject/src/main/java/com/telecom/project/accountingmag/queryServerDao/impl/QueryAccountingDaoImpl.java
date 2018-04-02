package com.telecom.project.accountingmag.queryServerDao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.accountingmag.mapper.AccountingMapper;
import com.telecom.project.accountingmag.queryServerDao.IQueryAccountingDao;
import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 账务查询接口实现类
 * @author 
 *
 */
@Repository
public class QueryAccountingDaoImpl implements IQueryAccountingDao{

	@Resource
	private AccountingMapper am;
	
	@Override
	public int countByYear(Map params) {
		// TODO Auto-generated method stub
		return am.countByYear(params);
	}

	@Override
	public List<AccountingYearBean> findByYearPage(PageBean page, Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return am.findByYearPage(params);
	}

	@Override
	public List<AccountingMonthBean> findByMonthPage(PageBean page, Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return am.findByMonthPage(params);
	}

	@Override
	public int countByMonth(Map params) {
		// TODO Auto-generated method stub
		return am.countByMonth(params);
	}

	@Override
	public List<AccountingMonthBean> findByYearAndZwAccountForMonth(PageBean page, Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return am.findByYearAndZwAccountForMonth(params);
	}

	@Override
	public int countByYearAndZwAccountForMonth(Map params) {
		// TODO Auto-generated method stub
		return am.countByYearAndZwAccountForMonth(params);
	}

	@Override
	public List<AccountingDayBean> findByYearAndMonthAndZwAccount(PageBean page,Map params) {
		// TODO Auto-generated method stub
		params.put("index", page.getIndex());
		params.put("rows", page.getRows());
		return am.findByYearAndMonthAndZwAccount(params);
	}

	@Override
	public int countByYearAndMonthAndZwAccount(Map params) {
		// TODO Auto-generated method stub
		return am.countByYearAndMonthAndZwAccount(params);
	}

	

}
