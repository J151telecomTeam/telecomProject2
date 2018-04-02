package com.telecom.project.dealmag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.DealBean;

public interface IOperationDealDao extends JpaRepository<DealBean, Long>,JpaSpecificationExecutor<DealBean>{
	

}
