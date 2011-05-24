package com.smartken.kia.core.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IFormatterModel {
  
	 public JSONObject toJson();
	 public JSONObject toJsonInclude(List listField);
	 public JSONObject toJsonExclude(List listField);
	
	 public Document toXmlDocucmnt();
	 public Element toXmlElement();
	 public String toUrlParam();
     public String toCsv(String[] fields);
	 
	 public void from(JSONObject json) throws Exception;
	 public void from(Element el) throws Exception;
	 

	 
	
}
