package com.telecom.project.accountingmag.queryServerService;

import java.util.Date;
import java.util.Map;

import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 账务查询业务接口
 * @author 
 *
 */
public interface IQueryAccountingService {
	
	/**
	 * 根据年、月和账务账号查询当月所有的日账务对象(第二次双击调用)
	 * @return
	 */
	public PageBean findByYearAndMonthAndZwAccount(PageBean page,Map params);

	/**
	 * 根据条件查询账务年表或者账务月表(搜索调用)
	 * @param page
	 * @param params
	 * @return
	 */
	public PageBean findByAccountingYearOrMonth(PageBean page,Map params);
	
	/**
	 * 根据年份和账务账号查询用户该年所有的月账务信息(第一次双击调用)
	 * @param page
	 * @param params
	 * @return
	 */
	public PageBean findByYearAndZwAccountForMonth(PageBean page,Map params);
	
}
