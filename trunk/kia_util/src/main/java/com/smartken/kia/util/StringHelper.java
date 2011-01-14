package com.smartken.kia.util;

import java.util.ArrayList;

public class StringHelper {

	
	  public static int LT=-2;
	  public static int LTE=-1;
	  public static int EQ=0;
	  public static int GTE=1;
	  public static int GT=2;
	  public static int IN=3;
	  public static int NOTIN=4;
	  public static int LIKE=5;
	  public static int ALL=6;
	
	public static ArrayList<String> strToArr(String pStrVal)
	{
		ArrayList<String> lListReturn=new ArrayList<String>();
		lListReturn.add(pStrVal);
		return lListReturn;
	}
	
	public static ArrayList<String> strSplitArr(String pStrVal,String pStrSplit)
	{
		ArrayList<String> lListReturn=new ArrayList<String>();
		String[] lArrVals=pStrVal.split(pStrSplit);
		for(int i=0;i<lArrVals.length;i++)
		{
			lListReturn.add(lArrVals[i]);
		}
		return lListReturn;
	}
	
	public static boolean strIsBlank(String pStr)
	{
		return pStr==null||pStr.length()==0;
	}
}
