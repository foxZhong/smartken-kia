package com.smartken.kia.core.model.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.crypto.spec.OAEPParameterSpec;

import com.smartken.kia.core.model.IScriptModel;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class JQueryModel implements IScriptModel {

	
	private String regexp;
	private String method;
	private ArrayList<Object> parmas=new ArrayList<Object>();
	
	public JQueryModel(String method)
	{
		this.regexp="";
		this.method=method;
	}
	
	public JQueryModel(String regexp,String method)
	{
		this.regexp="("+regexp+")";
		this.method=method;
	}
	
	public String toScirpt() {
		// TODO Auto-generated method stub
		String lStrRege="${0}.{1}(\n {2} \n);  // end:$(\"{0}\").{1}";
		String lStrReturn=MessageFormat.format(lStrRege, 
				this.regexp,   //0
				this.method,  //1
				this.getParmas() //2
				);
		return lStrReturn;
	}
	
	public JQueryModel appendParma(Object parma)
	{
		return this.appendParma(parma,false);
	}
	
	public JQueryModel appendParma(Object parma,boolean isStr)
	{
		String tempStr="";
		if(parma instanceof IScriptModel)
		{
			tempStr=((IScriptModel)parma).toScirpt();
		}else
		{
			tempStr=parma.toString();
		}
		if(isStr)
		{
			tempStr="\""+tempStr+"\"";
		}
		this.parmas.add(tempStr);
		return this;
	}
	
	public JQueryModel appendParma(String pattern,Object...arguments)
	{
		return this.appendParma(MessageFormat.format(pattern, arguments));
	}
	
	
	private String getParmas()
	{
		StringBuffer lSbrReturn=new StringBuffer("");
		for(Iterator<Object> it=this.parmas.iterator();it.hasNext();)
		{
			Object lStrTemp=it.next();
			lSbrReturn.append(lStrTemp.toString());
			if(it.hasNext())
			{
				lSbrReturn.append(",\n");
			}
		}
		return lSbrReturn.toString();
	}

	
	public final static String DOC_READY_START="$(document).ready(function(){ \n\n";
	public final static String DOC_READY_END="}); //$(document).ready";
	

	
	public final static class Events{
		public final static String CLICK="click";
	}
	
	public static final class Properties{
		public final static String HTML="html";
	}
	
	public static final class Ajax{
		public final static String GET="get";
	}
	
	public static String id(String id){
		return MessageFormat.format("$(\"#{0}\")", ObjectUtil.formatString(id));
	}
	
	public static String cls(String id){
		return MessageFormat.format("$(\".{0}\")", ObjectUtil.formatString(id));
	}
	
	public static void main(String[] args)
	{
		JQueryModel jq=new JQueryModel("ddd", JQueryModel.Events.CLICK);
		jq.appendParma("xxxx")
		.appendParma(new JsFunctionModel(new String[]{"index","date","key"})
		                   .appendContext("alert(date);"));
		System.out.println(jq.toScirpt());
	}
}
