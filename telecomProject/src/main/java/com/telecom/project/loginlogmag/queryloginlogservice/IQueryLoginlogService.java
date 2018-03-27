package com.telecom.project.loginlogmag.queryloginlogservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.beans.PageBean;

public interface IQueryLoginlogService {
	/**
	 * 查询所有管理日志
	 * @return
	 */
	public PageBean findAllLoginLogPage(PageBean page);
	/**
	 * 条件查询日志
	 * @param map
	 * @return
	 */
	public PageBean findByConLoginLogPage(Map map,PageBean page);
	
}
