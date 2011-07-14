package com.smartken.kia.core.digu;

import java.io.IOException;

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
	

	final public String loadData(String url){	
		HttpGet httpGet=new HttpGet(url);
		String re="";
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			re = httpclient.execute(targetHost, httpGet,responseHandler, localcontext);
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
