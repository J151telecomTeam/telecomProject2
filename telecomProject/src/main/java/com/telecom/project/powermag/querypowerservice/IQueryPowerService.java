package com.telecom.project.powermag.querypowerservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryPowerService {
	/**
	 * 查找所有权限
	 * @param page
	 * @return
	 */
	public PageBean findAllPowerPage(PageBean page);
	/**
	 * 查询权限+条件
	 * @param map
	 * @return
	 */
	public PageBean findPowerByConPage(Map map,PageBean page);

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
