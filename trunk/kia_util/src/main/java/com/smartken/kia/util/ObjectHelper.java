package com.smartken.kia.util;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;

import com.smartken.kia.util.model.IJsonModel;


public class ObjectHelper {

	
	public static String formatString(Object lObjFormat)
	{
		return formatString(lObjFormat, "");
	}
	
	public static String formatString(Object lObjFormat,String lStrDefault)
	{
		return lObjFormat==null?lStrDefault:lObjFormat.toString();
	}
	
	public static int formatInt(Object lObjFormat)
	{
		return formatInt(lObjFormat, 0);
	}
	
	public static int formatInt(Object lObjFormat,int lIntDefault)
	{
		if(lObjFormat==null)
			return lIntDefault;
		int lIntFormat;
		try
		{
			lIntFormat=Integer.parseInt(lObjFormat.toString());
		}catch(NumberFormatException nfe)
		{
			lIntFormat=lIntDefault;
		}
		return lIntFormat;
	}
	
	public static double formatDouble(Object lObjFormat)
	{
		return formatDouble(lObjFormat, 0);
	}
	
	public static double formatDouble(Object lObjFormat,double lDubDefault)
	{
		if(lObjFormat==null)
			return lDubDefault;
		double lDubFormat;
		try
		{
			lDubFormat=Double.parseDouble(lObjFormat.toString());
		}catch(NumberFormatException nfe)
		{
			lDubFormat=lDubDefault;
		}
		return lDubFormat;
	}
	
	public static JSONArray toJsonArray(ArrayList<IJsonModel> lListObj)
	{
		JSONArray lJsonList=new JSONArray();
		for(Iterator<IJsonModel> it=lListObj.iterator();it.hasNext();)
		{
			lJsonList.put(it.next().toJson());
		}
		return lJsonList;
	}
	
	public static boolean isEmpty(ArrayList pList)
	{
		if(pList==null||pList.size()<1) 
			return true;
		else 
			return false;
	}
	
}
