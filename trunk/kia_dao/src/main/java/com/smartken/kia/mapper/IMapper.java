package com.smartken.kia.mapper;

import java.util.ArrayList;

public interface IMapper<T>{

	public T selectEqPk(Object pObjPk) throws Exception;
	public ArrayList selectAll() throws Exception;
	public ArrayList selectLikePk(String pStrLike) throws Exception;
	public ArrayList selectInPk(ArrayList pArrPk) throws Exception;
	public ArrayList selectNotInPk(ArrayList pArrPk) throws Exception;
	public int updateOne(T obj) throws Exception;
	public int insertOne(T obj) throws Exception;
	public int deleteInPk(ArrayList pArrPk) throws Exception;
	public int deleteNotInPk(ArrayList pArrPk) throws Exception;
	
}
