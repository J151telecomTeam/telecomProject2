package com.telecom.project.adminmag.queryServerDao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

/**
 * 服务器查询持久层接口
 * @author 
 *
 */
public interface IQueryAdminDao {
	

	
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public List<AdminBean> findByParams2PageBean(PageBean page,Map params);
	
	/**
	 * ID查询
	 * @param id
	 * @return
	 */
	public List<AdminBean> findAdminById(long id);
	
	/**
	 * 查询所有不分页
	 * @return
	 */
	public List<AdminBean> findAdminAll();
	
	/**
	 * 根据条件完成分页统计
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(Map params);
	
	/**
	 * 角色查管理员
	 * @param role
	 * @return
	 */
	public List<AdminBean> findAdminByRole(RoleBean role);
}
