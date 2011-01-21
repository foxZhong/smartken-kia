package com.smartken.kia.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DateTimeUtil {

	public static final int SUNDAY=0;
	public static final int MONDAY=1;
	public static final int TUESDAY=2;
	public static final int WEDNESDAY=3;
	public static final int THURSDAY=4;
	public static final int FRIDAY=5;
	public static final int SATURDAY=6;
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	public static ArrayList<Date> getWeekDays(Date pDt)
	{

		if(pDt==null)return null;
		int[] weekdays=new int[]{0,1,2,3,4,5,6};
		ArrayList<Date> lListReturn=new ArrayList<Date>();
		Calendar c=Calendar.getInstance();
		c.setTime(pDt);
		int weekday=c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_WEEK, -weekday);
		int t=0;
		while(t++<7)
		{
			c.add(Calendar.DAY_OF_WEEK, 1);
			lListReturn.add(c.getTime());
		}
		return lListReturn;
	}
	
	public static ArrayList<Date> getWeekDays(int year,int weeknum)
	{
		ArrayList<Date> lListReturn=new ArrayList<Date>();
		Calendar c=Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, weeknum);
		c.set(Calendar.DAY_OF_WEEK, 0);
		lListReturn=getWeekDays(c.getTime());
		//System.out.println(c.getTime().toString());
		return lListReturn;
		
	}
	
	public static String format(java.util.Date date,String dateFormat) {
		 if(date == null)
			 return null;
		 return new SimpleDateFormat(dateFormat).format(date);
	}
	
	
	public static void main(String[] args)
	{
		Calendar c=Calendar.getInstance();
		Date d=new Date();
		int dw=c.get(Calendar.DAY_OF_WEEK);
		ArrayList<Date> ld=DateTimeUtil.getWeekDays(d);
		ld=DateTimeUtil.getWeekDays(2011, 30);
		Iterator<Date> it=ld.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}
	
	}
}
