package com.telecom.project.businessaccountmag.operationservice;

import com.telecom.project.beans.BusinessAccountBean;

/**
 * 业务管理 业务层接口
 * @author Administrator
 *
 */
public interface IOperationBusinessAccountService {
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteBiuessBean(Long id);
	/**
	 * 激活方法
	 * @param id
	 */
	public void updateUserBeanByJiStatus(Long id);
	/**
	 * 停用方法
	 * @param id
	 */
	public void updateBusinessByStatus(Long id);

	
	/**
	 * 修改用户
	 * @param user
	 */
	public void saveBusinessAccountBean(BusinessAccountBean user);
	/**
	 * 新增方法
	 * @param user
	 */
	public void updateBusinessAccountBean(BusinessAccountBean user);
	
}
