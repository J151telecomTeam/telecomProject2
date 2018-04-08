package com.telecom.project.loginlogmag.operationdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.telecom.project.beans.LoginLogBean;

public interface IOperationloginlogdao extends JpaRepository<LoginLogBean, Long> ,JpaSpecificationExecutor<LoginLogBean>{

}
