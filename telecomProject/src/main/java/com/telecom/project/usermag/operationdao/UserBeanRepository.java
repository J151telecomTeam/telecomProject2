package com.telecom.project.usermag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.telecom.project.beans.UserBean;

public interface UserBeanRepository extends JpaRepository<UserBean, Long>, JpaSpecificationExecutor<UserBean>{
	@Modifying
    @Query(value="UPDATE UserBean as u SET u_delete = -1 WHERE u.id = ?1")
	public void deleteUserBeanById(Long id);
	
	
	/**
	 * 停用方法
	 * @param id
	 */
	@Modifying
	@Query(value="update UserBean as u set u.status='已停用'where u.id=?1")
	public void updateUserBeanByStatus(Long id);
	
	
	/**
	 * 激活方法
	 * @param id
	 */
	@Modifying
	@Query(value="update UserBean as u set u.status='已激活'where u.id=?1")
	public void updateUserBeanByJiStatus(Long id);
	
}
