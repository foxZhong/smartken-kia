package com.smartken.kia.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.beans.FeatureDescriptor;
import java.io.Serializable;
import java.lang.reflect.*;

public abstract class BaseModel implements Serializable {

	public JSONObject toJson()
	{
		JSONObject lJsonTemp=new JSONObject();
		try{
			Field[] lArrField=this.getClass().getDeclaredFields();
			for(int i=0;i<lArrField.length;i++)
			{
				String lStrFieldName=lArrField[i].getName();
				lStrFieldName="get"+lStrFieldName.substring(0, 1).toUpperCase()+lStrFieldName.substring(1);
				Method lMth=this.getClass().getDeclaredMethod(lStrFieldName, null);
				String lStrFieldValue=lMth.invoke(this, null).toString();
				lJsonTemp.put(lArrField[i].getName(), lStrFieldValue);
			}
			
		}catch(JSONException je)
		{
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException ne)
		{
			
		}
		return lJsonTemp;
	}
}
