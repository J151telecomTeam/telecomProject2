package com.telecom.project.billmag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.BillMonthBean;

public interface IOperationBillDao extends JpaRepository<BillMonthBean, Long>,JpaSpecificationExecutor<BillMonthBean>{

	
}
