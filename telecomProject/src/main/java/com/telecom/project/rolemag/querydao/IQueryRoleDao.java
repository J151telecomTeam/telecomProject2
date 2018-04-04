package com.telecom.project.rolemag.querydao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryRoleDao {
	/**
	 * 根据条件完成分页统计
	 * 
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(Map params);

	/**
	 * 根据条件完成分页数据的具体查询
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public List<RoleBean> findByParams2PageBean(PageBean page,Map params);

	/**
	 * 狗管理查角色
	 * @param user
	 * @return
	 */
	public List<RoleBean> findRoleByUser(AdminBean admin);
	
	
	
	public void updatePowerByRole(RoleBean role,PowerBean power);
	
	public List<PowerBean> findAllpower();
	/**
	 * ID查角色
	 * @param id
	 * @return
	 */
	public RoleBean findRoleById(long id);
	
	public List<RoleBean> findAllRole();
}
