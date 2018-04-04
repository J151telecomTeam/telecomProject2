package com.telecom.project.rolemag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.telecom.project.beans.PowerBean;
import com.telecom.project.beans.RoleBean;

public interface IOperationRoleDao extends JpaRepository<RoleBean, Long>,JpaSpecificationExecutor<RoleBean>{
	
}
