package com.telecom.project.billmag.querydao;

import java.util.List;

import com.telecom.project.beans.ServiceRecordBean;

public interface IQueryServerRecordDao {
	
	/**
	 * 模糊查询和所有查询
	 * @return
	 */
	public List<ServiceRecordBean> findServiceRecordByCon(ServiceRecordBean bean);
	
	/**
	 * OS账号查询业务下面服务器信息
	 * @param os
	 * @return
	 */
	public ServiceRecordBean findServiceRecordByOS(String os);
	
	/**
	 * OS账号查询所有服务器信息
	 * @param os
	 * @return
	 */
	public List<ServiceRecordBean> findServiceRecordAllByOs(String os);
	
	
}
