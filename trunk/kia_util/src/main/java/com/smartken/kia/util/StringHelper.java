package com.smartken.kia.util;

public class StringHelper {

	
	public static String formatString(String lStrFormat)
	{
		return formatString(lStrFormat, "");
	}
	
	public static String formatString(String lStrFormat,String lStrDefault)
	{
		return lStrFormat==lStrDefault?"":lStrFormat;
	}
	
	public static int formatInt(String lStrFormat)
	{
		return formatInt(lStrFormat, 0);
	}
	
	public static int formatInt(String lStrFormat,int lIntDefault)
	{
		if(lStrFormat==null)
			return lIntDefault;
		int lIntFormat;
		try
		{
			lIntFormat=Integer.parseInt(lStrFormat);
		}catch(NumberFormatException nfe)
		{
			lIntFormat=lIntDefault;
		}
		return lIntFormat;
	}
	
	public static double formatDouble(String lStrFormat)
	{
		return formatDouble(lStrFormat, 0);
	}
	
	public static double formatDouble(String lStrFormat,double lDubDefault)
	{
		if(lStrFormat==null)
			return lDubDefault;
		double lDubFormat;
		try
		{
			lDubFormat=Double.parseDouble(lStrFormat);
		}catch(NumberFormatException nfe)
		{
			lDubFormat=lDubDefault;
		}
		return lDubFormat;
	}
}
