package com.telecom.project.accountingmag.operationService.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.operationDao.IOperationAccountingYearDao;
import com.telecom.project.accountingmag.operationService.IOperationAccountingYearService;
import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;

@Service
public class OperationAccountingYearServiceImpl implements IOperationAccountingYearService{
	
	@Resource
	private IOperationAccountingYearDao operationAccountingYearDao;

	@Override
	public void saveAccountingYearBean(AccountingYearBean accountingYearBean) {
		// TODO Auto-generated method stub
		operationAccountingYearDao.save(accountingYearBean);
	}

	

}
