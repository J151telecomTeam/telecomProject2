package com.telecom.project.accountingmag.operationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.AccountingMonthBean;

public interface IOperationAccountingMonthDao extends JpaRepository<AccountingMonthBean, Long>,JpaSpecificationExecutor<AccountingMonthBean>{

}
