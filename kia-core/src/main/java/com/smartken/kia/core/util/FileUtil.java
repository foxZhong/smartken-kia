package com.smartken.kia.core.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.mail.URLName;



public class FileUtil {

	
	public static URL getClassPath(Class c){
		return c.getClassLoader().getResource("");
	}
	
	public static URL getParentDir(URL url) throws MalformedURLException{
		return getParentDir(url,1);
	}
	
	public static URL getParentDir(URL url,int level) throws MalformedURLException{
		if(url==null)return url;
		String parentPath=url.getPath();
		for(int i=0;i<level;i++){
			File f=new File(parentPath);
			parentPath=f.getParent();
		}
		URL parentUrl=new URL(url.getProtocol(), url.getHost(), parentPath);
		return parentUrl;
	}
	
	public static URL getParentDir(URL url,String parent) throws MalformedURLException{
		if(url==null)return url;
		String parentPath=url.getPath();
		File f=new File(parentPath);
		while(f.getParentFile()!=null){
			f=f.getParentFile();
			if(f.getName().equals(parent))
				break;
		}	
		parentPath=f.getPath();
		URL parentUrl=new URL(url.getProtocol(), url.getHost(), parentPath);
		return parentUrl;
	}
	
}
