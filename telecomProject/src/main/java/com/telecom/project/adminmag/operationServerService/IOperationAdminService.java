package com.telecom.project.adminmag.operationServerService;


import java.util.List;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.ServerBean;

/**
 * 管理员增删改业务接口
 * @author 
 *
 */
public interface IOperationAdminService {
	/**
	 * 新增管理员
	 * @param server
	 */
	public void saveAdminBeanBean(AdminBean admin);
	
	/**
	 * 修改管理员
	 * @param server
	 */
	public void updateAdminBeanBean(AdminBean admin);
	
	/**
	 * 根据id删除管理员
	 * @param id
	 */
	public void deleteAdminBeanById(long id);
	
	/**
	 * 批量删除
	 * @param admins
	 */
	public void deleteBatchAdminBean(List<AdminBean> admins);
	
}
