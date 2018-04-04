package com.telecom.project.usermag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.UserBean;

import com.telecom.project.usermag.operationdao.UserBeanRepository;
import com.telecom.project.usermag.operationservice.IOperationUserService;

/**
 * 用户增删改业务实现类
 * @author
 *
 */
@Service
public class OperationUserServiceImpl implements IOperationUserService{

	@Resource
	private UserBeanRepository userBeanRepository;
	
	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userBeanRepository.saveAndFlush(user);
	}

	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userBeanRepository.save(user);
	}

	@Override
	public void deleteUserBeanById(Long id) {
		userBeanRepository.deleteUserBeanById(id);
		
	}

	@Override
	public void updateUserBeanByStatus(Long id) {
		// TODO Auto-generated method stub
		userBeanRepository.updateUserBeanByStatus(id);
	}

	@Override
	public void updateUserBeanByJiStatus(Long id) {
		// TODO Auto-generated method stub
		userBeanRepository.updateUserBeanByJiStatus(id);
	}

	

	
	
	

	
	
	
}
