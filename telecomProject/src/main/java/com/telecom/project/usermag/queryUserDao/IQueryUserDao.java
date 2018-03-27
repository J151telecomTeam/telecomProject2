package com.telecom.project.usermag.queryUserDao;

import java.util.Map;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;

/**
 * 查询用户持久层接口
 * @author 
 *
 */
public interface IQueryUserDao {
	
	/**
	 * 根据登陆的账务账号和密码查询用户对象
	 * @param account
	 * @param password
	 * @return
	 */
	public UserBean findByAccountAndPassword(String account,String password);
	
	/**
	 * 多参数，完成分页查询
	 * @param page 分页对象
	 * @param params 参数对象
	 * @return
	 */
	public PageBean findByParams2PageBean(PageBean page,Map params);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public UserBean findByid(long id);
	
}
