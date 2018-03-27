package com.telecom.project.rolemag.queryroleservice;

import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryRoleService {
	
	/**
	 * 查所有角色
	 * @param page
	 * @return
	 */
	public PageBean findAllRolePage(PageBean page);
	
	/**
	 * 条件查角色
	 * @param map
	 * @return
	 */
	public PageBean findRoleByConPage(Map map,PageBean page);
	
	/**
	 * 管理员查角色
	 * @param admin
	 * @return
	 */
	public RoleBean findRoleByUser(AdminBean admin);
	
	/**
	 * ID查角色
	 * @param id
	 * @return
	 */
	public RoleBean findRoleById(long id);
}
