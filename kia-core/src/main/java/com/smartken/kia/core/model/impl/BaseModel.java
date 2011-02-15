package com.smartken.kia.core.model.impl;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.json.JSONObject;


import com.smartken.kia.core.model.IFormatterModel;


import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;



public abstract class BaseModel implements Serializable ,IFormatterModel{

	private String pk;
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public JSONObject toJson()
	{
		JSONObject lJsonTemp=new JSONObject();
		ArrayList<Class> lAllClass=this.getAllClass();
		for (Class c : lAllClass) {
			Field[] lArrField=c.getDeclaredFields();
			for (int i=0;i<lArrField.length;i++) {
				String lStrFieldName=lArrField[i].getName();
                try{
			    String lStrTempName="get"+lStrFieldName.substring(0, 1).toUpperCase()+lStrFieldName.substring(1);
				Method lMth=c.getDeclaredMethod(lStrTempName, null);
				Object lObjFieldValue=lMth.invoke(this, null);
				lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":lObjFieldValue);
				}catch(Exception ex){
					try{
						String lStrTempName="get"+lStrFieldName;
						Method lMth=c.getDeclaredMethod(lStrFieldName, null);
						Object lObjFieldValue=lMth.invoke(this, null);
						lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":lObjFieldValue);
					}catch (Exception exx){}
				}
			}
		}

		return lJsonTemp;
	}
	
	
	
	


	public Document toXmlDocucmnt() {
		// TODO Auto-generated method stub
		Document doc=DocumentHelper.createDocument();
		doc.add(this.toXmlElement());
		return doc;
	}

	public Element toXmlElement() {
		// TODO Auto-generated method stub
		Element root=DocumentHelper.createElement(this.getClass().getSimpleName());
		//root.addAttribute("key", this.generalPK().toString());
		ArrayList<Class> lAllClass=this.getAllClass();
		for (Class c : lAllClass) {
		Field[] lArrField=c.getDeclaredFields();
		for(int i=0;i<lArrField.length;i++)
		{
			String lStrFieldName=lArrField[i].getName();
			try{
			
			String lTempName="get"+lStrFieldName.substring(0, 1).toUpperCase()+lStrFieldName.substring(1);
			Method lMth=c.getDeclaredMethod(lTempName, null);
			Object lObjFieldValue=lMth.invoke(this, null);
			Element el=DocumentHelper.createElement(lStrFieldName);
			el.setText(lObjFieldValue==null?"":lObjFieldValue.toString());
			el.addAttribute("type", lArrField[i].getType().getSimpleName());
			root.add(el);
			}
			catch(Exception ex)
			{
				try{
			    String lTempName="get"+lStrFieldName;
				Method lMth=c.getDeclaredMethod(lTempName, null);
				Object lObjFieldValue=lMth.invoke(this, null);
				Element el=DocumentHelper.createElement(lStrFieldName);
				el.setData(lObjFieldValue==null?"":lObjFieldValue);
				el.addAttribute("type", lArrField[i].getType().getSimpleName());
				root.add(el);
				}catch (Exception exx){}
			}
		}
		}
		return root;
	}
	
	private ArrayList<Class> getAllClass(){
		return getAllClass(this.getClass());
	}
	
	private ArrayList<Class> getAllClass(Class c){
		ArrayList<Class> lClassReturn=new ArrayList<Class>();
		lClassReturn.add(c);
		if(!c.getSuperclass().equals(Object.class)){
			lClassReturn.addAll(this.getAllClass(c.getSuperclass()));
		}	
		return lClassReturn;
	}
	

	public abstract Object generalPK() throws NullPointerException;
	
}
