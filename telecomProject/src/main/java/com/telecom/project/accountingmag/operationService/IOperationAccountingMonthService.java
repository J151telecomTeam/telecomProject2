package com.telecom.project.accountingmag.operationService;

import com.telecom.project.beans.AccountingMonthBean;

public interface IOperationAccountingMonthService {

	/**
	 * 新增账务月表数据
	 * @param am
	 */
	public void saveAccountingMonthBean(AccountingMonthBean am);
	
}
