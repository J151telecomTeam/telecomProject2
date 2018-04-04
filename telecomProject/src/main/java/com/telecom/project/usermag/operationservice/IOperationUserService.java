package com.telecom.project.usermag.operationservice;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.telecom.project.beans.UserBean;

/**
 * 用户增删改业务接口
 * @author 
 *
 */
public interface IOperationUserService {

	
	
	/**
	 * 修改用户
	 * @param user
	 */
	public void updateUserBean(UserBean user);
	/**
	 * 新增方法
	 * @param user
	 */
	public void saveUserBean(UserBean user);
	
	/**
	 * 删除方法
	 * @param id
	 */
	public void deleteUserBeanById(Long id);
	
	/**
	 * 停用方法
	 * @param id
	 */
	public void updateUserBeanByStatus(Long id);
	
	/**
	 * 激活方法
	 * @param id
	 */	
	public void updateUserBeanByJiStatus(Long id);
	
}
