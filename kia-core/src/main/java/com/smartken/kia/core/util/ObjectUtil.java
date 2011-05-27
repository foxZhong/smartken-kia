package com.smartken.kia.core.util;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.net.TelnetAppender;
import org.json.JSONArray;
import org.w3c.dom.ls.LSResourceResolver;

import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.IScriptModel;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.PageList;


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
	

	
	
	public static JSONArray toJsonArray(List<IFormatterModel> lListObj)
	{
		JSONArray lJsonList=new JSONArray();
		for(Iterator<IFormatterModel> it=lListObj.iterator();it.hasNext();)
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
	
	public static boolean isNotEmpty(Object o)
	{
		return !isEmpty(o);
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
	
	@SuppressWarnings("unchecked")
	public static String toJsonFormat(Map<String, Object> map)
	{
		StringBuffer lSbrReturn=new StringBuffer("");
		lSbrReturn.append("{ \n");
		for(Iterator<String> itKey=map.keySet().iterator();itKey.hasNext();)
		{
			String tempKey=itKey.next();
			Object tempObj=map.get(tempKey);
			String tempStr="";
			if(tempObj instanceof Map<?,?>)
			{
		        tempStr=toJsonFormat((Map<String, Object>)tempObj);
			}else if(tempObj instanceof List)
			{
				tempStr=toJsonFormat((List)tempObj); //1
			}else if(tempObj instanceof IScriptModel)
			{
				tempStr=((IScriptModel)tempObj).toScirpt();
			}
			else
			{
				tempStr=tempObj.toString();
			}
			lSbrReturn.append(MessageFormat.format("{0}:{1}", 
				         tempKey,   //0
				         tempStr //1
				         )
		      );
			if(itKey.hasNext())
			{
				lSbrReturn.append(",\n");
			}
			
		}
		lSbrReturn.append("} \n");
		return lSbrReturn.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static String toJsonFormat(List list)
	{
		StringBuffer lSbrReturn=new StringBuffer("");
		lSbrReturn.append("[ \n");
        for(Iterator it=list.iterator();it.hasNext();){
			Object tempObj=it.next();
        	if(tempObj instanceof List)
			{
			  lSbrReturn.append(toJsonFormat((List)tempObj));
			}
			else if( tempObj instanceof Map)
			{
			  lSbrReturn.append(toJsonFormat((Map)tempObj));
			}
        	if(it.hasNext())
        	{
        		lSbrReturn.append(", \n");
        	}
		}
		lSbrReturn.append("] \n");
		return lSbrReturn.toString();
	}
	
	public static boolean isInterface(Class c, String szInterface) {
		Class[] face = c.getInterfaces();
		for (int i = 0, j = face.length; i < j; i++) {
			if (face[i].getName().equals(szInterface)) {
				return true;
			} else {
				Class[] face1 = face[i].getInterfaces();
				for (int x = 0; x < face1.length; x++) {
					if (face1[x].getName().equals(szInterface)) {
						return true;
					} else if (isInterface(face1[x], szInterface)) {
						return true;
					}
				}
			}
		}
		if (null != c.getSuperclass()) {
			return isInterface(c.getSuperclass(), szInterface);
		}
		return false;
	}
	
	public static List toList(Map map ){
		List listReturn=new ArrayList();
		for(Iterator it=map.keySet().iterator();it.hasNext();)
		{
			Object key=it.next();
			listReturn.add(map.get(key));
		}
		return listReturn;
		
	}
	
	
	public static boolean isInArray(Object obj,Object[] objs){
		if(obj==null || obj==null) return false;
		boolean isIn=false;
		for(int i=objs.length-1;i>=0;i--)
		{
			if(obj.equals(objs[i]))
			{
				isIn=true;
				break;
			}
		}
		return isIn;
	}
	
	public static boolean isNotInArray(Object obj,Object[] objs){
		return  !isInArray(obj, objs);
	}
	
	public static boolean isEquals(Object obj1,Object obj2){
		if(obj1!=null&&obj2!=null){
			return obj1.equals(obj2);
		}
		else if(obj1==null&&obj2==null){
			return true;
		}else if(obj2==null&&obj1!=null){
			return false;
		}else if(obj1==null&&obj2!=null){
			return false;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEquals(Object obj1,Object obj2){
		return !isEquals(obj1, obj2);
	}
	

	public static PageList toPageList(List list,PageBounds pageBounds){
		PageList pList=new PageList();
		int limit= pageBounds.getLimit();
		int offset= pageBounds.getOffset();
		int index=limit*offset;
		for(int i=index;i<index+limit;i++){
			pList.add(list.get(i));
		}
		return pList;
	}
	
	
	public static void main(String[] args)
	{
	}
	
}
