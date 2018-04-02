package com.telecom.project.accountingmag.queryServerService.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.queryServerDao.IQueryAccountingDao;
import com.telecom.project.accountingmag.queryServerService.IQueryAccountingService;
import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 账务查询接口实现类
 * @author 
 *
 */
@Service
public class QueryAccountingServiceImpl implements IQueryAccountingService{

	@Resource
	private IQueryAccountingDao operationAccountingDaoImpl;

	@Override
	public PageBean findByAccountingYearOrMonth(PageBean page, Map params) {
		// TODO Auto-generated method stub
		if("全部".equals(params.get("month"))) {
			int rows = operationAccountingDaoImpl.countByYear(params);
			List<AccountingYearBean> years = operationAccountingDaoImpl.findByYearPage(page, params);
			page.setTotalRows(rows);
			page.setDatas(years);
		}else {
			int rows = operationAccountingDaoImpl.countByMonth(params);
			List<AccountingMonthBean> months = operationAccountingDaoImpl.findByMonthPage(page, params);
			page.setTotalRows(rows);
			page.setDatas(months);
		}
		
		return page;
	}

	@Override
	public PageBean findByYearAndZwAccountForMonth(PageBean page, Map params) {
		// TODO Auto-generated method stub
		int rows = operationAccountingDaoImpl.countByYearAndZwAccountForMonth(params);
		List<AccountingMonthBean> months = operationAccountingDaoImpl.findByYearAndZwAccountForMonth(page, params);
		page.setTotalRows(rows);
		page.setDatas(months);
		return page;
	}

	@Override
	public PageBean findByYearAndMonthAndZwAccount(PageBean page,Map params) {
		// TODO Auto-generated method stub
		int rows = operationAccountingDaoImpl.countByYearAndMonthAndZwAccount(params);
		List<AccountingDayBean> days = operationAccountingDaoImpl.findByYearAndMonthAndZwAccount(page, params);
		page.setTotalRows(rows);
		page.setDatas(days);
		return page;
	}

}
