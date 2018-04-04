package com.telecom.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	/**
	 * 将string转为格式为yyyy-MM-dd格式时间
	 * @param date String时间
	 * @return
	 */
	public static Date dateConverter(String date) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = simple.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 将Date转换为格式为yyyy-MM-dd格式字符串
	 * @param date Date时间
	 * @return
	 */
	public static String dateConverter(Date date) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String d = null;
		try {
			d =  simple.format(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return d;
	}
}
