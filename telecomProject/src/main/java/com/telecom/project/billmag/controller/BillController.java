package com.telecom.project.billmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.beans.BusinessMonthBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerUseMoneyBean;
import com.telecom.project.billmag.operationservice.IOperationBillService;
import com.telecom.project.billmag.queryservice.IQueryBillService;
import com.telecom.project.pojos.GoMiBean;
import com.telecom.project.pojos.StateConvert;
import com.telecom.project.pojos.TypeConvert;

@RequestMapping("/bill")
@RestController
public class BillController {
	
	@Resource
	private IQueryBillService queryBillServiceImpl;
	
	@Resource
	private IOperationBillService operationBillServiceImpl;
	
	
	@RequestMapping(value="/deal",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public List<TypeConvert> typeConvertMethod(){
		
		List<TypeConvert> datas = new ArrayList<TypeConvert>();
		TypeConvert tc1 = new TypeConvert("1", "包月");
		TypeConvert tc2 = new TypeConvert("2", "时长");
		TypeConvert tc3 = new TypeConvert("3", "套餐");
		
		datas.add(tc1);
		datas.add(tc2);
		datas.add(tc3);
		
		return datas;
	}
	
	/**
	 * 账单管理页面，第二次双击表格时请求提交到该方法
	 * @return
	 */
	@RequestMapping(value="/server",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findServerUseMoney(String osAccount) {
		
		ServerUseMoneyBean sum = queryBillServiceImpl.findByServerUseMoney(osAccount);
		
		Map params = new HashMap<>();
//		params.put("osAccount", sum.getOsAccount());
//		params.put("loginTime", sum.getLoginTime());
//		params.put("exitTime", sum.getExitTime());
//		params.put("runTime", sum.getRunTime());
//		params.put("deal", sum.getDeal().getType());
//		params.put("price", sum.getPrice());

		PageBean page = new PageBean(1, 10);
//		List<ServerUseMoneyBean> sers = new ArrayList<ServerUseMoneyBean>();
//		sers.add(sum);
//		page.setDatas(sers);
		
		GoMiBean gm = new GoMiBean();
		gm.setDeal(sum.getDeal().getType());
		gm.setExitTime(sum.getExitTime());
		gm.setId(sum.getId());
		gm.setIp(sum.getIp());
		gm.setLoginTime(sum.getLoginTime());
		gm.setOsAccount(sum.getOsAccount());
		gm.setPrice(sum.getPrice());
		gm.setRunTime(sum.getRunTime());
		
		List<GoMiBean> gms = new ArrayList<GoMiBean>();
		gms.add(gm);
		
		page.setTotalRows(1);
		page.setDatas(gms);
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());

		
		return params;
	}
	
	/**
	 * 账单管理页面，第一次双击表格时请求到达该方法
	 * @param zwAccount
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/business",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findBusinessMonth(String zwAccount,PageBean page) {
		page = queryBillServiceImpl.findByServiceMonthPage(page, zwAccount);
		Map params = new HashMap<>();
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		return params;
	}
	
	/**
	 * 用户转换支付状态
	 * @return
	 */
	@RequestMapping(value="/state",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public List<StateConvert> stateConvertMethod(){
		
		List<StateConvert> datas = new ArrayList<>();
		StateConvert sc1 = new StateConvert("1", "已支付");
		StateConvert sc2 = new StateConvert("0", "未支付");
		sc2.setSelected(true);
		
		datas.add(sc1);
		datas.add(sc2);
		
		return datas;
	}
	
	/**
	 * 账单管理页面，点击确认支付后请求会提交到该方法
	 * @param bill
	 * @return
	 */
	@RequestMapping(value="/billUpdate",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public Map updatePay(BillMonthBean bill) {
		
		operationBillServiceImpl.updateBillBean(bill);
		Map params = new HashMap<>();
		params.put("information", "修改成功");
		return params;
	}
	
	/**
	 * 账单管理页面，点击搜索按钮后请求会提交到该方法
	 * @return
	 */
	@RequestMapping(value = "/billMonthPage", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map findBillMonthByParams(PageBean page,BillMonthBean bill) {
		Map params = new HashMap<>();
		params.put("zwAccount", bill.getZwAccount());
		params.put("idCard", bill.getIdCard());
		params.put("date", bill.getDate());
		page = queryBillServiceImpl.findByBillMonthPage(params, page);
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		return params;
	}

}
