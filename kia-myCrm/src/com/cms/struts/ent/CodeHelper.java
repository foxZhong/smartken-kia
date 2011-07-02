package com.cms.struts.ent;

import java.io.UnsupportedEncodingException;

public class CodeHelper {
	
	public static String toGB2312(String oldstr)
	{   String newstr=null;
		try {
			byte[] bs=oldstr.getBytes("ISO-8859-1");
			newstr=new String(bs,"gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newstr;	
	}
}
