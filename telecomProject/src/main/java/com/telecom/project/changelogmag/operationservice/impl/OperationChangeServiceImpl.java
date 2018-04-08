package com.telecom.project.changelogmag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.ChangeBean;
import com.telecom.project.changelogmag.operationdao.IOperationChangeDao;
import com.telecom.project.changelogmag.operationservice.IOperationService;

/**
 * 操作日志增删改业务实现类
 * @author 
 *
 */
@Service
public class OperationChangeServiceImpl implements IOperationService{

	@Resource
	private IOperationChangeDao operationChangeDao;
	
	@Override
	public void saveChangeBeanBean(ChangeBean change) {
		// TODO Auto-generated method stub
		operationChangeDao.save(change);
	}

	

	

}
