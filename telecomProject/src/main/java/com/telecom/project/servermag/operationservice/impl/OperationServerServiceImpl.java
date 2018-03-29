package com.telecom.project.servermag.operationservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.ServerBean;
import com.telecom.project.servermag.operationdao.IOperationServerDao;
import com.telecom.project.servermag.operationservice.IOperationServerService;

/**
 * 服务器增删改业务实现类
 * @author 
 *
 */

@Service
public class OperationServerServiceImpl implements IOperationServerService{
	
	@Resource
	private IOperationServerDao operationServerDao;
	
	@Override
	public void saveServerBean(ServerBean server) {
		// TODO Auto-generated method stub
		operationServerDao.save(server);
	}

	@Override
	public void updateServerBean(ServerBean server) {
		// TODO Auto-generated method stub
		operationServerDao.saveAndFlush(server);
	}

	@Override
	public void deleteServerBeanById(long id) {
		// TODO Auto-generated method stub
		operationServerDao.deleteServerBeanById(id);
	}

	@Override
	public void deleteBatchServerBean(List<ServerBean> servers) {
		// TODO Auto-generated method stub
		List<Long> list = new ArrayList<Long>();
		for (ServerBean server : servers) {
			list.add(server.getId());
		}
		System.out.println(list);
		operationServerDao.deleteBatchServerBean(list);
	}

}
