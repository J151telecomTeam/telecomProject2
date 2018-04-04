package com.telecom.project.powermag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.telecom.project.beans.PowerBean;

public interface IOperationPowerDao extends JpaRepository<PowerBean, Long>,JpaSpecificationExecutor<PowerBean>{
	
	
	
	
}
