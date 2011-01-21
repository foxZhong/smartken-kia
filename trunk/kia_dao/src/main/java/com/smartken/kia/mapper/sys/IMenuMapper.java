package com.smartken.kia.mapper.sys;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.ibatis.type.MappedTypes;

import com.smartken.kia.util.model.IMapper;


public interface IMenuMapper<T> extends IMapper<T> {

	
	public ArrayList selectInToken(ArrayList<String> lListToken);
}
