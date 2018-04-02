package com.telecom.project.rolemag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.RoleBean;

public interface RoleMapper {
	
	
	/**
	 * 查询所有不分页
	 * @return
	 */
	
	
	@Select(value = { "select r_id as id,r_name as roleName,r_create_time as date from t_role where r_id = #{id}" })
	public RoleBean findRoleBeanById(@Param("id") Long id);

	@Select(value= {"select r_id as id,r_name as roleName ,r_create_time as date from t_role where r_id = #{id}"})
	public List<RoleBean> findAllRole();

}
