package com.smartken.kia.core.model.impl;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.json.JSONObject;


import com.smartken.kia.core.enums.FormatEnum;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.util.StringUtil;


import java.io.Serializable;
import java.lang.reflect.*;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;



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
			    String lStrTempName="get"+StringUtil.format(lStrFieldName, FormatEnum.UPCASE_FIRST);
				Method lMth=c.getDeclaredMethod(lStrTempName, null);
				Object lObjFieldValue=lMth.invoke(this, null);
				if(lObjFieldValue instanceof IFormatterModel)
				{
					lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":((IFormatterModel)lObjFieldValue).toJson());
				}else{
				   lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":lObjFieldValue);
				}
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
			
			String lTempName="get"+StringUtil.format(lStrFieldName, FormatEnum.UPCASE_FIRST);
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
	

	public String toUrlParam() {
		// TODO Auto-generated method stub
		JSONObject json=this.toJson();
		StringBuffer lSbrParam=new StringBuffer("");
		
		for(Iterator it=json.keys();it.hasNext();){
			String key=it.next().toString();
			String pattern="{0}={1}";
			try{
			lSbrParam.append(
					 MessageFormat.format(pattern, 
							 key
							 ,URLEncoder.encode((String) json.get(key), "UTF-8") )
			);
			if(it.hasNext()){
				lSbrParam.append("&");
			}
			}catch(Exception ex){}
		}
		
		return lSbrParam.toString();
	}

	
	
	
	public void from(Element el) {
		// TODO Auto-generated method stub
		
	}

	public void from(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public boolean eval(String pattern, Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object eval(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract Object generalPK() throws NullPointerException;
	
}
