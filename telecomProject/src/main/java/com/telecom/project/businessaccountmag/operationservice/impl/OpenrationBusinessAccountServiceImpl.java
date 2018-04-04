package com.telecom.project.businessaccountmag.operationservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.businessaccountmag.operationdao.BusinessAccountBeanRepository;
import com.telecom.project.businessaccountmag.operationservice.IOperationBusinessAccountService;

/**
 * 业务管理 业务层实现类
 * @author Administrator
 *
 */
@Service
public class OpenrationBusinessAccountServiceImpl implements IOperationBusinessAccountService{

	@Resource
	private BusinessAccountBeanRepository businessaccountBeanRepostitory;

	@Override
	public void saveBusinessAccountBean(BusinessAccountBean user) {
		// TODO Auto-generated method stub
		businessaccountBeanRepostitory.save(user);
	}

	@Override
	public void updateBusinessAccountBean(BusinessAccountBean user) {
		// TODO Auto-generated method stub
		businessaccountBeanRepostitory.saveAndFlush(user);
	}

	@Override
	public void updateUserBeanByJiStatus(Long id) {
		// TODO Auto-generated method stub
		businessaccountBeanRepostitory.updateUserBeanByJiStatus(id);
	}

	@Override
	public void updateBusinessByStatus(Long id) {
		// TODO Auto-generated method stub
		businessaccountBeanRepostitory.updateBusinessByStatus(id);
	}


	

	@Override
	public void deleteBiuessBean(Long id) {
		// TODO Auto-generated method stub
		businessaccountBeanRepostitory.deleteBiuessBean(id);
	}

	
	
	

}
