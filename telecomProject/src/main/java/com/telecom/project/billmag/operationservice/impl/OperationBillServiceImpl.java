package com.telecom.project.billmag.operationservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.beans.BillMonthBean;
import com.telecom.project.billmag.operationdao.IOperationBillDao;
import com.telecom.project.billmag.operationservice.IOperationBillService;
import com.telecom.project.billmag.queryservice.IQueryBillService;

/**
 * 账单增删改业务实现类
 * @author 
 *
 */
@Service
public class OperationBillServiceImpl implements IOperationBillService{

	@Resource
	private IOperationBillDao operationBillDao;
	
	@Resource
	private IQueryBillService queryBillServiceImpl;

	@Override
	public void saveBillBean(BillMonthBean bill) {
		// TODO Auto-generated method stub
		operationBillDao.save(bill);
	}

	@Override
	public void updateBillBean(BillMonthBean bill) {
		// TODO Auto-generated method stub
		
		BillMonthBean bill1 = queryBillServiceImpl.findById(bill.getId());
		
		bill.setDate(bill1.getDate());
		bill.setIdCard(bill1.getIdCard());
		bill.setZwAccount(bill1.getZwAccount());
		bill.setState(1);
		
		operationBillDao.saveAndFlush(bill);
	}

	

	

}
