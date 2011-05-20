package com.smartken.kia.core.model;

import java.io.Serializable;
import java.lang.reflect.Type;

public interface IBaseModel extends Serializable {

	 public Object eval(Enum en) throws Exception;
	 public Object eval(String pattern) throws Exception;
	 public void eval(Enum en,Object obj) throws Exception;
	 public void eval(String pattern,Object obj) throws Exception;
	 
	 public Type type(Enum en) throws Exception;
	 public Type type(String pattern) throws Exception ;
	
	 public Enum[] enumFields();
}
