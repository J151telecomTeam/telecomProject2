package com.telecom.project.adminmag.operationservice;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.ServerBean;

/**
 * 管理员增删改业务接口
 * @author 
 *
 */
@Service
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
	
	/**
	 * 分页查询管理员
	 * @param pageable
	 * @return
	 */
	public Page<AdminBean> findAdminBeanByPage(Pageable pageable);
	
	
	public void deleteAdminBeanByBean(AdminBean bean);
	
}
