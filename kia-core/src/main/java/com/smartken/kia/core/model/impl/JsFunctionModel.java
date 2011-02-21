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
	
	public JsFunctionModel appendContext(String pattern,Object...arguments){
		this.context.append(MessageFormat.format(pattern, arguments));
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
	    js.appendContext("{0}.combotree(\"{1}\",'');\n{0}.combotree(\"{2}\",\"{3}\"+newVal);",
                  JQueryModel.id("xxx")  //0
                  ,EasyUiModel.ComboBox.Methods.SET_VALUE  //1
                  ,EasyUiModel.ComboBox.Methods.RELOAD //2
                  ,"/select/menuDir.action?pid="
                  );
		System.out.println(js.toScirpt());
	}

}
