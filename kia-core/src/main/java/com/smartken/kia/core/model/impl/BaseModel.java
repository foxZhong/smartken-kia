package com.smartken.kia.core.model.impl;


import org.apache.geronimo.mail.util.Base64Encoder;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.json.JSONException; 
import org.json.JSONObject;



import java.security.acl.LastOwnerException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import biz.source_code.base64Coder.Base64Coder;

import com.smartken.kia.core.enums.EDataFormat;
import com.smartken.kia.core.enums.EStringFormat;
import com.smartken.kia.core.model.IBaseModel;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;


import java.awt.Label;
import java.io.Serializable;
import java.lang.reflect.*;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import jxl.Cell;
import jxl.write.WritableCell;



public abstract class BaseModel implements IBaseModel ,IFormatterModel{



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
                lJsonTemp.put(lStrFieldName, this.formatObject(lObjFieldValue,EDataFormat.json));
               }catch(Exception ex){}
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
			
			//String lTempName="get"+StringUtil.format(lStrFieldName, EStringFormat.upcaseFirstChar);
			//Method lMth=c.getDeclaredMethod(lTempName, null);
			//Object lObjFieldValue=lMth.invoke(this, null);
		    Object lObjFieldValue=	eval(lStrFieldName);
			Element el=DocumentHelper.createElement(lStrFieldName);
			el.setText(this.formatObject(lObjFieldValue,EDataFormat.xml).toString());
			el.addAttribute("type", lArrField[i].getType().getSimpleName());
			root.add(el);
			}
			catch(Exception ex){}
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
		String lTempName="set"+StringUtil.format(pattern, EStringFormat.upcaseFirstChar);
		for (Class c : lAllClass) {
			try{
			Field f=c.getDeclaredField(pattern);
			Type t=f.getType();
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
				}else if(t.equals(Float.class)){
					Float fol=ObjectUtil.formatFloat(obj.toString());
					lMth.invoke(this, fol);
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
		String lTempName="get"+StringUtil.format(pattern, EStringFormat.upcaseFirstChar);
		Object lObjFieldValue=null;
		for (Class c : lAllClass) {
			try{
			Method lMth=c.getDeclaredMethod(lTempName, null);
			if(lMth==null){continue;}
			lObjFieldValue=lMth.invoke(this, null);
			isOk=true;
			}catch(Exception ex){}
		}
		if(!isOk){ throw new Exception(MessageFormat.format("This Model have not \"{0}\" 's getter", pattern));}
		return lObjFieldValue;
	}
	
	

	public void eval(Enum en, Object obj) throws Exception {
		// TODO Auto-generated method stub
		this.eval(en.name(), obj);
	}

	public Object eval(Enum en) throws Exception {
		// TODO Auto-generated method stub
		return this.eval(en.name());
	}

	
	public Object generalPK() throws NullPointerException{
		String pk="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Random r=new Random();
		int randomInt=r.nextInt(10000);
		String code=String.valueOf(randomInt);
		while(code.length()<4){
			code="0"+code;
		}
		pk=MessageFormat.format("{0}{1}", 
		   		sdf.format(new Date()),
		   		code
		);
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

	public  Enum[] enumFields() {
		// TODO Auto-generated method stub
		return new Enum[]{};
	}






	public Type type(Enum en) throws Exception {
		// TODO Auto-generated method stub
		return this.type(en.name());
	}






	public Type type(String pattern) throws Exception {
		// TODO Auto-generated method stub
		boolean isOk=false;
		ArrayList<Class> lAllClass=this.getAllClass();
		Type t=null;
		//String lTempName="set"+StringUtil.format(pattern, EStringFormat.upcaseFirstChar);
		for (Class c : lAllClass) {
			try{
			Field f=c.getDeclaredField(pattern);
			 if(f!=null){
				 t=f.getType();
				 isOk=true;
				 break;
			 }                   
			}catch(Exception ex){}
		}
		if(!isOk){ throw new Exception(MessageFormat.format("This Model have not \"{0}\" ", pattern));}
        
		return t;	
	}






	public JSONObject toJsonExclude(List listField) {
		// TODO Auto-generated method stub
		JSONObject json=this.toJson();
		for (Object f : listField) {
			if(f==null){continue;}
			String key="";
			if(f instanceof String){
				key=(String)f;
			}else if(f instanceof Enum){
				key=((Enum)f).name();
			}
			json.remove(key);
		}
		return json;
	}






	public JSONObject toJsonInclude(List listField) {
		// TODO Auto-generated method stub
		JSONObject jsonAll=this.toJson();
		JSONObject jsonRe=new JSONObject();
		for (Object f : listField) {
			if(f==null){continue;}
			String key="";
			if(f instanceof String){
				key=(String)f;
			}else if(f instanceof Enum){
				key=((Enum)f).name();
			}
			try {
				jsonRe.append(key, jsonAll.get(key));
			} catch (JSONException e) {}
		}
		return jsonRe;
	}



   public List<Cell> toExcelRow(List<String> fields,int rowIndex,int cellIndex){
	   List<Cell> listCell=new ArrayList<Cell>();
       for(int i=0;i<fields.size();i++){
    	   String field=fields.get(i);
    	   try {
			Type type=this.type(field);
		    
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
	   return listCell;
   }






   public BSONObject toBson() {
	// TODO Auto-generated method stub
	BSONObject bson=new BasicBSONObject();
	ArrayList<Class> lAllClass=this.getAllClass();
	for (Class c : lAllClass) {
		Field[] lArrField=c.getDeclaredFields();
		for (int i=0;i<lArrField.length;i++) {
			String lStrFieldName=lArrField[i].getName();
            try{
            Object lObjFieldValue=eval(lStrFieldName);
            bson.put(lStrFieldName, this.formatObject(lObjFieldValue,EDataFormat.bson));
           }catch(Exception ex){}
		}
	}
	return bson;
   }

   final private Object formatObject(Object obj,EDataFormat dfe){
	   Object reObj="";
       try{
           if(obj==null){
        	   reObj="";
           }else if(obj instanceof String
           		||obj instanceof Number||dfe.equals(EDataFormat.bson)){
        	   reObj=obj;
           }
           else if(obj instanceof Date ){
				Date d=(Date)obj;
				reObj=DateTimeUtil.format(d, DateTimeUtil.DATE_FORMAT_DB);
			}else if( obj instanceof Timestamp){
			   Timestamp t=(Timestamp)obj;
			   reObj=DateTimeUtil.format(t, DateTimeUtil.DATE_TIME_FORMAT_DB);
			}else if(obj instanceof byte[]){
				reObj=Base64Coder.encodeLines((byte[])obj);
			}
			else if(obj instanceof IFormatterModel)
			{
				switch(dfe){
				case json:reObj=((IFormatterModel)obj).toJson().toString();break;
				case xml:reObj=((IFormatterModel)obj).toXmlElement().toString();break;
				case bson:reObj=((IFormatterModel)obj).toBson().toString();break;

				}
			}
			else{
				reObj=obj;
			}
            return reObj;
	   }catch(Exception ex){
		   return "";
	   }
   }
	
}
