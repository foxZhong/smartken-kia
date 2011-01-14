package com.smartken.kia.util.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.lang.reflect.*;

public abstract class BaseModel implements Serializable ,IJsonModel{

	
	
	public JSONObject toJson()
	{
		JSONObject lJsonTemp=new JSONObject();
		
			Field[] lArrField=this.getClass().getDeclaredFields();
			for(int i=0;i<lArrField.length;i++)
			{
				try{
				String lStrFieldName=lArrField[i].getName();
				lStrFieldName="get"+lStrFieldName.substring(0, 1).toUpperCase()+lStrFieldName.substring(1);
				Method lMth=this.getClass().getDeclaredMethod(lStrFieldName, null);
				String lStrFieldValue=lMth.invoke(this, null).toString();
				lJsonTemp.put(lArrField[i].getName(), lStrFieldValue);
				}catch(Exception ex)
				{}
			}
			
		
		return lJsonTemp;
	}
	
	
}
