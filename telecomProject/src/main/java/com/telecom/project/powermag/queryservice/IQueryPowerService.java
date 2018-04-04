package com.telecom.project.powermag.queryservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryPowerService {
	/**
	 * 根据条件查询权限或者查询所有权限，有分页功能
	 * @param page    pageBean
	 * @param params  条件
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map map);
	

	/**
	 * 角色查权限
	 * @param role
	 * @return
	 */
	public List<PowerBean> findPowerByRole(RoleBean role);
	
	/**
	 * 查权限用ID
	 * @param id
	 * @return
	 */
	public PowerBean findPowerById(long id);
	
}
