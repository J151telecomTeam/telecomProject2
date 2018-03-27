package com.telecom.project.powermag.mapper;

import java.util.Date;
import java.util.List;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface PowerMapper {
	/**
	 * 查找所有权限
	 * @param page
	 * @return
	 */
	public List<PowerBean> findAllPowerPage(PageBean page);
	/**
	 * 查询权限+条件
	 * @param name
	 * @param founder
	 * @param onDate
	 * @param endDate
	 * @return
	 */
	public List<PowerBean> findPowerByConPage(String name,String founder,Date onDate,Date endDate);

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
	public PowerBean findPowerById(int id);
}
