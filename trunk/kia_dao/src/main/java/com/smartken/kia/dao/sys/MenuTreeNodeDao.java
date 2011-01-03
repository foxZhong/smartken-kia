package com.smartken.kia.dao.sys;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;


import com.smartken.kia.dao.BaseDao;
import com.smartken.kia.mapper.sys.IMenuTreeNodeMapper;
import com.smartken.kia.model.sys.MenuTreeNodeModel;

public class MenuTreeNodeDao extends BaseDao implements IMenuTreeNodeMapper {

	public int deleteOne(Object pObjPrimaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertOne(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList selectAll() {
		// TODO Auto-generated method stub
		SqlSession s=this.openSqlSession();
		IMenuTreeNodeMapper itnm= s.getMapper(IMenuTreeNodeMapper.class);
		return itnm.selectAll();
	}

	public ArrayList selectCondition(String pStrCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object selectOne(Object pObjId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateOne(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
