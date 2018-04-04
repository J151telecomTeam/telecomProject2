package com.telecom.project.businessaccountmag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.telecom.project.beans.BusinessAccountBean;


public interface BusinessAccountBeanRepository extends JpaRepository<BusinessAccountBean, Long>, JpaSpecificationExecutor<BusinessAccountBean>{
	/**
	 * 停用方法
	 * @param id
	 */
	@Modifying
	@Query(value="update BusinessAccountBean as s set s.status=-1 where s.id=?1")
	public void updateBusinessByStatus(Long id);
	
	/**
	 * 激活方法
	 * @param id
	 */
	@Modifying
	@Query(value="update BusinessAccountBean as s set s.status=1 where s.id=?1")
	public void updateUserBeanByJiStatus(Long id);
	
	@Modifying
    @Query(value="UPDATE BusinessAccountBean as s SET s_delete = -1 WHERE s.id = ?1")
	public void deleteBiuessBean(Long id);

	
}
