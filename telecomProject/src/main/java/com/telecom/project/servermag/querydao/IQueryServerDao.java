package com.telecom.project.servermag.querydao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.ServerUseMoneyBean;

/**
 * 服务器查询持久层接口
 * @author 
 *
 */
public interface IQueryServerDao {
	
	/**
	 * 用户查服务器
	 * @param id 
	 * @return
	 */
	public List<ServerBean> findServerByUser(long id);
	
	/**
	 * 查询所有服务器分页
	 * @param page
	 * @return
	 */
	public List<ServerBean> findAllServerPage(PageBean page);
	
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
	public List<ServerBean> findByParams2PageBean(PageBean page,Map params);

	/**
	 * id查
	 * @param id
	 * @return
	 */
	public ServerBean findServerId(long id);

	/**
	 * 查总数据条数
	 * @param page
	 * @param params
	 * @return
	 */
	public long findServerByPage(Map map);
	
	/**
	 * 查总用户服务器数据条数
	 * @param acc
	 * @return
	 */
	public long findServerByUserAcc(String acc);

	/**
	 * 资费查服务器
	 * @param id
	 * @return
	 */
	public List<ServerBean> findServerByDeal(long id);
	
	/**
	 * 查询所有用户服务器
	 * @param params
	 * @return
	 */
	public List<ServerBean> findAllUserServer(Map params);
	
}
