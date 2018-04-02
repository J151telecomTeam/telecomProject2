package com.telecom.project.adminmag.queryServerService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

/**
 * 管理员查询业务接口
 * @author 
 *
 */

public interface IQueryAdminService {
	

	
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
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
	
	/**
	 * 查询所有不分页
	 * @return
	 */
	public List<AdminBean> findAdminAll();
	
}
