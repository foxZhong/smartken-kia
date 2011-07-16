package com.smartken.kia.core.digu;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.propertyeditors.FileEditor;

public class DiguClient {

	final public static String DIGU_API_HOME="api.minicloud.com.cn" ;
   
	
	final private HttpHost targetHost; 
	
	final private DefaultHttpClient httpclient = new DefaultHttpClient();
	final private AuthCache authCache = new BasicAuthCache();
	final private BasicScheme basicAuth = new BasicScheme();
	final private BasicHttpContext localcontext = new BasicHttpContext();
	
    private boolean isAuth=false;
	
	public DiguClient(){
		targetHost=new HttpHost(DIGU_API_HOME, 80, "http");
	}
	
	public DiguClient(String user,String pwd){
		targetHost=new HttpHost(DIGU_API_HOME, 80, "http");
	    httpclient.getCredentialsProvider().setCredentials(
	            new AuthScope(targetHost.getHostName(), targetHost.getPort()),
	            new UsernamePasswordCredentials(user, pwd));
	    authCache.put(targetHost, basicAuth);
        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        isAuth=true;
	}
	

	final public String get(String url) throws MalformedChallengeException{	
		HttpGet httpGet=new HttpGet(url);
		String re="";
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			re = httpclient.execute(targetHost, httpGet,responseHandler, localcontext);
			httpclient.getConnectionManager().closeExpiredConnections();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return re;
		}	
		
	}
	
	final public String post(String url,List<NameValuePair> nvps) throws MalformedChallengeException{	
		HttpPost httpPost=new HttpPost(url);
		String re="";
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			re = httpclient.execute(targetHost, httpPost,responseHandler, localcontext);
			httpclient.getConnectionManager().closeExpiredConnections();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return re;
		}	
		
	}
	
	

	
}