package com.telecom.project.accountingmag.operationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.AccountingYearBean;

public interface IOperationAccountingYearDao extends JpaRepository<AccountingYearBean, Long>,JpaSpecificationExecutor<AccountingYearBean>{
	

}
