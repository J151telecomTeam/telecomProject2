package com.telecom.project.usermag.querydao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.UserBean;

/**
 * 查询用户持久层接口
 * @author 
 *
 */
public interface IQueryUserDao {
	
	/**
	 * 服务器查用户
	 * @param id
	 * @return
	 */
	public List<UserBean> findUserByService(long id);
	
	/**
	 * 账号查用户
	 * @param account
	 * @return
	 */
	public UserBean findUserByAccount(String account);
	/**
	 * 根据登陆的账务账号和密码查询用户对象
	 * @param account
	 * @param password
	 * @return
	 */
	public UserBean findByAccountAndPassword(String account,String password);
	
	/**
	 * 根据条件完成分页统计
	 * @param params
	 * @return
	 */
	public long countByParams2PageBean(Map params);
	/**
	 * 根据条件完成分页数据的具体查询
	 * @param page
	 * @param params
	 * @return
	 */
	public List<UserBean> findByParams2PageBean(PageBean page,Map params);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public UserBean findByid(long id);
	
	
	
	
}
