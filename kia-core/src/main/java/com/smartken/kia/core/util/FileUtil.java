package com.smartken.kia.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.mail.URLName;

import com.smartken.kia.core.model.impl.JsMapModel;



public class FileUtil {

	
	public static URL getClassPath(Class c){
		return c.getClassLoader().getResource("");
	}
	
	public static String toPath(Class c){
		String cls=c.getName();
		cls=cls.substring(0,cls.lastIndexOf("."));
	   return cls.replace(".", "/");	
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
	
	public static boolean saveFile(String path,byte[] bytes) throws IOException{
		File file=new File(path);
		FileOutputStream fos=null;
		if(!file.exists()){
			file.createNewFile();
		}else if(!file.isFile()){
			return false;
		}
	    fos=new FileOutputStream(file);
		fos.write(bytes);
		fos.flush();
		fos.close();
        return true;
	}
	
	
	public static byte[]  toBytes(String path) throws IOException{
		File file=new File(path);
        return toBytes(file);
	}
	
	public static byte[]  toBytes(File file) throws IOException{
		if(!file.exists()||!file.isFile())	throw new IOException();
		FileInputStream fis=new FileInputStream(file);
		byte[] bytes=new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		return bytes;
	}
	
}
