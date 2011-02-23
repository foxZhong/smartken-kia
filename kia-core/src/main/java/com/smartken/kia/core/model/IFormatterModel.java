package com.smartken.kia.core.model;

import org.dom4j.Document;
import org.dom4j.Element;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IFormatterModel {
  
	 public JSONObject toJson();	 
	 public Document toXmlDocucmnt();
	 public Element toXmlElement();
	 public String toUrlParam();
	 
	 public void from(JSONObject json) throws Exception;
	 public void from(Element el) throws Exception;
	 
	 public Object eval(Enum en) throws Exception;
	 public Object eval(String pattern) throws Exception;
	 public void eval(Enum en,Object obj) throws Exception;
	 public void eval(String pattern,Object obj) throws Exception;
}
