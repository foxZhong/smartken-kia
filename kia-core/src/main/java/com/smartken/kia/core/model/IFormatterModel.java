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
	 
	 public void from(JSONObject json);
	 public void from(Element el);
}
