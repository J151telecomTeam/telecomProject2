package com.telecom.project.billmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessMonthBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerUseMoneyBean;

/**
 * 书写mybatis注解与sql语句
 * @author 
 *
 */
public interface BillMapper {
	
	/**
	 * 根据os账号查询对应的服务器信息
	 * @param osAccount
	 * @return
	 */
	public ServerUseMoneyBean findByServerUseMoney(String osAccount);
	
	/**
	 * 根据资费id查询资费对象
	 * @param id
	 * @return
	 */
	public DealBean findByDealId(long id);
	
	/**
	 * 分页查询符合条件的业务月表数据
	 * @param zwAccount
	 * @param page
	 * @return
	 */
	public List<BusinessMonthBean> findAllBusinessMonth(Map params);
	
	/**
	 * 根据账务账号查询所有的业务月表
	 * @param zwAccount
	 * @return
	 */
	public int countByServiceMonth(String zwAccount);
	
	/**
	 * 根据id查询账单
	 * @return
	 */
	public BillMonthBean findById(long id);
	
	/**
	 * 查询所有账单月表对象
	 * @return
	 */
	public List<BillMonthBean> findAllBillMonth(PageBean page);
	
	

	/**
	 * 根据条件查询所有符合要求的对象的数量
	 * @param params
	 * @return
	 */
	public int countByBillMonth(@Param("params") Map params);
	
	/**
	 * 根据条件查询所有符合要求的对象
	 * @param page
	 * @param params
	 * @return
	 */
	public List<BillMonthBean> findByPageAndParams(@Param("params") Map params);

	
}
