package com.smartken.kia.core.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import javax.naming.LimitExceededException;

import junit.framework.TestCase;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




import com.smartken.kia.core.model.IMapper;
import com.smartken.kia.core.pager.PageBounds;


public class IMapperTestCase<T>  implements IMapper<T> {

	 private SqlSession se=null;
	 private IMapper<T> mapper;
	
	public IMapperTestCase (SqlSessionFactory sf,Class<? extends IMapper> cls){
			se=sf.openSession();
	        mapper=se.getMapper(cls);

	}

	
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.count(); 
	}


	public int deleteEqPk(Object pObjPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.deleteEqPk(pObjPk);
	}


	public int deleteInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.deleteInPk(pArrPk);
	}


	public int deleteNotInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.deleteNotInPk(pArrPk);
	}


	public int insertOne(T obj) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.insertOne(obj);
	}


	public ArrayList<T> select(T pModel) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.select(pModel);
	}


	public ArrayList<T> select(T pModel, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.select(pModel, page);
	}


	public ArrayList<T> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectAll();
	}


	public ArrayList<T> selectAll(PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectAll(page);
	}


	public T selectEqPk(Object pObjPk) throws Exception {
		// TODO Auto-generated method stub
		return (T) this.mapper.selectEqPk(pObjPk);
	}


	public ArrayList<T> selectInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk);
	}

	public ArrayList<T> selectInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk, page);
	}

	public ArrayList<T> selectNotInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectNotInPk(pArrPk);
	}

	public ArrayList<T> selectNotInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk, page);
	}

	public ArrayList<T> selectUnion(ArrayList<T> querys) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectUnion(querys);
	}

	public ArrayList<T> selectView(T pModel) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectView(pModel);
	}

	public ArrayList<T> selectView(T pModel, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectView(pModel, page);
	}

	public ArrayList<T> selectViewAll() throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewAll();
	}

	public ArrayList<T> selectViewAll(PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewAll(page);
	}

	public ArrayList<T> selectViewInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewInPk(pArrPk);
	}

	public ArrayList<T> selectViewInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewInPk(pArrPk, page);
	}

	public ArrayList<T> selectViewNotInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewNotInPk(pArrPk);
	}

	public ArrayList<T> selectViewNotInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewNotInPk(pArrPk, page);
	}

	public ArrayList<T> selectViewUnion(ArrayList<T> querys) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewUnion(querys);
	}

	public int updateOne(T obj) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.updateOne(obj);
	}

	public int updateOne(T obj, Object newPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.updateOne(obj, newPk);
	}
	

}
