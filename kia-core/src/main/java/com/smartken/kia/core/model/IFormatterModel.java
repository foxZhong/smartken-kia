package com.smartken.kia.core.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.dom4j.Document;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IFormatterModel {
  
	 //将实体类转换为json对象
	 public JSONObject toJson();
	 
	 /**
	  * 
	  * @param listField
	  * @return
	  */
	 public JSONObject toJsonInclude(List listField);
	 
	 /**
	  * 
	  * @param listField
	  * @return
	  */
	 public JSONObject toJsonExclude(List listField);
	 
	 /**
	  * @param 
	  * @return
	  */
	 public BSONObject toBson();
	
	 /**
	  * 
	  * @return
	  */
	 public Document toXmlDocucmnt();
	 
	 /**
	  * 
	  * @return
	  */
	 public Element toXmlElement();
	 
	 /**
	  * 
	  * @return
	  */
	 public String toUrlParam();
	 
	 /**
	  * 
	  * @param fields
	  * @return
	  */
     public String toCsv(String[] fields);
	 
     /**
      * 
      * @param json
      * @throws Exception
      */
	 public void from(JSONObject json) throws Exception;
	 
	 /**
	  * @author smartken
	  * @param el  dom4j的Element对象
	  * @throws Exception
	  */
	 public void from(Element el) throws Exception;
	 

	 
	
}
