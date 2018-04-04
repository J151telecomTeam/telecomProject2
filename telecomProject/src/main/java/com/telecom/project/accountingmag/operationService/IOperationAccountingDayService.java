package com.telecom.project.accountingmag.operationService;

import com.telecom.project.beans.AccountingDayBean;

public interface IOperationAccountingDayService {

	/**
	 * 新增账务日表数据
	 * @param ad
	 */
	public void saveAccountingDayBean(AccountingDayBean ad);
	
}
