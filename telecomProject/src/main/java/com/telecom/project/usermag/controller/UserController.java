package com.telecom.project.usermag.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.InfoVo;
import com.telecom.project.beans.LargeBean;
import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.businessaccountmag.queryservice.IQueryBusinessAccountService;
import com.telecom.project.usermag.operationservice.IOperationUserService;
import com.telecom.project.usermag.queryservice.IQueryUserService;
import com.telecom.project.utils.ImportExcelUtil;

/**
 * 用于处理请求响应的bean
 * @author 
 *
 */
@RequestMapping("/user")
@RestController
public class UserController {
	
	@Resource
	private IQueryUserService queryUserServiceImpl;
	
	@Resource
	private IOperationUserService operationUserServiceImpl;
	
	@Resource
	private IQueryBusinessAccountService queryBusinessAccountServiceImpl;

	private Logger log = Logger.getLogger(this.getClass());
	
	/*@RequestMapping(value = "/findbyid{id}", method = { RequestMethod.GET}, produces = { "application/json;charset=utf-8" })
	public LargeBean findByLargeBean(UserBean user) {
		*/
		/*String account=user.getAccount();
		Long id=user.getId();
		LargeBean large =new LargeBean();
		BusinessAccountBean bean=queryBusinessAccountServiceImpl.finbyIdLargeBean(id);				
		BillMonthBean bean1=queryBusinessAccountServiceImpl.findyByBillMonthBean(account);
		large.setMaintain(bean.getServer().getMaintain());
		large.setServerName(bean.getServer().getName());
		large.setType(bean.getDeal().getType());
		large.setState(bean1.getState());	
		return large;*/
	/*	
	}*/
	
	@RequestMapping(value = "/stopuser{id}", method = { RequestMethod.PUT}, produces = { "application/json;charset=utf-8" })
	public Messager updateUserBeanByStatus(UserBean user) {	
		Messager msg = new Messager(true, "操作成功！");
		try {
			Long id=user.getId();
			operationUserServiceImpl.updateUserBeanByStatus(id);
		} catch (Exception e) {
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
		
	}

	@RequestMapping(value = "/liveuser{id}", method = { RequestMethod.PUT}, produces = { "application/json;charset=utf-8" })
	public Messager updateUserBeanByJhStatus(UserBean user) {	
		Messager msg = new Messager(true, "操作成功！");
		try {
			Long id=user.getId();
			operationUserServiceImpl.updateUserBeanByJiStatus(id);
		} catch (Exception e) {
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
		
	}
	
	
	@RequestMapping(value ="/select", method = { RequestMethod.GET }, produces = {"application/json;charset=utf-8"})
	public Map<String, Object> findAllByUserBean(PageBean page, Map params ) {
		
		Map<String, Object> map = new HashMap<>();
		PageBean pageable =new PageBean();
		
		PageBean pages = queryUserServiceImpl.findByParams2PageBean(pageable, params);
		map.put("total", pages.getTotalRows());
		map.put("rows", pages.getDatas());
		System.out.println(map);
		return map;
	}	

	/**
	 * 账号查用户
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/account", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
    public	UserBean findUserByAccount(String account) {
	
		
	 UserBean user=queryUserServiceImpl.findUserByAccount(account);
		
	 return user;
		
		
	}
	/**
	 * 根据用户id查找用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public UserBean findByUserBeanid(long id) {
		
		 UserBean user=queryUserServiceImpl.findByid(id);
		 
		 return user;			
	}
	/**
	 * 服务器查用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Service{id}", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<UserBean> FindByidServiceById(Long id){
		log.info(id);
		try {
			List<UserBean> list=queryUserServiceImpl.findUserByService(id);			
			return list;
		} catch (Exception e) {
			log.error("UserController---findByidServiceById()", e);
			return null;
		}
		
		
		
		
	}
	/**
	 * 根据登陆的账务账号和密码查询用户对象
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public boolean findByAccountAndPassword(String account,String password) {
		UserBean bean=queryUserServiceImpl.findByAccountAndPassword(account, password);
		if(bean==null) {
			return false;
		}else {
			return true;
		}				
	};
	
	/**
	 * 修改方法
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, produces = { "application/json;charset=utf-8" })
	public Messager updateUserBean(UserBean user) {
		log.info(user);
		Messager msg = new Messager(true, "操作成功");
		try {
			
			operationUserServiceImpl.updateUserBean(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController---updateUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
	}
	/**
	 * 添加方法
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public Messager saveUserBean(UserBean user) {
		log.info(user);
		System.out.println(user);
		Messager msg = new Messager(true, "操作成功！");			
		try {
			operationUserServiceImpl.saveUserBean(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
	}

	@RequestMapping(value ="/page", method = { RequestMethod.GET }, produces = {"application/json;charset=utf-8"})
	public Map<String, Object> findAll(PageBean page,UserBean user) {
		System.err.println(user);
		Map<String, Object> map = new HashMap<>();
		Map params = new HashMap<>();
		if (user.getIndentity().equals("")) {
			params.put("indentity", null);
		} else {
			params.put("indentity", user.getIndentity());
		}
		if (user.getAddress().equals("")) {
			params.put("address", null);
		} else {
			params.put("address", user.getAddress());
		}
		if (user.getName().equals("")) {
			params.put("name", null);
		} else {
			params.put("name", user.getName());
		}
		Long index = (page.getPage()-1) * page.getRows();
		page.setIndex(index);
		
		page = queryUserServiceImpl.findByParams2PageBean(page, params);
		map.put("total", page.getTotalRows());
		map.put("rows", page.getDatas());
		return map;
	}	
	@RequestMapping(value = "/delete{id}", method = { RequestMethod.PUT}, produces = { "application/json;charset=utf-8" })
	public Messager DeleteUserBean(UserBean user) {
		log.info(user);
		Messager msg = new Messager(true, "操作成功！");
		try {
			Long id=user.getId();
			operationUserServiceImpl.deleteUserBeanById(id);;
		} catch (Exception e) {
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
