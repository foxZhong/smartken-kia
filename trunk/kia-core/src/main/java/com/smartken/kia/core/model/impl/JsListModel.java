package com.smartken.kia.core.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.model.IScriptModel;

public class JsListModel<E> extends ArrayList<E> implements IScriptModel {

	
	

	public String toScirpt() {
		// TODO Auto-generated method stub
		StringBuffer lSbrReturn=new StringBuffer("");
		lSbrReturn.append("[ \n");
        for(Iterator it=this.iterator();it.hasNext();){
			Object tempObj=it.next();
        	if((tempObj instanceof JsMapModel) ||( tempObj instanceof JsListModel) )
			{
			  lSbrReturn.append(((IScriptModel)tempObj).toScirpt()).append("\n");
			}

        	if(it.hasNext())
        	{
        		lSbrReturn.append(", \n");
        	}
		}
		lSbrReturn.append("] \n");
		return lSbrReturn.toString();
	}

}
