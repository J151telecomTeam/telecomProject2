package com.telecom.project.adminmag.queryServerDao;

import java.util.Map;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;

/**
 * 服务器查询持久层接口
 * @author 
 *
 */
public interface IOperationAdminDao {
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 */
	public PageBean findAllAdminPage(PageBean page);
	
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
	public AdminBean findAdminById(long id);
}
