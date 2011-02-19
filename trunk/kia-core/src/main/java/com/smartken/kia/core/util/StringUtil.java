package com.smartken.kia.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.smartken.kia.core.enums.FormatEnum;

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
	
	public static String quota(Object value)
	{
		if(value==null)return "\"\"";
		return "\""+value.toString()+"\"";
	}
	
	public static String formatId(String prefix,String spar,Object... subStr)
	{
		return formatId(true,prefix, spar,subStr);
		
	}
	
	public static String formatId(boolean isStr,String prefix,String spar,Object... subStr)
	{
		StringBuffer lSbrId=new StringBuffer("");
		String lSpar=ObjectUtil.formatString(spar);
		lSbrId.append(ObjectUtil.formatString(prefix));
		for(int i=0;i<subStr.length;i++)
		{
			lSbrId.append(subStr[i].toString());
			if(i!=subStr.length-1)
			{
			  lSbrId.append(lSpar);	
			}
		}
		if(isStr)
		{
			return quota(lSbrId.toString());
		}else
		{
			return lSbrId.toString();
		}
	}
	
	public static String format(String pStr,FormatEnum fe){
		if(isBlank(pStr))return "";
		String lStrFormat="";
		switch (fe) {
		case UPCASE_FIRST:
			lStrFormat=pStr.substring(0, 1).toUpperCase()+pStr.substring(1);
			break;
		default:
			break;
		}
		return lStrFormat;
	}
	
	public static String ln(){
		return ln(1);
	}
	
	public static String ln(int ln){
		String lnReturn="";
		for(int i=1;i<=ln;i++){
			lnReturn+="\n";
		}
		return lnReturn;
	}
	
	public static void main(String[] args)
	{
		String lStr=StringUtil.formatId("#", null, "form","aSave");
		System.out.println(lStr);
	}
}
