package com.telecom.project.adminmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.adminmag.operationservice.IOperationAdminService;
import com.telecom.project.adminmag.queryServerService.IQueryAdminService;
import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.Combobox;
import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.RoleBean;
import com.telecom.project.rolemag.queryroleservice.IQueryRoleService;

@RequestMapping("/admins")
@RestController
public class adminController {

	// 查询
	@Resource
	private IQueryAdminService queryAdminService;

	// 增删改
	@Resource
	private IOperationAdminService operationAdminService;
	
	@Resource
	private IQueryRoleService queryRoleService;
	
	

	private Logger log = Logger.getLogger(this.getClass());

	// 分页查询
	@RequestMapping(value = "/page", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map findByParams2PageBean(PageBean page, Map map,String adminName, String roleName) {
		Map map1 = new HashMap();
		RoleBean role = new RoleBean();
		try {
			if ("".equals(adminName)) {
				map.put("name", null);
			}else {
				map.put("name", adminName);
				
			}
			if ("".equals(roleName)) {
				map.put("roleName", null);
			}else {
				map.put("roleName", roleName);
			}
			page = queryAdminService.findByParams2PageBean(page, map);
			System.out.println(page);
			map1.put("total", page.getTotalRows());
			map1.put("rows", page.getDatas());
			//map.put("rolename", role.getName());
		} catch (Exception e) {
			// TODO: handle exception
			// log.error("UserController-----findUserBeanByObject2PageBean()", e);
		}
		return map1;
	}
	
	
	//角色封装
	@RequestMapping(value = "/role", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<Combobox> findRoleBean(){
		List<RoleBean> list = queryRoleService.findAllRole();
		List<Combobox> datas = new ArrayList<Combobox>();
		for (RoleBean roleBean : list) {
			Combobox box = new Combobox(roleBean.getId()+"", roleBean.getName());
			datas.add(box);
		}
		return datas;
	}

	// 新增
	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public Messager addUserBean(@RequestBody Map map) {
		log.info(map);
		AdminBean admin = new AdminBean();
		admin.setName(map.get("name")+"");
		admin.setAccount(map.get("account")+"");
		admin.setPassword(map.get("password")+"");
		admin.setMail(map.get("mail")+"");
		admin.setTel(map.get("tel")+"");
		String xrole = map.get("role")+"";
		admin.setRole(queryRoleService.findRoleById(Long.parseLong(xrole)));
		Messager msg = new Messager(true, "操作成功");
		try {
			operationAdminService.saveAdminBeanBean(admin);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			log.error("AdminController-----saveExpenseBean()", e);
			msg.setStatus(false);
			msg.setInformation("操作失败");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE }, produces = { "application/json;charset=utf-8" })
	public Messager deleteAdminBean(AdminBean bean) {
		log.info(bean);
		Messager msg = new Messager(true, "操作成功！");
		operationAdminService.deleteAdminBeanById(bean.getId());
		return msg;
	}

	// 批量删除
	@RequestMapping(value = "/batch", method = { RequestMethod.DELETE }, produces = {
			"application/json;charset=utf-8" })
	public Messager deleteBatchUserBean(@RequestBody List<AdminBean> bean) {
		log.info(bean);
		Messager msg = new Messager(true, "操作成功！");
		try {
			operationAdminService.deleteBatchAdminBean(bean);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
	}

	// 修改
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, produces = { "application/json;charset=utf-8" })
	public Messager updateAdminBean(@RequestParam Map map) {
		log.info(map);
		AdminBean administratorBean = new AdminBean();
		String a = map.get("id")+"";
		administratorBean.setId(Long.parseLong(a));
		administratorBean.setName(map.get("adminName")+"");
		administratorBean.setAccount(map.get("adminAccount")+"");
		administratorBean.setPassword(map.get("password")+"");
		administratorBean.setMail(map.get("mail")+"");
		administratorBean.setTel(map.get("tel")+"");
		String c = map.get("role")+"";
		administratorBean.setRole(queryRoleService.findRoleById(Long.parseLong(c)));
		
		Messager msg = new Messager(true, "操作成功");
		try {
			operationAdminService.updateAdminBeanBean(administratorBean);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("AdminController-----saveExpense()", e);
			msg.setStatus(false);
			msg.setInformation("操作失败");
		}
		return msg;
	}
}