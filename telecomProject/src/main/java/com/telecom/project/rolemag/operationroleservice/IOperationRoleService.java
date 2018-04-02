package com.telecom.project.rolemag.operationroleservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.telecom.project.beans.RoleBean;

public interface IOperationRoleService {
	/**
	 * 新增角色
	 * @param role
	 */
	public void saveRole(RoleBean role);
	
	/**
	 * 删除角色
	 * @param role
	 */
	public void deleteRole(RoleBean role);
	
	/**
	 * 修改角色
	 * @param role
	 */
	public void updateRole(RoleBean role);
	
	/**
	 * 批量删除角色
	 * @param roles
	 */
	public void deleteBatchRole(List<RoleBean> roles);
	
	/**
	 * 分页查询角色
	 * @param pageable
	 * @return
	 */
	
	public Page<RoleBean> findRoleBeanByPage(Pageable pageable);
}
