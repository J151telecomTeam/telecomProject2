package com.telecom.project.businessaccountmag.queryservice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;

/**
 * 业务管理 业务层接口
 * @author Administrator
 *
 */
public interface IQueryBusinessAccountService {

	
	
	/**
	 * 根据id查询服务器名字
	 * @param name
	 * @return
	 */
	public ServerBean findServiceByName(Long id);
	/***
	 * 根据类型查询资费Id
	 * @return
	 */
	
	public DealBean findDealByName(int type);
	/***
	 * 查询所有的服务器名字
	 * @return
	 */
	public List<ServerBean> findyByServicName();
	/**
	 * LargeBean
	 * @param account
	 * @return
	 */
	public BillMonthBean findyByBillMonthBean(String account);
	/**
	/**
	 * 查询LargeBean
	 * @param account
	 * @return
	 */
	public BusinessAccountBean finbyIdLargeBean( long id);
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public BusinessAccountBean findByid(long id);
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
}
