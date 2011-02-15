package com.smartken.kia.core.model.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.smartken.kia.core.model.IScriptModel;

public class JsContextModel implements IScriptModel {

	private ArrayList<String> scripts;
	
	public JsContextModel(){
		scripts=new ArrayList<String>();
	}
	
	public JsContextModel(ArrayList<String> scripts){
		if(scripts==null)
		{
			this.scripts=new ArrayList<String>();
		}else
			this.scripts=scripts;
	}
	
	public JsContextModel appendScript(Object script)
	{
		if(script==null) return this;
		if(script instanceof IScriptModel)
		{
			this.scripts.add(((IScriptModel) script).toScirpt());
		}else
		{
			this.scripts.add(script.toString());
		}
		return this;
	}
	
	public String toScirpt() {
		// TODO Auto-generated method stub
		StringBuffer lSbrScript=new StringBuffer("");
		for(Iterator<String> it=scripts.iterator();it.hasNext();)
		{
			String tempScript=it.next();
			String script=MessageFormat.format("\n\t{0}\n", tempScript);
		    lSbrScript.append(script);
		}
		return lSbrScript.toString();
	}

}
