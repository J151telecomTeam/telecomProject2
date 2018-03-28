package com.telecom.project.aspects;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.telecom.project.annotations.MyLog;
import com.telecom.project.changelogmag.operationServerService.IOperationService;

@Component
@Aspect
public class ChangeLogAspect {

	@Pointcut(value="@annotation(com.telecom.project.annotations.MyLog)")
	public void pointcutExpression() {
	}
	
	@AfterReturning(pointcut="pointcutExpression() && @annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object ret) {
//		OptLogsBean log = new OptLogsBean();
//		log.setUserName("小胖子");
//		log.setOptTime(new Date(System.currentTimeMillis()));
//		log.setMenuName(myLog.menuName());
//		log.setMenuMethod(myLog.menuMethod());
//		Object[] args = jp.getArgs();
//		log.setData(Arrays.toString(args));
//		optLogServiceImpl.saveOptLogBean(log);
		System.out.println("asdasdasdasdasdasdasdadsada");
	}
	
}
