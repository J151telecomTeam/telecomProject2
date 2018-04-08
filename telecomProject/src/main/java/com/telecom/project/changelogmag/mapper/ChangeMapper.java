package com.telecom.project.changelogmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.ChangeBean;
import com.telecom.project.beans.PageBean;

/**
 * 书写mybatis注解与sql语句
 * @author 
 *
 */
public interface ChangeMapper {
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public List<ChangeBean> findByParams2PageBean(@Param("params")Map params);
	/**
	 * 查询所有数据总条数
	 * @param page
	 * @return
	 */
	public long countByParams2PageBean(@Param("params")Map params);
}
