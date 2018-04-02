package com.telecom.project.rolemag.operationroleservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.project.beans.RoleBean;

public interface OperationRoleRepository extends JpaRepository<RoleBean, Long>,JpaSpecificationExecutor<RoleBean>{

	@Modifying
	@Transactional
	@Query(value="delete from RoleBean where r_id = ?1")
	public void deleteRoleBean(Long id);
	
	
}
