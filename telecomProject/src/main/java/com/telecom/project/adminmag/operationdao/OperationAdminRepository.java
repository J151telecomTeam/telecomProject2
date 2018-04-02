package com.telecom.project.adminmag.operationdao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.project.beans.AdminBean;

public interface OperationAdminRepository extends JpaRepository<AdminBean, Long>,JpaSpecificationExecutor<AdminBean> {

	@Modifying
	@Transactional
	@Query(value="delete from AdminBean as a where a.id = ?1")
	public void deleteAdmin(Long id);
	
	
	
	
}
