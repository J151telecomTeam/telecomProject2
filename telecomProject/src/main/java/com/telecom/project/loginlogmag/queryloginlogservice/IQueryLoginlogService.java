package com.telecom.project.loginlogmag.queryloginlogservice;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.beans.PageBean;

public interface IQueryLoginlogService {
	
	/**
	 * 条件查询日志
	 * @param map
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
}
