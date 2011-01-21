package com.smartken.kia.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;

import com.smartken.kia.util.model.IJsonModel;


public class ObjectUtil {

	
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
	
	@SuppressWarnings("all")
    public static boolean isEmpty(Object o)  {
        if(o == null) return true;

        if(o instanceof String) {
            if(((String)o).length() == 0){
                return true;
            }
        } else if(o instanceof Collection) {
            if(((Collection)o).isEmpty()){
                return true;
            }
        } else if(o.getClass().isArray()) {
            if(Array.getLength(o) == 0){
                return true;
            }
        } else if(o instanceof Map) {
            if(((Map)o).isEmpty()){
                return true;
            }
        }else {
            return false;
        }

        return false;
    }
	
	@SuppressWarnings("all")
	public static Map toMap(Object[] array,String...keys) {
		if(array == null) return new HashMap();
		Map m = new LinkedHashMap();
		for(int i = 0; i < keys.length; i++) {
			if(array.length == i ) {
				break;
			}
			m.put(keys[i], array[i]);
		}
		return m;
	}
	
	public static void main(String[] args)
	{
	}
	
}
