package com.telecom.project.powermag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface PowerMapper {
	/**
	 * 根据条件完成分页统计
	 * 
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(@Param("map1")Map map);

	/**
	 * 根据条件完成分页数据的具体查询
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public List<PowerBean> findByParams2PageBean(@Param("map1")Map map);


	/**
	 * 角色查权限
	 * @param role
	 * @return
	 */
	public List<PowerBean> findPowerByRole(@Param("role")RoleBean role);
	
	/**
	 * 查权限用ID
	 * @param id
	 * @return
	 */
	public PowerBean findPowerById(@Param("id")long id);
}
