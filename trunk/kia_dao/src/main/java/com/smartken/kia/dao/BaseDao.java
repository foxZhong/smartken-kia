package com.smartken.kia.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class BaseDao {
	
	private SqlSessionFactory _SqlSessionFactory;


	public BaseDao()
	{
		
		String resource ="mybatis3-local.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			_SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public SqlSession openSqlSession()
	{
		return _SqlSessionFactory.openSession();
	}
	
	public void closeSqlSession(SqlSession pSession)
	{
	   if(pSession==null)
		   return;
	   pSession.close();
	}
}
