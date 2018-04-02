package com.telecom.project.adminmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

public interface AdminMapper {
	/**
	 * 查询所有不分页
	 * @return
	 */
	public List<AdminBean> findAdminAll();
	
	

	public long countByParams2PageBean(@Param("params")Map params);
	
	/**
	 * 根据条件完成分页数据的具体查询
	 * @param page
	 * @param params
	 * @return
	 */
	public List<AdminBean> findByParams2PageBean(@Param("params")Map params);
	
	
	/**
	 * ID查询
	 * @param id
	 * @return
	 */
	public List<AdminBean> findAdminById(long id);
	
	/**
	 * 角色查管理员
	 * @param role
	 * @return
	 */
	public List<AdminBean> findAdminByRole(RoleBean role);

}
