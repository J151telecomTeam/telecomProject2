package com.telecom.project.servermag.queryservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.ServerUseMoneyBean;

/**
 * 服务器查询业务接口
 * @author 
 *
 */
public interface IQueryServerService {
	
	/**
	 * 用户查服务器
	 * @return
	 */
	public List<ServerBean> findServerByUser(long id);
	
	/**
	 * 用户查服务器分页
	 * @return
	 */
	public PageBean findServerByUserAcc(PageBean page,String name,String acc);
	
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
	
	/**
	 * 根据id查询服务器使用费用明细
	 * @param id
	 * @return
	 */
	public ServerBean findByServerId(long id);
	
	/**
	 * 资费查服务器
	 * @param id
	 * @return
	 */
	public List<ServerBean> findServerByDeal(long id);
}
