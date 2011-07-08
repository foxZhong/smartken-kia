package com.smartken.kia.core.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DiguUtil {

	
	public static void main(String[] args){
		try {
			URL url=new URL("http://api.minicloud.com.cn");
			URLConnection urlConnection=url.openConnection();
			urlConnection.getOutputStream();
			urlConnection.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
