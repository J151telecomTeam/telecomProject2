package com.telecom.project.accountingmag.queryServerDao.impl;

import java.util.Date;
import java.util.Map;

import com.telecom.project.accountingmag.queryServerDao.IOperationAccountingDao;
import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 账务查询接口实现类
 * @author 
 *
 */
public class OperationAccountingDaoImpl implements IOperationAccountingDao{

	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountingYearBean findByYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountingMonthBean findByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountingDayBean findByDay(Date day) {
		// TODO Auto-generated method stub
		return null;
	}

}
