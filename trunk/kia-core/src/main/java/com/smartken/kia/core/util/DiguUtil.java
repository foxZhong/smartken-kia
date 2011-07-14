package com.smartken.kia.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.mail.internet.PreencodedMimeBodyPart;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DiguUtil {

	final public static String DIGU_API_HOME="api.minicloud.com.cn" ;
	
	public static void main(String[] args){
		try {
			URL url=new URL("http://"+DIGU_API_HOME+"/statuses/public_timeline.json");
			HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
			
			urlConnection.setDoOutput(false);
			//OutputStream os= urlConnection.getOutputStream();
			//os.close();
			 InputStream is=urlConnection.getInputStream();
		    BufferedReader l_reader = new BufferedReader(new InputStreamReader(is));   
		    String sCurrentLine="";
		    StringBuffer sbr=new StringBuffer("");
		        while ((sCurrentLine = l_reader.readLine()) != null) {   
		        	sbr.append(sCurrentLine );   
		  
		        }   

			 System.out.println(sbr.toString());
			 
			 HttpHost targetHost = new HttpHost(DIGU_API_HOME, 80, "http");
			 
			 DefaultHttpClient httpclient = new DefaultHttpClient(); 
			 HttpGet httpGet=new HttpGet("/statuses/friends_timeline.json");
			 
	         httpclient.getCredentialsProvider().setCredentials(
	                    new AuthScope(targetHost.getHostName(), targetHost.getPort()),
	                    new UsernamePasswordCredentials("smartken", "chipchina"));

	            // Create AuthCache instance
	        AuthCache authCache = new BasicAuthCache();
	            // Generate BASIC scheme object and add it to the local
	            // auth cache
	            BasicScheme basicAuth = new BasicScheme();
	            authCache.put(targetHost, basicAuth);

	            // Add AuthCache to the execution context
	            BasicHttpContext localcontext = new BasicHttpContext();
	            localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
			 
			 ResponseHandler<String> responseHandler=new BasicResponseHandler();
			 
			 //String str=httpclient.execute(httpGet, responseHandler,localcontext);
			 //System.out.println(str.toString());
	          
	            String re = httpclient.execute(targetHost, httpGet,responseHandler, localcontext);
	            
//	            HttpEntity httpEntity= response.getEntity();
//	            InputStream iss= httpEntity.getContent();
//	            BufferedReader br = new BufferedReader(new InputStreamReader(iss)); 
//			    StringBuffer sbr2=new StringBuffer("");
//		        while ((sCurrentLine = br.readLine()) != null) {   
//		        	sbr2.append(sCurrentLine );   
//		  
//		        }   

			 System.out.println(re.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
