package com.telecom.project.dealmag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.DealBean;
import com.telecom.project.dealmag.operationdao.IOperationDealDao;
import com.telecom.project.dealmag.operationservice.IOperationDealService;
import com.telecom.project.dealmag.queryservice.IQueryDealService;


@Service
public class OperationDealServiceImpl implements IOperationDealService{

	@Resource
	private IOperationDealDao operationDealDao;
	
	@Resource
	private IQueryDealService queryDealServiceImpl;
	
	@Override
	public void saveDealBean(DealBean deal) {
		// TODO Auto-generated method stub
		operationDealDao.save(deal);
	}

	@Override
	public void updateDealBean(DealBean deal) {
		// TODO Auto-generated method stub
		DealBean deal1 = queryDealServiceImpl.findById(deal.getId());
		if(deal.getName() == null) {
			deal.setName(deal1.getName());
		}
		if(deal.getType() == 0) {
			deal.setType(deal1.getType());
		}
		if(deal.getCost() == 0.0) {
			deal.setCost(deal1.getCost());
		}
		if(deal.getMsg() == null) {
			deal.setMsg(deal1.getMsg());
		}
		
		
		operationDealDao.saveAndFlush(deal);
		
	}

	@Override
	public void deleteBatchDealBean(List<DealBean> deals) {
		// TODO Auto-generated method stub
		
		for (DealBean dealBean : deals) {
			operationDealDao.saveAndFlush(dealBean);
		}
		
	}

}
