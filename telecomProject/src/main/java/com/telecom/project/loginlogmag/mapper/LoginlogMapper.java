package com.telecom.project.loginlogmag.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.beans.PageBean;

public interface LoginlogMapper {
	/**
	 * 查询所有数据总条数
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(@Param("params")Map params);
	/**
	 * 条件查询日志
	 * @param name
	 * @param onDate
	 * @param endDate
	 * @return
	 */
	public List<LoginLogBean> findByParams2PageBean(@Param("params")Map params);
}
