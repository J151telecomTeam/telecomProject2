package com.telecom.project.rolemag.queryservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryRoleService {
	
	/**
	 * 根据条件查询权限或者查询所有权限，有分页功能
	 * @param page    pageBean
	 * @param params  条件
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map map);
		
	
	/**
	 * 管理员查角色
	 * @param admin
	 * @return
	 */
	public List<RoleBean> findRoleByUser(AdminBean admin);
	
	
	
	public void updatePowerByRole(RoleBean role, PowerBean power);
	
	public List<PowerBean> findAllpower();
	
	public RoleBean findRoleById(long id);
	/**
	 * 查询所有角色不分页
	 * @return
	 */
	public List<RoleBean> findAllRole();
	
    public boolean findRoleByName(String name);
	
	public void saveMiddle(RoleBean role);
}
