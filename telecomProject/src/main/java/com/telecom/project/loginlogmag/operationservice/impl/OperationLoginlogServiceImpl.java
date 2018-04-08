package com.telecom.project.loginlogmag.operationservice.impl;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.loginlogmag.operationdao.IOperationloginlogdao;
import com.telecom.project.loginlogmag.operationservice.IOperationLoginlogService;

@Service
public class OperationLoginlogServiceImpl implements IOperationLoginlogService {

	private IOperationloginlogdao operationloginlogdao;
	
	@Override
	public void saveLoginLog(LoginLogBean loginLog) {
		// TODO Auto-generated method stub
		operationloginlogdao.save(loginLog);
	}

}
