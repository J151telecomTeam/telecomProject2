package com.telecom.project.powermag.querydao;

import java.util.List;
import java.util.Map;



import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IQueryPowerDao {
	/**
	 * 根据条件完成分页统计
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(Map params);
	/**
	 * 根据条件完成分页数据的具体查询
	 * @param page
	 * @param params
	 * @return
	 */
	public List<PowerBean> findByParams2PageBean(PageBean page,Map map);

	
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
