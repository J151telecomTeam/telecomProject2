package com.telecom.project.loginlogmag.mapper;

import java.util.Date;
import java.util.List;

import com.telecom.project.beans.LoginLogBean;

public interface LoginlogMapper {
	
	/**
	 * 查询所有管理日志
	 * @return
	 */
	public List<LoginLogBean> findAllLoginLog();
	/**
	 * 条件查询日志
	 * @param name
	 * @param onDate
	 * @param endDate
	 * @return
	 */
	public List<LoginLogBean> findByConLoginLog(String name,Date onDate,Date endDate);
}
