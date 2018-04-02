package com.telecom.project.rolemag.operationroleservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.operationroleservice.IOperationRoleService;
import com.telecom.project.rolemag.operationroleservice.dao.OperationRoleRepository;
@Service
public class OperationRoleServiceImpl implements IOperationRoleService {

	@Resource
	private  OperationRoleRepository operationRoleRepository;
	
	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		operationRoleRepository.save(role);
		
	}

	@Override
	public void deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		operationRoleRepository.delete(role);
	}

	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		operationRoleRepository.saveAndFlush(role);
	}

	@Override
	public void deleteBatchRole(List<RoleBean> roles) {
		// TODO Auto-generated method stub
		for (RoleBean roleBean : roles) {
			operationRoleRepository.delete(roles);
		}
		
	}

	@Override
	public Page<RoleBean> findRoleBeanByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return operationRoleRepository.findAll(pageable);
	}

}
