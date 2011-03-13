package com.smartken.kia.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DateTimeUtil {

	public static final int SUNDAY=6;
	public static final int MONDAY=0;
	public static final int TUESDAY=1;
	public static final int WEDNESDAY=2;
	public static final int THURSDAY=3;
	public static final int FRIDAY=4;
	public static final int SATURDAY=5;
	public static final String DATE_FORMAT_DB = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YMD = "yyyy/MM/dd";
	public static final String DATE_FORMAT_DMY = "dd/MM/yyyy";
	public static final String TIME_FORMAT_DB = "HH:mm:ss";
	public static final String DATE_TIME_FORMAT_DB = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT_DB = "yyyy-MM-dd HH:mm:ss.S";
	
	public static ArrayList<Date> getWeekDays(Date pDt)
	{

		if(pDt==null)return null;
		ArrayList<Date> lListReturn=new ArrayList<Date>();
		Calendar c=Calendar.getInstance();
		c.setTime(pDt);
		int weekday=c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_WEEK, -(weekday-1));
		int t=0;
		while(t++<7)
		{
			c.add(Calendar.DATE, 1);
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
	
	
	public static int getWeekOfYear(Date date)
	{
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	
	public static java.util.Date parse(String dateString){
		java.util.Date dateReturn=null;
		try{
			dateReturn=new SimpleDateFormat().parse(dateString);
		}catch(Exception ex){
			ArrayList<String> listDateFormat=new ArrayList<String>();
			listDateFormat.add(DATE_FORMAT_DB);
			listDateFormat.add(DATE_FORMAT_DMY);
			listDateFormat.add(DATE_FORMAT_YMD);
		for (String dateFormat : listDateFormat) {
			try {
				java.util.Date dateTemp=parse(dateString, dateFormat,java.util.Date.class);
				dateReturn=dateTemp;
			} catch (Exception e) {
				dateReturn=null;
				//e.printStackTrace();
			}
			if(dateReturn!=null)break;
		}
		}
		return dateReturn;
	}
	
	
	public static java.util.Date parse(String dateString,String dateFormat) throws Exception {
		return parse(dateString, dateFormat,java.util.Date.class);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends java.util.Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) throws Exception {
		if(StringUtil.isBlank(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		long time = df.parse(dateString).getTime();
		java.util.Date t = targetResultType.getConstructor(long.class).newInstance(time);
		Calendar cale=Calendar.getInstance();
		cale.setTime(t);
		if(cale.get(Calendar.YEAR)<1000) throw new Exception();
		return (T)t;

	}
	
	
	
	public static void main(String[] args)
	{
//		Calendar c=Calendar.getInstance();
//		Date d=new Date();
//		int dw=c.get(Calendar.DAY_OF_WEEK);
//		ArrayList<Date> ld=DateTimeUtil.getWeekDays(d);
//		ld=DateTimeUtil.getWeekDays(2011, 30);
//		Iterator<Date> it=ld.iterator();
//		while(it.hasNext())
//		{
//			System.out.println(it.next().toString());
//		}
	    String dt="2011/03/09";
	    Date date=parse(dt);
	    System.out.println(date);
	}
}
