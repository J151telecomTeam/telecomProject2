package com.telecom.project.changelogmag.querydao;

import java.util.List;
import java.util.Map;

import com.telecom.project.beans.ChangeBean;
import com.telecom.project.beans.PageBean;

/**
 * 操作日志查询持久层接口
 * @author 
 *
 */
public interface IQueryChangeDao {

	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public List<ChangeBean> findByParams2PageBean(PageBean page,Map params);
	/**
	 * 查询所有数据总条数
	 * @param page
	 * @return
	 */
	public long countByParams2PageBean(Map params);
	
}
