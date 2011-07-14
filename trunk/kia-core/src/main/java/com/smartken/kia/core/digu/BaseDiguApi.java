package com.smartken.kia.core.digu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseDiguApi {

	
	
	final private DiguClient diguClient;
	
	public BaseDiguApi(DiguClient digu){
		this.diguClient=digu;
	}
	
	public String getString(String url){
		return diguClient.loadData(url);
	}
	
	public JSONObject getJsonObject(String url){
		String re=this.getString(url);
		try {
			JSONObject json=new JSONObject(re);
			return json;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject();
		}
	}
	
	public JSONArray getJsonArray(String url){
		String re=this.getString(url);
		try {
			JSONArray jarr=new JSONArray(re);
			return jarr;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONArray();
		}
	}
	
	public Document getXml(String url){
		String text=this.getString(url);
		try {
			Document doc=DocumentHelper.parseText(text);
			return doc;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return DocumentHelper.createDocument();
		}
		
	}
	
}
