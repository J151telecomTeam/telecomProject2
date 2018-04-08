package com.telecom.project.rolemag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface RoleMapper {
	/**
	 * 根据条件完成分页统计
	 * 
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(@Param("map1")Map params);

	/**
	 * 根据条件完成分页数据的具体查询
	 * 
	 * @param page
	 * @param params
	 * @return
	 */
	public List<RoleBean> findByParams2PageBean(@Param("map1")Map params);

	
	/**
	 * 狗管理查角色
	 * @param user
	 * @return
	 */
	public List<RoleBean> findRoleByUser(@Param("admin")AdminBean admin);
	
	/**
	 * ID查角色
	 * @param id
	 * @return
	 */
	public RoleBean findRoleById(@Param("id")long id);
	
	public List<RoleBean> findRoleByName(@Param("name")String name);
	
	public void saveMiddle(@Param("role") RoleBean role);
	
	/**
	 * 修改i中间表
	 */
	public void updatePowerByRole(@Param("role")RoleBean role,@Param("power")PowerBean bean);
	
	/**
	 * 查TM所有
	 */
	public List<PowerBean> findAllpower();
	
	@Select(value = { "select r_id as id,r_name as roleName,r_create_time as date from t_role where r_id = #{id}" })
	public RoleBean findRoleBeanById(@Param("id") Long id);

	@Select(value= {"select r_id as id,r_name as roleName ,r_create_time as date from t_role where r_id = #{id}"})
	public List<RoleBean> findAllRole();
}
