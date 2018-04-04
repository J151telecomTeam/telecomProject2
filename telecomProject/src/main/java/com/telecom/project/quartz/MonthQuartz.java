package com.telecom.project.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonthQuartz {
	
	@Scheduled(cron = "0 0 0 1 * ? ") // 每月第一天执行一次
	public void monthExecute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("月定时任务类，现在的执行时间是" + sdf.format(new Date()));
	}

}
