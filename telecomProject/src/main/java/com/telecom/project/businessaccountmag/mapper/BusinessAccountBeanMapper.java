package com.telecom.project.businessaccountmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;

public interface BusinessAccountBeanMapper {
	
	/**
	 * 查询所有的资费类型
	 * @return
	 */
	public List<DealBean> finddealBean ();
	/**
	 * 根据服务器名字查询id
	 * @param name
	 * @return
	 */
	public ServerBean findServiceByName(@Param("id")Long id);
	/***
	 * 根据类型查询资费Id
	 * @return
	 */
	
	public DealBean findDealByName(@Param("id")Long id);
	/***
	 * 查询所有的服务器名字
	 * @return
	 */
	public List<ServerBean> findyByServicName();
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public BusinessAccountBean findByid(@Param("id")long id);
	
	/**
	 * 根据条件完成分页统计
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(@Param("params")Map params);
	/**
	 * 根据条件完成分页数据的具体查询
	 * @param page
	 * @param params
	 * @return
	 */
	public List<BusinessAccountBean> findByParams2PageBean(@Param("params") Map params);
	
	/**
	 * 查询LargeBean
	 * @param account
	 * @return
	 */
	public BusinessAccountBean finbyIdLargeBean(@Param("id") long id);
	/**
	 * 查询LargeBean
	 * @param account
	 * @return
	 */
	public BillMonthBean findyByBillMonthBean(@Param("account") String account);
	
	
}
