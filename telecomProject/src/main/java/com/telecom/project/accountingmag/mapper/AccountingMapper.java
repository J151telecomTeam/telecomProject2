package com.telecom.project.accountingmag.mapper;

import java.util.Date;
import java.util.Map;

import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 书写mybatis注解与sql语句
 * @author 
 *
 */
public interface AccountingMapper {
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
	/**
	 * 按年查询服务器使用情况
	 * @param year
	 * @return
	 */
	public AccountingYearBean findByYear(String year);
	
	/**
	 * 按月查询服务器使用情况
	 * @param month
	 * @return
	 */
	public AccountingMonthBean findByMonth(String month);
	
	/**
	 * 按天查询服务器使用情况
	 * @param day
	 * @return
	 */
	public AccountingDayBean findByDay(Date day);
}
