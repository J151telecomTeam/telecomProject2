package com.telecom.project.billmag.operationservice;



import com.telecom.project.beans.BillMonthBean;

/**
 * 账单增删改业务接口
 * @author 
 *
 */

public interface IOperationBillService {
	
	/**
	 * 新增账单
	 * @param bill
	 */
	public void saveBillBean(BillMonthBean bill);
	
	/**
	 * 修改账单
	 * @param server
	 */
	public void updateBillBean(BillMonthBean bill);
	
	
	
	
	
}
