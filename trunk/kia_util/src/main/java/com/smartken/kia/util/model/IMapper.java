package com.smartken.kia.util.model;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.smartken.kia.util.page.PageBounds;
import com.smartken.kia.util.page.Paginator;

public interface IMapper<T>{

	public T selectEqPk(Object pObjPk) throws Exception;
	public ArrayList<T> selectAll() throws Exception;
	public ArrayList<T> selectAll(PageBounds page) throws Exception;
	public ArrayList<T> selectLike(String pStrLike) throws Exception;
	public ArrayList<T> selectLike(String pStrLike,PageBounds page) throws Exception;
	public ArrayList<T> selectInPk(ArrayList pArrPk) throws Exception;
	public ArrayList<T> selectInPk(ArrayList pArrPk,PageBounds page) throws Exception;
	public ArrayList<T> selectNotInPk(ArrayList pArrPk) throws Exception;
	public ArrayList<T> selectNotInPk(ArrayList pArrPk,PageBounds page) throws Exception;
	public int updateOne(T obj) throws Exception;
	public int insertOne(T obj) throws Exception;
	public int deleteInPk(ArrayList pArrPk) throws Exception;
	public int deleteNotInPk(ArrayList pArrPk) throws Exception;
	public int count() throws Exception;
	
}
