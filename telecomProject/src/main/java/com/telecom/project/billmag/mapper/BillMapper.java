package com.telecom.project.billmag.mapper;

import java.util.Map;

import com.telecom.project.beans.PageBean;

/**
 * 书写mybatis注解与sql语句
 * @author 
 *
 */
public interface BillMapper {
	/**
	 * 多参数，完成分页查询
	 * 也可使用该方法查询月账单表和业务账单月表
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
}
