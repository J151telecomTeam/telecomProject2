package com.telecom.project.servermag.operationdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.telecom.project.beans.ServerBean;



public interface IOperationServerDao extends JpaRepository<ServerBean, Long>,JpaSpecificationExecutor<ServerBean> {
	
	
	/**
	 * 根据id删除服务器
	 * @param id
	 */
	@Modifying
	@Query(value="update ServerBean as s set s_delete = 1 where s.id = ?1")
	public void deleteServerBeanById(long id);
	
	/**
	 * 批量删除
	 * @param servers
	 */
	@Modifying
	@Query(value="update ServerBean as s set s_delete = 1 where s.id in ?1")
	public void deleteBatchServerBean(List<Long> id);
	
}
