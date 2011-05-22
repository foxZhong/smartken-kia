package com.smartken.kia.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.smartken.kia.core.enums.CodeEnum;
import com.smartken.kia.core.enums.StringFormatEnum;

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
	
	public static String format(String pStr,StringFormatEnum fe){
		if(isBlank(pStr))return "";
		String lStrFormat="";
		switch (fe) {
		case upcaseFirstChar:
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
	
	public static String tab(){
		return tab(1);
	}
	
	public static String tab(int ln){
		String lnReturn="";
		for(int i=1;i<=ln;i++){
			lnReturn+="\t";
		}
		return lnReturn;
	}
	
	public static ArrayList<String> format(String pattern,ArrayList pListValue,Object...params){
		ArrayList<String> lListReturn=new ArrayList(); 
		for(Iterator it=pListValue.iterator();it.hasNext();){
		   String tempValue=it.next().toString();
           ArrayList<String> tempParam=new ArrayList<String>();
           tempParam.add(tempValue);
           for(int i=0;i<params.length;i++){
        	   tempParam.add(params[i].toString());
           } 
		   String value=MessageFormat.format(pattern,tempParam.toArray());
		   lListReturn.add(value);
		}
		return lListReturn;
	}
	
	public static String decodeUtf8(String value){
		String lStrReturn="";
		if(value==null)return lStrReturn;
		try {
			lStrReturn =URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lStrReturn;
	}
	
	public static String encodeUtf8(String value){
		String lStrReturn="";
		if(value==null)return lStrReturn;
		try {
			lStrReturn =URLEncoder.encode(value, CodeEnum.utf8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lStrReturn;
	}
	
	public static void main(String[] args) 
	{
		String lStr=StringUtil.formatId("#", null, "form","aSave");
	    ArrayList<String> tempParam=new ArrayList<String>();
	    tempParam.add("xxx");
	    tempParam.add("xxgeadg");
	    ArrayList<String> tp=StringUtil.format("{1}:{0}={2}", tempParam, "admin","caerae");
	    System.out.println(tp.get(1));
		String c="å·¥èµ";
        encodeUtf8("xxx");

	
	}
}
