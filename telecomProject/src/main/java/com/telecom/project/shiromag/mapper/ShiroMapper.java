package com.telecom.project.shiromag.mapper;

import java.util.Set;

import com.telecom.project.beans.AdminBean;

public interface ShiroMapper {

	/**
	 * 根据管理员姓名查询管理员对象
	 * @param adminName
	 * @return
	 */
	public AdminBean findAdminByName(String adminName) ;
	
	/**
	 * 根据管理员姓名查询对应的角色
	 * @param adminName
	 * @return
	 */
	public Set<String> findRoleName(String adminName);
	
	/**
	 * 根据管理员姓名查询对应的权限
	 * @param adminName
	 * @return
	 */
	public Set<String> findPermission(String adminName);
		
}
