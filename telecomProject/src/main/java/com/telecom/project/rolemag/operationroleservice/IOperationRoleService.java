package com.telecom.project.rolemag.operationroleservice;

import java.util.List;

import com.telecom.project.beans.RoleBean;

public interface IOperationRoleService {
	/**
	 * 保存权限
	 * @param role
	 */
	public void saveRole(RoleBean role);
	
	/**
	 * 删除权限
	 * @param role
	 */
	public void deleteRole(RoleBean role);
	
	/**
	 * 修改权限
	 * @param role
	 */
	public void updateRole(RoleBean role);
	
	/**
	 * 批量删除权限
	 * @param roles
	 */
	public void deleteBatchRole(List<RoleBean> roles);
}
