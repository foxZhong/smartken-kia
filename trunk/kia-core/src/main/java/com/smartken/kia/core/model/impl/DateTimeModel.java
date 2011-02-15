package com.smartken.kia.core.model.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTimeModel extends Date{
	
    private String[] gArrWeekDaysCn=new String[]{"日","一","二","三","四","五","六"};
    private int[] gArrWeekdays=new int[]{0,1,2,3,4,5,6};
	public String getDayOfWeekCN() {
       return getDayOfWeekCN("星期");
	}
	
	public String getDayOfWeekCN(String prefix) {
	    return getDayOfWeekCN(prefix,gArrWeekDaysCn);
	}
	
	public String getDayOfWeekCN(String prefix,String[] weekdays) {
		Calendar c=Calendar.getInstance();
		c.setTime(this);
		int dw= c.get(Calendar.DAY_OF_WEEK);
		return prefix+weekdays[dw];
	}
	
	public ArrayList<Date> getWeekDays()
	{

		ArrayList<Date> lListReturn=new ArrayList<Date>();
		Calendar c=Calendar.getInstance();
		c.setTime(this);
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
	
	

}
