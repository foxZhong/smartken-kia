package com.smartken.kia.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {


	public static ArrayList<String> toList(String pStrVal)
	{
		ArrayList<String> lListReturn=new ArrayList<String>();
		lListReturn.add(pStrVal);
		return lListReturn;
	}
	
	public static ArrayList<String> splitToList(String pStrVal,String pStrSplit)
	{
		ArrayList<String> lListReturn=new ArrayList<String>();
		String[] lArrVals=pStrVal.split(pStrSplit);
		for(int i=0;i<lArrVals.length;i++)
		{
			lListReturn.add(lArrVals[i]);
		}
		return lListReturn;
	}
	
	@SuppressWarnings("all")
	public static String[] split(String str,String seperators) {
		StringTokenizer tokenlizer = new StringTokenizer(str,seperators);
		List result = new ArrayList();
		
		while(tokenlizer.hasMoreElements()) {
			Object s = tokenlizer.nextElement();
			result.add(s);
		}
		return (String[])result.toArray(new String[result.size()]);
	}
	
	public static boolean isBlank(String pStr)
	{
		return pStr==null||pStr.length()==0;
	}
	
	public static boolean isNotBlank(String pStr)
	{
		return !isBlank(pStr);
	}
}
