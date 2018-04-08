package com.telecom.project.businessaccountmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.BusinessAccountBean;
import com.telecom.project.beans.Combobox;
import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.Messager;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.businessaccountmag.operationservice.IOperationBusinessAccountService;
import com.telecom.project.businessaccountmag.queryservice.IQueryBusinessAccountService;

@RequestMapping("/business")
@RestController
public class BusinessController {

	@Resource
	private IQueryBusinessAccountService queryBusinessAccountServiceImpl;
	@Resource
	private IOperationBusinessAccountService operationBusinessAccountServiceImpl;

	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/statuss", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<Combobox> getAllStatus() {

		List<Combobox> datas = new ArrayList<Combobox>();

		Combobox com01 = new Combobox("1", "已激活");
		Combobox com02 = new Combobox("-1", "已暂停");

		datas.add(com02);

		datas.add(com01);

		return datas;
	}		
		

	/**
	 * 修改方法
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update{id}", method = { RequestMethod.PUT }, produces = {
			"application/json;charset=utf-8" })
	public Messager updateBusinessAccountBean(@RequestParam Map map) {
		log.info(map);
		Messager msg = new Messager(true, "操作成功");
		try {
			UserBean u = new UserBean();
			DealBean d = new DealBean();
			ServerBean s = new ServerBean();
			BusinessAccountBean bean = new BusinessAccountBean();
			String osAccount = map.get("osAccount").toString();
			String account = map.get("account").toString();
			Long type = Long.parseLong(map.get("type").toString());
			Long servicid = Long.parseLong(map.get("servicName").toString());
			Long id = Long.parseLong(map.get("id").toString());
			u.setAccount(account);
			d=queryBusinessAccountServiceImpl.findDealByName(type);
			s=queryBusinessAccountServiceImpl.findServiceByName(servicid);
			bean.setOsAccount(osAccount);
			bean.setId(id);
			bean.setDeal(d);
			bean.setUser(u);
			bean.setServer(s);
			operationBusinessAccountServiceImpl.saveBusinessAccountBean(bean);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController---updateUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
			System.err.println(e);
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/server", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<?> FindyByServerName() {
		List<ServerBean> list = queryBusinessAccountServiceImpl.findyByServicName();
		List data =new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map map=new HashMap<>();
			map.put("id", list.get(i).getId());
			map.put("text", list.get(i).getName());		
			data.add(map);
		}
		
		return data;

	};
	@RequestMapping(value = "/deal", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<?>FindyByDealBeanName(){
		List<DealBean> list = queryBusinessAccountServiceImpl.finddealBean();
		List data =new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        	Map map=new HashMap<>();
        	
			
			if(list.get(i).getType()==1) {
				map.put("id", list.get(i).getId());
				map.put("text", "包月");
			}else if(list.get(i).getType()==2) {
				map.put("id", list.get(i).getId());
				map.put("text", "套餐");
			}else if(list.get(i).getType()==3) {
				map.put("id", list.get(i).getId());
				map.put("text", "计时");
			}
			data.add(map);
		}return data;		
	};
	
	
	/*public List<?> FindyByDealBeanName() {
		List<DealBean> list = queryBusinessAccountServiceImpl.finddealBean();
		List data =new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map map=new HashMap<>();
			map.put("id", list.get(i).getId());
			map.put("text", list.get(i).getType());		
			data.add(map);
		}
		
		return data;

	};*/
	
	@RequestMapping(value = "/live{id}", method = { RequestMethod.PUT }, produces = {
			"application/json;charset=utf-8" })
	public Messager updateBusinessByJiStatus(BusinessAccountBean user) {
		Messager msg = new Messager(true, "操作成功！");
		try {
			Long id = user.getId();
			operationBusinessAccountServiceImpl.updateUserBeanByJiStatus(id);
		} catch (Exception e) {
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;

	}

	@RequestMapping(value = "/stop{id}", method = { RequestMethod.PUT}, produces = {
			"application/json;charset=utf-8" })
	public Messager updateBusinessByStatus(BusinessAccountBean user) {
		Messager msg = new Messager(true, "操作成功！");
		try {
			Long id = user.getId();
			operationBusinessAccountServiceImpl.updateBusinessByStatus(id);
		} catch (Exception e) {
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;

	}

	@RequestMapping(value = "/page", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map<String, Object> findAll(PageBean page,HttpServletRequest request) {
		System.out.println(page);
		
		Long index = (page.getPage()-1) * page.getRows();
		Map<String, Object> map = new HashMap<>();
		Map params = new HashMap<>();
		String account =request.getParameter("account");
		params.put("account", account);
		
		page.setIndex(index);
		
		PageBean pages=queryBusinessAccountServiceImpl.findByParams2PageBean(page, params);
		map.put("total", pages.getTotalRows());
		map.put("rows", pages.getDatas());
		System.out.println(map);
		return map;
	}

	/**
	 * 添加方法
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public Messager saveBuissessBean(@RequestParam Map user) {
		log.info(user);

		Messager msg = new Messager(true, "操作成功！");
		try {
			String account = user.get("account").toString();
			String osAccount = user.get("osAccount").toString();
			Long idd = Long.parseLong(user.get("servicName").toString());
			System.err.println(idd);
			Long type = Long.parseLong(user.get("type").toString());
			DealBean d = new DealBean();

			d=queryBusinessAccountServiceImpl.findDealByName(type);
			
			String indentity = user.get("indentity").toString();
			UserBean u = new UserBean();
			u.setAccount(account);
			u.setIndentity(indentity);
						/*d.setType(type);
*/			ServerBean s = new ServerBean();
			s=queryBusinessAccountServiceImpl.findServiceByName(idd);
			BusinessAccountBean bean = new BusinessAccountBean();
			bean.setUser(u);
			bean.setDeal(d);
			bean.setServer(s);
			bean.setOsAccount(osAccount);
			operationBusinessAccountServiceImpl.saveBusinessAccountBean(bean);
			System.out.println(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController---saveUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
			System.err.println(e);
		}
		return msg;
	}
	@RequestMapping(value = "/delete{id}", method = { RequestMethod.PUT }, produces = { "application/json;charset=utf-8" })
	public Messager deleteBusinessAccountBean(BusinessAccountBean bean) {
		log.info(bean);
		Messager msg = new Messager(true, "操作成功！");

		try {
			Long id=bean.getId();
			operationBusinessAccountServiceImpl.deleteBiuessBean(id);;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("UserController-----deleteUserBean()", e);
			msg.setStatus(false);
			msg.setInformation("当前在线人数过多，系统繁忙，请稍后重试！");
		}
		return msg;
	}
}
