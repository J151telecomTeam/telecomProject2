package com.telecom.project.accountingmag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.accountingmag.queryServerService.IQueryAccountingService;
import com.telecom.project.beans.AccountingDayBean;
import com.telecom.project.beans.AccountingMonthBean;
import com.telecom.project.beans.AccountingYearBean;
import com.telecom.project.beans.PageBean;

@RequestMapping(value="/accounting")
@RestController
public class AccountingController {
	
	@Resource
	private IQueryAccountingService queryAccountingServiceImpl;
	
	/**
	 * 第二次双击时请求到达该方法
	 * @return
	 */
	@RequestMapping(value="/day",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findDay(AccountingDayBean day,PageBean page) {
		
		Map params = new HashMap<>();
		params.put("year", day.getYear());
		params.put("month", day.getMonth());
		params.put("zwAccount", day.getZwAccount());
		
		page = queryAccountingServiceImpl.findByYearAndMonthAndZwAccount(page, params);
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		
		return params;
	}
	
	/**
	 * 第一次双击时请求进入该方法
	 * @return
	 */
	@RequestMapping(value="/month",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findMonth(AccountingMonthBean month,PageBean page) {
		
		Map params = new HashMap<>();
		params.put("year", month.getYear().substring(0, 4));
		params.put("zwAccount", month.getZwAccount());
		
		page = queryAccountingServiceImpl.findByYearAndZwAccountForMonth(page, params);
		
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		
		return params;
	}
	
	/**
	 * 进入账务管理页面默认调用和点击搜索按钮时请求进入该方法
	 * @param month
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/yearOrMonth",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findYear(AccountingMonthBean month,PageBean page) {
		
		Map params = new HashMap<>();
		if(month.getMonth() == null || "全部".equals(month.getMonth())) {
			params.put("month", month.getMonth());
		}else {
			params.put("month", month.getMonth().substring(0, 1));
		}
		
		params.put("year", month.getYear());
		params.put("zwAccount", month.getZwAccount());
		
		page = queryAccountingServiceImpl.findByAccountingYearOrMonth(page, params);
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		
		return params;
	}

}
