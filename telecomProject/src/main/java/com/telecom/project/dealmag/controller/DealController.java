package com.telecom.project.dealmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.project.beans.DealBean;
import com.telecom.project.beans.PageBean;
import com.telecom.project.dealmag.operationservice.IOperationDealService;
import com.telecom.project.dealmag.queryservice.IQueryDealService;

@RequestMapping(value="/deal")
@RestController
public class DealController {
	
	@Resource
	private IQueryDealService queryDealServiceImpl;
	
	@Resource
	private IOperationDealService operationDealServiceImpl;
	
	/**
	 * 点击暂停按钮时请求到达该方法
	 * @param deals
	 * @return
	 */
	@RequestMapping(value="/stop1",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public Map stop1DealBean(@RequestBody List<DealBean> deals) {
		
		Map params = new HashMap<>();
		
		params.put("information", "暂停成功");
		
		for (DealBean dealBean : deals) {
			if(queryDealServiceImpl.findByFkDealId(dealBean.getId()).size() > 0) {
				params.put("information", "资费名为："+dealBean.getName()+"  的资费尚有业务使用，无法暂停");
				return params;
			}else {
				dealBean.setStop(0);
			}
		}
		
		operationDealServiceImpl.deleteBatchDealBean(deals);
		
		return params;
	}
	
	/**
	 * 点击开通按钮时请求发送到该方法
	 * @param deals
	 * @return
	 */
	@RequestMapping(value="/stop",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public Map stopDealBean(@RequestBody List<DealBean> deals) {
		
		Map params = new HashMap<>();
		
		params.put("information", "开通成功");
		
		for (DealBean dealBean : deals) {
			dealBean.setStop(1);
		}
		
		operationDealServiceImpl.deleteBatchDealBean(deals);
		
		return params;
	}
	
	/**
	 * 批量删除
	 * @return
	 */
	@RequestMapping(value="/delete",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public Map deleteDealBean(@RequestBody List<DealBean> deals) {
		Map params = new HashMap<>();
		params.put("information", "删除成功");
//		System.out.println(deals.size());
//		System.out.println(deals.get(0));
		for (DealBean dealBean : deals) {
			dealBean.setDelete(0);
		}
		operationDealServiceImpl.deleteBatchDealBean(deals);
		
		return params;
	}
	
	/**
	 * 点击确认修改按钮后请求发送到该方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public Map updateDealBean(HttpServletRequest request) {
		
		Map params = new HashMap<>();
		params.put("information", "修改成功");
		
		DealBean deal = queryDealServiceImpl.findById(Integer.parseInt(request.getParameter("id")));
		if("1".equals(request.getParameter("type"))) {
			deal.setName(request.getParameter("name"));
			deal.setCost(Double.parseDouble(request.getParameter("cost")));
			deal.setMsg(request.getParameter("msg"));
		}
		if("2".equals(request.getParameter("type"))) {
			deal.setName(request.getParameter("name"));
			deal.setMoney(Double.parseDouble(request.getParameter("cost")));
			deal.setMsg(request.getParameter("msg"));
		}
		if("3".equals(request.getParameter("type"))) {
			deal.setName(request.getParameter("name"));
			deal.setCost(Double.parseDouble(request.getParameter("cost")));
			deal.setMoney(Double.parseDouble(request.getParameter("cost")));
			deal.setMsg(request.getParameter("msg"));
		}
		
		operationDealServiceImpl.updateDealBean(deal);
		System.out.println(deal);
		return params;
	}
	
	/**
	 * 点击确认新增按钮时请求进入该方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/save",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public Map saveDealBean(HttpServletRequest request) {
		
		Map params = new HashMap<>();
		params.put("information", "添加成功");
		
		if("1".equals(request.getParameter("type"))) {
			DealBean deal = new DealBean();
			deal.setType(Integer.parseInt(request.getParameter("type")));
			deal.setName(request.getParameter("name"));
			deal.setCost(Double.parseDouble(request.getParameter("cost")));
			deal.setMoney(0.0);
			deal.setMsg(request.getParameter("msg"));
			deal.setDelete(1);
			deal.setStop(0);
			operationDealServiceImpl.saveDealBean(deal);
		}
		if("2".equals(request.getParameter("type"))) {
			DealBean deal = new DealBean();
			deal.setType(Integer.parseInt(request.getParameter("type")));
			deal.setName(request.getParameter("name"));
			deal.setCost(0.0);
			deal.setMoney(Double.parseDouble(request.getParameter("money")));
			deal.setMsg(request.getParameter("msg"));
			deal.setDelete(1);
			deal.setStop(0);
			operationDealServiceImpl.saveDealBean(deal);
		}
		if("3".equals(request.getParameter("type"))) {
			DealBean deal = new DealBean();
			deal.setType(Integer.parseInt(request.getParameter("type")));
			deal.setName(request.getParameter("name"));
			deal.setCost(Double.parseDouble(request.getParameter("cost")));
			deal.setMoney(Double.parseDouble(request.getParameter("money")));
			deal.setDuration(Integer.parseInt(request.getParameter("duration")));
			deal.setMsg(request.getParameter("msg"));
			deal.setDelete(1);
			deal.setStop(0);
			operationDealServiceImpl.saveDealBean(deal);
		}
		
		return params;
	}

	/**
	 * 进入页面默认调用和点击搜索按钮时调用
	 * @param type
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/type",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public Map findByType(String type,PageBean page) {
		
		Map params = new HashMap<>();
		params.put("type", type);
		page = queryDealServiceImpl.findByType(page, params);
		params.put("total", page.getTotalRows());
		params.put("rows", page.getDatas());
		return params;
	}
	
}
