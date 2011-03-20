package com.smartken.kia.core.model.impl;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.json.JSONException; 
import org.json.JSONObject;



import com.smartken.kia.core.enums.StringFormatEnum;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;


import java.io.Serializable;
import java.lang.reflect.*;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
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
                Object lObjFieldValue=eval(lStrFieldName);
				if(lObjFieldValue instanceof IFormatterModel)
				{
					lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":((IFormatterModel)lObjFieldValue).toJson());
				}else{
				   lJsonTemp.put(lStrFieldName, lObjFieldValue==null?"":lObjFieldValue);
				}
				}catch(Exception ex){
					try{
						String lStrTempName="get"+lStrFieldName;
						Object lObjFieldValue=eval(lStrFieldName);
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
			
			//String lTempName="get"+StringUtil.format(lStrFieldName, StringFormatEnum.upcaseFirstChar);
			//Method lMth=c.getDeclaredMethod(lTempName, null);
			//Object lObjFieldValue=lMth.invoke(this, null);
		    Object lObjFieldValue=	eval(lStrFieldName);
			Element el=DocumentHelper.createElement(lStrFieldName);
			el.setText(lObjFieldValue==null?"":lObjFieldValue.toString());
			el.addAttribute("type", lArrField[i].getType().getSimpleName());
			root.add(el);
			}
			catch(Exception ex)
			{
				try{
			    //String lTempName="get"+lStrFieldName;
				//Method lMth=c.getDeclaredMethod(lTempName, null);
				//Object lObjFieldValue=lMth.invoke(this, null);
				Object lObjFieldValue=	eval(lStrFieldName);
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

	
	
	
	public String toCsv(String[] fields) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void from(Element el) {
		// TODO Auto-generated method stub
		
	}

	public void from(JSONObject json) {
		// TODO Auto-generated method stub
		for(Iterator<String> it=json.keys();it.hasNext();){
			String key=it.next();
			try {
				this.eval(key, json.get(key));
			} catch (Exception e) {}
		}
	}

	public void eval(String pattern, Object obj) throws Exception {
		// TODO Auto-generated method stub
		boolean isOk=false;
		ArrayList<Class> lAllClass=this.getAllClass();
		String lTempName="set"+StringUtil.format(pattern, StringFormatEnum.upcaseFirstChar);
		for (Class c : lAllClass) {
			try{
			Field f=c.getDeclaredField(pattern);
			Class t=f.getType();
			Method lMth=c.getDeclaredMethod(lTempName, f.getType());
			if(obj instanceof String && !t.equals(String.class)){
				if(t.equals(Date.class))
				{Date d=DateTimeUtil.parse(obj.toString());
				lMth.invoke(this, d);
				}else if(t.equals(Double.class))
				{
				  Double d=ObjectUtil.formatDouble(obj.toString());
				  lMth.invoke(this, d);
				}else if(t.equals(Integer.class)){
					Integer i=ObjectUtil.formatInt(obj.toString());
					lMth.invoke(this, i);
				}
			}else{
			lMth.invoke(this,obj);
			}
			if(lMth!=null){isOk=true;break;}
			}catch(Exception ex){}
		}
		if(!isOk){ throw new Exception(MessageFormat.format("This Model have not \"{0}\" setter({1})", pattern,obj.getClass().getName()));}
	}

	public Object eval(String pattern) throws Exception{
		// TODO Auto-generated method stub
		boolean isOk=false;
		ArrayList<Class> lAllClass=this.getAllClass();
		String lTempName="get"+StringUtil.format(pattern, StringFormatEnum.upcaseFirstChar);
		Object lObjFieldValue=null;
		for (Class c : lAllClass) {
			try{
			Method lMth=c.getDeclaredMethod(lTempName, null);
			lObjFieldValue=lMth.invoke(this, null);
			if(lMth!=null){isOk=true;break;}
			}catch(Exception ex){}
		}
		if(!isOk){ throw new Exception(MessageFormat.format("This Model have not \"{0}\" 's getter", pattern));}
		return lObjFieldValue;
	}
	
	

	public void eval(Enum en, Object obj) throws Exception {
		// TODO Auto-generated method stub
		this.eval(en.toString(), obj);
	}

	public Object eval(Enum en) throws Exception {
		// TODO Auto-generated method stub
		return this.eval(en.toString());
	}

	
	public  Object generalPK() throws NullPointerException{
		return pk;
	}
	
	public  boolean validate() throws Exception{
		return true;
	}
	
	public Object clone(){
		Object obj=null;
		try {
			obj= org.apache.commons.beanutils.BeanUtils.cloneBean(this);
		} catch (Exception e) {}
		finally{return obj;}

	}

}
