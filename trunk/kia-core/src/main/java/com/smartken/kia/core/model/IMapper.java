package com.smartken.kia.core.model;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.Paginator;

public interface IMapper<T>{

	public T selectEqPk(Object pObjPk) throws Exception;
	public List<T> select(@Param("model") T pModel) throws Exception;
	public List<T> select(@Param("model") T pModel,PageBounds page) throws Exception;
	public List<T> selectUnion(List<T> querys) throws Exception;
	public List<T> selectUnion(List<T> querys,PageBounds page) throws Exception;
	public List<T> selectAll() throws Exception;
	public List<T> selectAll(PageBounds page) throws Exception;
	public List<T> selectInPk(List pArrPk) throws Exception;
	public List<T> selectInPk(List pArrPk,PageBounds page) throws Exception;
	public List<T> selectNotInPk(List pArrPk) throws Exception;
	public List<T> selectNotInPk(List pArrPk,PageBounds page) throws Exception;
	public List<T> selectView(@Param("model") T pModel) throws Exception;
	public List<T> selectView(@Param("model") T pModel,PageBounds page) throws Exception;
	public List<T> selectViewUnion(List<T> querys) throws Exception;
	public List<T> selectViewUnion(List<T> querys,PageBounds page) throws Exception;
	public List<T> selectViewAll() throws Exception;
	public List<T> selectViewAll(PageBounds page) throws Exception;
	public List<T> selectViewInPk(List pArrPk) throws Exception;
	public List<T> selectViewInPk(List pArrPk,PageBounds page) throws Exception;
	public List<T> selectViewNotInPk(List pArrPk) throws Exception;
	public List<T> selectViewNotInPk(List pArrPk,PageBounds page) throws Exception;
	public int updateOne(@Param("model")T obj) throws Exception;
	public int updateOne(@Param("model")T obj,@Param("pk")Object newPk) throws Exception;
	public int insertOne(T obj) throws Exception;
	public int deleteEqPk(Object pObjPk) throws Exception;
	public int deleteInPk(List pArrPk) throws Exception;
	public int deleteNotInPk(List pArrPk) throws Exception;
	public int count() throws Exception;
	
}
