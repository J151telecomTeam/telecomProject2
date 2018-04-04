package com.telecom.project.rolemag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.operationdao.IOperationRoleDao;
import com.telecom.project.rolemag.operationservice.IOperationRoleService;

@Service
public class OperationRoleServiceImpl implements IOperationRoleService {

	@Resource
	private IOperationRoleDao ioperationRoleDaoImpl;
	
	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		ioperationRoleDaoImpl.save(role);
	}

	@Override
	public void deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		ioperationRoleDaoImpl.delete(role);
	}

	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		ioperationRoleDaoImpl.saveAndFlush(role);
	}

	@Override
	public void deleteBatchRole(List<RoleBean> roles) {
		// TODO Auto-generated method stub
		ioperationRoleDaoImpl.deleteInBatch(roles);
	}

}
