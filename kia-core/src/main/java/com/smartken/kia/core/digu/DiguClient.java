package com.smartken.kia.core.digu;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.CharSet;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.propertyeditors.FileEditor;

import com.smartken.kia.core.util.StringUtil;

final public class DiguClient extends DefaultHttpClient {

	final public static String DIGU_API_HOME="api.minicloud.com.cn" ;
	final public static int DIGU_API_PORT=80;
	final public static String DIGU_API_SCHEME="http";
   
	
	final private HttpHost targetHost; 
	final private BasicHttpContext localcontext = new BasicHttpContext();

	public DiguClient(){
		targetHost=new HttpHost(DIGU_API_HOME, DIGU_API_PORT, DIGU_API_SCHEME);
	}
	
	public DiguClient(String user,String pwd){
		targetHost=new HttpHost(DIGU_API_HOME, DIGU_API_PORT, DIGU_API_SCHEME);
		AuthCache authCache = new BasicAuthCache();
		BasicScheme basicAuth = new BasicScheme();
	    this.getCredentialsProvider().setCredentials(
	            new AuthScope(targetHost.getHostName(), targetHost.getPort()),
	            new UsernamePasswordCredentials(user, pwd));
	    authCache.put(targetHost, basicAuth);
        localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        
	}
	

	final public String get(String url) throws MalformedChallengeException{	
		HttpGet httpGet=new HttpGet(url);
		String responseText="";
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			responseText = this.execute(targetHost, httpGet,responseHandler, localcontext);
			this.getConnectionManager().closeExpiredConnections();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return responseText;
		}	
		
	}
	
	final public String post(String url,List<NameValuePair> nvps) throws MalformedChallengeException{	
		HttpPost httpPost=new HttpPost(url);
		String responseText="";
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			responseText = this.execute(targetHost, httpPost,responseHandler, localcontext);
			this.getConnectionManager().closeExpiredConnections();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return responseText;
		}	
		
	}
	
	final public String post(String url,List<NameValuePair> nvps, Map<String, File> postFiles){
		HttpPost httpPost=new HttpPost(url);
		String responseText="";
		MultipartEntity entity = new MultipartEntity();
		
		for(NameValuePair nvp:nvps){
			try {
				String encodeVal=StringUtil.encodeUtf8(nvp.getValue());
				StringBody stringBody=new StringBody(encodeVal);
				entity.addPart(nvp.getName(),stringBody);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Iterator<String> it=postFiles.keySet().iterator();it.hasNext();){
			String key=it.next();
			File file=postFiles.get(key);
			if(!file.exists()){continue;}
			FileBody fb = new FileBody(file);
			entity.addPart(key,fb );
		}
		try {
			ResponseHandler<String> responseHandler=new BasicResponseHandler();
			
			httpPost.setEntity(entity);
			responseText = this.execute(targetHost, httpPost,responseHandler, localcontext);
			this.getConnectionManager().closeExpiredConnections();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return responseText;
		}	
	}

	
}
