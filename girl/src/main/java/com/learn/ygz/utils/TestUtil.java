package com.learn.ygz.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
/**
 * 测试工具类
 * @author Administrator
 *
 */
public class TestUtil {

	public static String getXml(String name) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		
		String xml = "";
		ByteArrayOutputStream bo = null;
		try {
			bo=new ByteArrayOutputStream();
			for(int i=-1;(i=is.read())!=-1;){
				bo.write(i);
			}
			xml = bo.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bo!=null){
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return xml;
	}
	
	/**
	 * 
	 * @获取起飞目的地三字码(用于自动化测试)随机获取国内起飞目的地三字码
	 */
	public static List<String> getDepArrAirport(){
		List<String> listStr = new ArrayList<String>();
		
		String cityArray [] = {"PEK","CAN","SZX","CSX","CTU","CKG","FOC","KWE","HAK","HGH","KMG","KHN",
				"NKG","SYX","SHA","PVG","SHE","WNZ","WUH","XMN","SIA","CGO","SWA","TYN","TSN","URC","YIW"
				,"ZHA","CGO","DLC","KWL","HRB","HFE","TNA","NNG","NGB","TAO","MDG","JMU","YNJ","HET"};
		for(int i=0;i<2;i++){
			int index = (int)(Math.random()*cityArray.length);
			String cityStr = cityArray[index];
			listStr.add(cityStr);
		}
		return listStr;
	}
	
	// 获取当天时间
		 public static String getToday(String dateformat) {
		  Date now = new Date();
		  SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
		  String today = dateFormat.format(now);
		  return today;
		 }
		 
			// 获取当天时间
		 public static String getTomorrow(String dateformat) {
		  Date date = new Date();
		  Calendar calendar = new GregorianCalendar();
		  calendar.setTime(date);
		  calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		  date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		  SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
		  String today = dateFormat.format(date);
		  return today;
		 }
	/*
	 * 获取随机日期
	 * 
	 * @param begindate 起始日期，格式为：yyyymmdd
	 * 20130303
	 * @param enddate 结束日期，格式为：yyyymmdd
	 * 获取指定范围内的随机日期
	 * @return
	 */
	public static String randomdate(String begindate, String enddate) {
		try {
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date start = format.parse(begindate);// 构造开始日期
			Date end = format.parse(enddate);// 构造结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(new Date(date));
			return format.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}

}
