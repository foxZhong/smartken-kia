package com.smartken.kia.mapper;

import java.util.ArrayList;

public interface IMapper {

	public Object selectOne(Object pObjId);
	public ArrayList selectAll();
	public ArrayList selectCondition(String pStrCondition);
	public int updateOne(Object obj);
	public int insertOne(Object obj);
	public int deleteOne(Object pObjPrimaryKey);
}
