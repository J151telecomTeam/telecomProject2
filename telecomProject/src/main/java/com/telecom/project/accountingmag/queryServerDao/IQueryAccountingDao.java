package com.telecom.project.accountingmag.queryServerDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

/**
 * 账务查询持久层接口
 * @author 
 *
 */
public interface IQueryAccountingDao {
	
	/**
	 * 根据年、月和账务账号查询所有的日账务信息对象
	 * @return
	 */
	public List<AccountingDayBean> findByYearAndMonthAndZwAccount(PageBean page,Map params);
	
	/**
	 * 根据年、月和账务账号查询所有符合要求的日账务对象数量
	 * @return
	 */
	public int countByYearAndMonthAndZwAccount(Map params);
	
	/**
	 * 根据年份和账务账号查询对应的月账务对象集合
	 * @param page
	 * @param params
	 * @return
	 */
	public List<AccountingMonthBean> findByYearAndZwAccountForMonth(PageBean page,Map params);
	
	/**
	 * 根据年份和账务账号查询对应的月账务对象数量
	 * @param params
	 * @return
	 */
	public int countByYearAndZwAccountForMonth(Map params);
	
	/**
	 * 根据条件查询所有符合要求的月账务对象
	 * @param page
	 * @param params
	 * @return
	 */
	public List<AccountingMonthBean> findByMonthPage(PageBean page,Map params);
	
	/**
	 * 查询所有符合条件的账务月表对象数量
	 * @param params
	 * @return
	 */
	public int countByMonth(Map params);

	/**
	 * 根据条件查询所有符合要求的年账务对象数量
	 * @param params
	 * @return
	 */
	public int countByYear(Map params);
	
	/**
	 * 根据条件分页查询所有符合要求的年账务对象
	 * @param page
	 * @param params
	 * @return
	 */
	public List<AccountingYearBean> findByYearPage(PageBean page,Map params);
	
}
