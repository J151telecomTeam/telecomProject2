package com.telecom.project.servermag.queryServerDao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;

/**
 * 服务器查询持久层接口
 * @author 
 *
 */
public interface IOperationServerDao {
	
	/**
	 * 用户查服务器
	 * @return
	 */
	public List<ServerBean> findServerByUser();
	
	/**
	 * 查询所有服务器分页
	 * @param page
	 * @return
	 */
	public PageBean findAllServerPage(PageBean page);
	
	/**
	 * 查所有服务器
	 * @return
	 */
	public List<ServerBean> findAllServer();

	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
}
