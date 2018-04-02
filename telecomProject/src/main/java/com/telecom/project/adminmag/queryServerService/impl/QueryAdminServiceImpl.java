package com.telecom.project.adminmag.queryServerService.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.adminmag.queryServerDao.IQueryAdminDao;
import com.telecom.project.adminmag.queryServerService.IQueryAdminService;
import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;

/**
 * 管理员查询接口实现类
 * @author 
 *
 */
@Service
public class QueryAdminServiceImpl implements IQueryAdminService{
	
	
	@Resource
	private IQueryAdminDao operationAdminDaoImpl;
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	@Override
	public PageBean findByParams2PageBean(PageBean page, Map params) {
		// TODO Auto-generated method stub
		long totalRows = operationAdminDaoImpl.countByParams2PageBean(params);
		List<AdminBean> datas = operationAdminDaoImpl.findByParams2PageBean( page, params);
		page.setTotalRows(totalRows);
		page.setDatas(datas);
		return page;
	}


	@Override
	public List<AdminBean> findAdminById(long id) {
		// TODO Auto-generated method stub
		return operationAdminDaoImpl.findAdminById(id);
	}

	@Override
	public List<AdminBean> findAdminByRole(RoleBean role) {
		// TODO Auto-generated method stub
		return operationAdminDaoImpl.findAdminByRole(role);
	}

	@Override
	public List<AdminBean> findAdminAll() {
		// TODO Auto-generated method stub
		return operationAdminDaoImpl.findAdminAll();
	}

}
