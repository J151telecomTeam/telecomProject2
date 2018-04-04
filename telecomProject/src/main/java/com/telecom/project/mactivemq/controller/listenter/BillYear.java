package com.telecom.project.mactivemq.controller.listenter;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.operationService.IOperationAccountingDayService;
import com.telecom.project.accountingmag.operationService.IOperationAccountingMonthService;
import com.telecom.project.accountingmag.operationService.IOperationAccountingYearService;
import com.telecom.project.accountingmag.queryServerService.IQueryAccountingService;

@Service("year")
public class BillYear {
	
private IOperationAccountingDayService operationAccountingDayServiceImpl;
	
	private IOperationAccountingMonthService operationAccountingMonthServiceImpl;
	
	private IOperationAccountingYearService operationAccountingYearServiceImpl;
	
	private IQueryAccountingService queryAccountingServiceImpl;
	
	
	public void execute()  {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
