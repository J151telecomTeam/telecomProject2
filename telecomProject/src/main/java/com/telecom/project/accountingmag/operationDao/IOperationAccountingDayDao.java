package com.telecom.project.accountingmag.operationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.AccountingDayBean;

public interface IOperationAccountingDayDao extends JpaRepository<AccountingDayBean, Long>,JpaSpecificationExecutor<IOperationAccountingDayDao>{

}
