package com.smartken.kia.core.model.impl;

import java.text.MessageFormat;
import java.util.Iterator;

import com.smartken.kia.core.model.IScriptModel;
import com.smartken.kia.core.util.ObjectUtil;

public class JsFunctionModel implements IScriptModel {

	private StringBuffer parmas=new StringBuffer("");
	private StringBuffer context=new StringBuffer("");
	private String funName="";
	
	public JsFunctionModel(String[] parmas){

		if (parmas!=null){
			for(int i=0;i<parmas.length;i++)
			{
				this.parmas.append(parmas[i]);
				if(i!=parmas.length-1)
				{
					this.parmas.append(",");
				}
			}
		}
	}
	
	public JsFunctionModel(String funName, String[] parmas){

		if (parmas!=null){
			for(int i=0;i<parmas.length;i++)
			{
				this.parmas.append(parmas[i]);
				if(i!=parmas.length-1)
				{
					this.parmas.append(",");
				}
			}
		}
		this.funName=ObjectUtil.formatString(funName);
	}
	
	public String toScirpt() {
		// TODO Auto-generated method stub
		String lStrRege="function {0}({1})'{' \n  {2}  '}'";
		String lStrReturn=MessageFormat.format(lStrRege,
				          this.funName,  //0
		                  this.parmas.toString(),  //1
		                  this.context.toString()  //2
		);
		return lStrReturn;
	}
	
	public JsFunctionModel appendContext(String pContext)
	{
		this.context.append(pContext).append("\n");
		return this;
	}
	
	public JsFunctionModel appendContext(IScriptModel pContext)
	{
		this.context.append(pContext.toScirpt()).append("\n");
		return this;
	}
	

	
	
	
	public String getFunName() {
		return funName;
	}
	
	
	public static String iframe(String url)
	{
		return "<iframe scrolling='no' frameborder='0' src='"+url+"' style='width:100%;height:100%;overflow:hidden;'></iframe>";
	}
	
	

	public static void main(String[] args)
	{
		JsFunctionModel js=new JsFunctionModel(new String[]{"index","data"});
		js.appendContext("var e=2;").appendContext("var xxx=e;");
		System.out.println(js.toScirpt());
	}

}
