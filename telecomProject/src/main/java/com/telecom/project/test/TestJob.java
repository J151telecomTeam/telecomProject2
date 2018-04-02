package com.telecom.project.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//定时器
@Component
public class TestJob {

	@Scheduled(cron = "0 0 0 1 * ? ") // 每月第一天执行一次
	public void monthExecute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("月定时任务类，现在的执行时间是" + sdf.format(new Date()));
	}
	
	@Scheduled(cron = "0 0 0 * * ? ") // 每天执行一次
	public void dayExecute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("天定时任务类，现在的执行时间是" + sdf.format(new Date()));
	}
	
	@Scheduled(cron = "0 0 0 1 1 ? ") // 每年执行一次
	public void yearExecute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("年定时任务类，现在的执行时间是" + sdf.format(new Date()));
	}
}
