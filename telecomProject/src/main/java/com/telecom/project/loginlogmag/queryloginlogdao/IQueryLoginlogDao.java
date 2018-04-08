package com.telecom.project.loginlogmag.queryloginlogdao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.LoginLogBean;
import com.telecom.project.beans.PageBean;

public interface IQueryLoginlogDao {
		
		/**
		 * 条件查询日志
		 * @return
		 */
		public List<LoginLogBean> findByParams2PageBean(PageBean page,Map params);
		/**
		 * 查询总条数
		 * @param params
		 * @return
		 */
		public long countByParams2PageBean(Map params);
}
