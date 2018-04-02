package com.telecom.project.rolemag.queryroledao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryRoleDao {
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
	 * 根据管理名字查角色
	 * @param user
	 * @return
	 */
	public List<RoleBean> findRoleByAdmin(String roleName);
	
	/**
	 * ID查角色
	 * @param id
	 * @return
	 */
	public RoleBean findRoleById(long id);
	
	public List<RoleBean> findAllRole();
}
