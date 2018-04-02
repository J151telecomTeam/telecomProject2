package com.telecom.project.adminmag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.telecom.project.adminmag.operationdao.OperationAdminRepository;
import com.telecom.project.adminmag.operationservice.IOperationAdminService;
import com.telecom.project.beans.AdminBean;

/**
 * 管理员增删改业务实现类
 * @author 
 *
 */
@Service
public class OperationAdminServiceImpl implements IOperationAdminService{
	
	@Resource
	private OperationAdminRepository operationAdminRepository;


	@Override
	public void saveAdminBeanBean(AdminBean admin) {
		// TODO Auto-generated method stub
		operationAdminRepository.save(admin);
	}

	@Override
	public void updateAdminBeanBean(AdminBean admin) {
		// TODO Auto-generated method stub
		operationAdminRepository.saveAndFlush(admin);
		
	}

	@Override
	public void deleteAdminBeanById(long id) {
		// TODO Auto-generated method stub
		operationAdminRepository.deleteAdmin(id);
		
	}

	@Override
	public void deleteBatchAdminBean(List<AdminBean> admins) {
		// TODO Auto-generated method stub
		 for (AdminBean adminBean : admins) {
			 operationAdminRepository.delete(admins);
		}
		
	}

	@Override
	public Page<AdminBean> findAdminBeanByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return operationAdminRepository.findAll(pageable);
	}

	@Override
	public void deleteAdminBeanByBean(AdminBean bean) {
		// TODO Auto-generated method stub
		operationAdminRepository.delete(bean);
		
	}

	

}
