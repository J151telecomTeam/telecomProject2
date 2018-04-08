package com.telecom.project.aspects;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.telecom.project.annotations.MyLog;
import com.telecom.project.beans.ChangeBean;
import com.telecom.project.beans.UserBean;
import com.telecom.project.changelogmag.operationservice.IOperationService;

@Component
@Aspect
public class ChangeLogAspect {
	
	@Resource
	private IOperationService operationService;
	
	
//	com.telecom.project.*mag.operationservice.impl.*ServiceImpl
	@Pointcut(value="execution(* com.telecom.project.*mag.operationservice.impl.*ServiceImpl.*(..))")
	public void pointcutExpression() {
	}
	
	@AfterReturning(pointcut="pointcutExpression() && @annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object ret) {
		Subject subject=SecurityUtils.getSubject();
		Session session=subject.getSession();
		ChangeBean change = new ChangeBean();
		UserBean bean = null;
		if(session.getAttribute("user")!=null) {
			bean = (UserBean) session.getAttribute("user");
			String name = bean.getName();
			String acc = bean.getAccount();
			change.setName(name);
			change.setAccount(acc);
		}
		change.setChangeTime(new Date(System.currentTimeMillis()));
		change.setResult(myLog.result());
		change.setType(myLog.type());
		//获取目标方法传入的参数
		Object[] args = jp.getArgs();
		change.setDescription(Arrays.toString(args));
		System.out.println("方法执行完毕");
		operationService.saveChangeBeanBean(change);
	}
	
}
