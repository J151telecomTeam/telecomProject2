package com.telecom.project.billmag.querydao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.telecom.project.beans.ServiceRecordBean;
import com.telecom.project.billmag.mapper.ServerRecordMapper;
import com.telecom.project.billmag.querydao.IQueryServerRecordDao;

@Repository
public class QueryServerRecordDaoImpl implements IQueryServerRecordDao {
	
	@Resource
	private ServerRecordMapper sRM;
	
	
	@Override
	public List<ServiceRecordBean> findServiceRecordByCon(ServiceRecordBean bean) {
		// TODO Auto-generated method stub
		return sRM.findServiceRecordByCon(bean);
	}

	@Override
	public ServiceRecordBean findServiceRecordByOS(String os) {
		// TODO Auto-generated method stub
		return sRM.findServiceRecordByOS(os);
	}

	@Override
	public List<ServiceRecordBean> findServiceRecordAllByOs(String os) {
		// TODO Auto-generated method stub
		return sRM.findServiceRecordAllByOs(os);
	}

}
