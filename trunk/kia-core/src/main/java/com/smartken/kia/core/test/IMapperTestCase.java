package com.smartken.kia.core.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

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


	public List<T> select(T pModel) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.select(pModel);
	}


	public List<T> select(T pModel, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.select(pModel, page);
	}


	public List<T> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectAll();
	}


	public List<T> selectAll(PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectAll(page);
	}


	public T selectEqPk(Object pObjPk) throws Exception {
		// TODO Auto-generated method stub
		return (T) this.mapper.selectEqPk(pObjPk);
	}


	public List<T> selectInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk);
	}

	public List<T> selectInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk, page);
	}

	public List<T> selectNotInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectNotInPk(pArrPk);
	}

	public List<T> selectNotInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectInPk(pArrPk, page);
	}

	public List<T> selectUnion(List<T> querys) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectUnion(querys);
	}

	public List<T> selectView(T pModel) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectView(pModel);
	}

	public List<T> selectView(T pModel, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectView(pModel, page);
	}

	public List<T> selectViewAll() throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewAll();
	}

	public List<T> selectViewAll(PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewAll(page);
	}

	public List<T> selectViewInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewInPk(pArrPk);
	}

	public List<T> selectViewInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewInPk(pArrPk, page);
	}

	public List<T> selectViewNotInPk(ArrayList pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewNotInPk(pArrPk);
	}

	public List<T> selectViewNotInPk(ArrayList pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewNotInPk(pArrPk, page);
	}

	public List<T> selectViewUnion(List<T> querys) throws Exception {
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


	public List<T> selectUnion(List<T> querys, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectUnion(querys, page);
	}


	public List<T> selectViewUnion(List<T> querys, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.selectViewUnion(querys,page);
	}


	public int deleteInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteNotInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<T> selectInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectInPk(List pArrPk, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectNotInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectNotInPk(List pArrPk, PageBounds page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectViewInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectViewInPk(List pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectViewNotInPk(List pArrPk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<T> selectViewNotInPk(List pArrPk, PageBounds page)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
