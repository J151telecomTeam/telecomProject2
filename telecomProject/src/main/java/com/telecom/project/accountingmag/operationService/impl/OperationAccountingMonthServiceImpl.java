package com.telecom.project.accountingmag.operationService.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.operationDao.IOperationAccountingMonthDao;
import com.telecom.project.accountingmag.operationService.IOperationAccountingMonthService;
import com.telecom.project.beans.AccountingMonthBean;

@Service
public class OperationAccountingMonthServiceImpl implements IOperationAccountingMonthService{

	@Resource
	private IOperationAccountingMonthDao operationAccountingMonthDao;
	
	@Override
	public void saveAccountingMonthBean(AccountingMonthBean am) {
		// TODO Auto-generated method stub
		operationAccountingMonthDao.save(am);
	}

}
