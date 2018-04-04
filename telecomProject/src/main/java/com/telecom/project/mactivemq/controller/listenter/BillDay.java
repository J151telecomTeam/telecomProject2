package com.telecom.project.mactivemq.controller.listenter;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.telecom.project.accountingmag.operationService.IOperationAccountingDayService;
import com.telecom.project.accountingmag.operationService.IOperationAccountingMonthService;
import com.telecom.project.accountingmag.operationService.IOperationAccountingYearService;
import com.telecom.project.accountingmag.queryServerService.IQueryAccountingService;
import com.telecom.project.beans.ServiceRecordBean;
import com.telecom.project.utils.DateConverter;


@Service("day")
public class BillDay {
	
	private IOperationAccountingDayService operationAccountingDayServiceImpl;
	
	private IOperationAccountingMonthService operationAccountingMonthServiceImpl;
	
	private IOperationAccountingYearService operationAccountingYearServiceImpl;
	
	private IQueryAccountingService queryAccountingServiceImpl;
	
	
	public void execute()  {
		try {
			Date newDate = new Date();
			String date = DateConverter.dateConverter(newDate);
			String[] dates = date.split("-");
			int yea = Integer.valueOf( dates[0]);
			int mont = Integer.valueOf(dates[1]);
			int day = Integer.valueOf(dates[2]);
			
			ServiceRecordBean bean = new ServiceRecordBean();
			bean.setStartTime(newDate);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
