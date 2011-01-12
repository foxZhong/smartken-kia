package com.smartken.kia.mapper.sys;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.ibatis.type.MappedTypes;

import com.smartken.kia.mapper.IMapper;


public interface IMenuMapper extends IMapper {

	
	public ArrayList selectInToken(ArrayList<String> lListToken);
}
