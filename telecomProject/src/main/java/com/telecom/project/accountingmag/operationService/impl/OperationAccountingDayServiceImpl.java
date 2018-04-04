package com.telecom.project.accountingmag.operationService.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.operationDao.IOperationAccountingDayDao;
import com.telecom.project.accountingmag.operationService.IOperationAccountingDayService;
import com.telecom.project.beans.AccountingDayBean;

@Service
public class OperationAccountingDayServiceImpl implements IOperationAccountingDayService{

	@Resource
	private IOperationAccountingDayDao operationAccountingDayDao;
	
	@Override
	public void saveAccountingDayBean(AccountingDayBean ad) {
		// TODO Auto-generated method stub
		operationAccountingDayDao.save(ad);
	}

}
