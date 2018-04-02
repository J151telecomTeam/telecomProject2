package com.telecom.project.billmag.queryservice;

import java.util.Map;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerUseMoneyBean;

/**
 * 账单查询业务接口
 * @author 
 *
 */
public interface IQueryBillService {
	
	/**
	 * 根据资费id查询资费对象
	 * @param id
	 * @return
	 */
	public DealBean findByDealId(long id);
	
	/**
	 * 查所有账单(进入账单管理界面自动调用)
	 * @param page
	 * @return
	 */
	public PageBean findAllBillPage(PageBean page);
	
	/**
	 * 账单月表分页查询（搜索调用）
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByBillMonthPage(Map params,PageBean page);
	
	/**
	 * 根据id查询账单
	 * @return
	 */
	public BillMonthBean findById(long id);
	
	/**
	 * 业务月表分页查询（第一次双击调用）
	 * @param page
	 * @param params
	 * @return
	 */
	public PageBean findByServiceMonthPage(PageBean page,String zwAccount);
	
	/**
	 * 根据os账号查询对应的服务器信息（第二次双击调用）
	 * @param osAccount
	 * @return
	 */
	public ServerUseMoneyBean findByServerUseMoney(String osAccount);
	
}
