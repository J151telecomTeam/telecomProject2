package com.telecom.project.changelogmag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.ChangeBean;

public interface IOperationChangeDao extends JpaRepository<ChangeBean,Long>,JpaSpecificationExecutor<ChangeBean>{

}
