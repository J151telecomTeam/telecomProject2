package com.telecom.project.servermag.operationServerService;


import java.util.List;

import com.telecom.project.beans.ServerBean;

/**
 * 服务器增删改业务接口
 * @author 
 *
 */
public interface IOperationServerService {
	/**
	 * 新增服务器
	 * @param server
	 */
	public void saveServerBean(ServerBean server);
	
	/**
	 * 修改服务器
	 * @param server
	 */
	public void updateServerBean(ServerBean server);
	
	/**
	 * 根据id删除服务器
	 * @param id
	 */
	public void deleteServerBeanById(long id);
	
	/**
	 * 批量删除
	 * @param servers
	 */
	public void deleteBatchServerBean(List<ServerBean> servers);
	
}
