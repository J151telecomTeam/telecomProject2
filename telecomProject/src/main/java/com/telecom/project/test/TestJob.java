package com.telecom.project.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//定时器
@Component()
public class TestJob {
	@Scheduled(cron = "0/1 * *  * * ? ")//1S执行一次
	    public void execute(){
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        System.out.println("我是定时任务类，现在的执行时间是" + sdf.format(new Date()));
	        
	    }
	
}
