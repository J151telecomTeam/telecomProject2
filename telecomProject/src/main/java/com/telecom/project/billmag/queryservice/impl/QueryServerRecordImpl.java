package com.telecom.project.billmag.queryservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.ServiceRecordBean;
import com.telecom.project.billmag.querydao.IQueryServerRecordDao;
import com.telecom.project.billmag.queryservice.IQueryServerRecord;


@Service
public class QueryServerRecordImpl implements IQueryServerRecord {
	
	
	@Resource
	private IQueryServerRecordDao queryServerRecordDaoImpl;
	
	
	
	@Override
	public List<ServiceRecordBean> findServiceRecordByCon(ServiceRecordBean bean) {
		return queryServerRecordDaoImpl.findServiceRecordByCon(bean);
	}

	@Override
	public ServiceRecordBean findServiceRecordByOS(String os) {
		return queryServerRecordDaoImpl.findServiceRecordByOS(os);
	}

	@Override
	public List<ServiceRecordBean> findServiceRecordAllByOs(String os) {
		return queryServerRecordDaoImpl.findServiceRecordAllByOs(os);
	}

}
