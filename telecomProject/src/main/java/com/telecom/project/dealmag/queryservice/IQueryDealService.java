package com.telecom.project.dealmag.queryservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;

public interface IQueryDealService {
	
	/**
	 * 根据资费外键  查询业务账号对象
	 * @param id
	 * @return
	 */
	public List<BusinessAccountBean> findByFkDealId(long id);

	/**
	 * 根据套餐类型分页查询（搜索调用）
	 * @param page
	 * @param params
	 * @return
	 */
	public PageBean findByType(PageBean page,Map params);
	
	/**
	 * 根据资费id查询资费对象
	 * @param id
	 * @return
	 */
	public DealBean findById(long id);
	
}
