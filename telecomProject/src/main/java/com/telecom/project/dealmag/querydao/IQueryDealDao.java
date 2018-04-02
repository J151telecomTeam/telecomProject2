package com.telecom.project.dealmag.querydao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;

public interface IQueryDealDao {
	
	/**
	 * 根据资费id查询资费对象
	 * @param id
	 * @return
	 */
	public DealBean findById(long id);
	
	/**
	 * 根据资费外键  查询业务账号对象
	 * @param id
	 * @return
	 */
	public List<BusinessAccountBean> findByFkDealId(long id);
	
	/**
	 * 根据套餐类型查询所有符合要求的资费对象
	 * @param page
	 * @param params
	 * @return
	 */
	public List<DealBean> findByType(PageBean page,Map params);

	/**
	 * 根据套餐类型查询所有符合要求的资费对象数量
	 * @param params
	 * @return
	 */
	public int countByType(Map params);
	
	
}
