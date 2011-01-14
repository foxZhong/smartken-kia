package com.smartken.kia.biz.impl;

import java.util.ArrayList;

import com.smartken.kia.biz.IBaseCrudBiz;
import com.smartken.kia.mapper.IMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.model.sys.UserModel;
import com.smartken.kia.util.StringHelper;

public abstract class BaseCurdBiz<Model> implements IBaseCrudBiz<Model> {
	
	protected IMapper<Model> iCRUDMapper;
	
	public int addModel(Model model) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		lIntSqlResult=iCRUDMapper.insertOne(model);
		return lIntSqlResult;
	}

	public ArrayList<Model> getModelWithId(ArrayList lListIds, int query)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Model> lListModel=null;
		if(query==StringHelper.ALL)
		{
			lListModel=iCRUDMapper.selectAll();
		}else if(lListIds.size()>0&&query==StringHelper.EQ)
		{
			Model model=iCRUDMapper.selectEqPk(lListIds.get(0));
			lListModel=new ArrayList<Model>();
			lListModel.add(model);
		}else if(query==StringHelper.LIKE){
		     lListModel=iCRUDMapper.selectLikePk(lListIds.get(0).toString());	
		}else if(query==StringHelper.NOTIN)
		{
			lListModel=iCRUDMapper.selectNotInPk(lListIds);
		}else if(query==StringHelper.IN)
		{
			//lListModel
		}
		return lListModel;
	}

	public int modifyModel(Model model) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		lIntSqlResult=iCRUDMapper.updateOne(model);
		return lIntSqlResult;
	}

	public int removeModelWithId(ArrayList lListIds, int query) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;
		if(query==StringHelper.IN)
		{lIntSqlResult=iCRUDMapper.deleteInPk(lListIds);
		}else if(query==StringHelper.NOTIN)
		{lIntSqlResult=iCRUDMapper.deleteNotInPk(lListIds);}
		return lIntSqlResult;
	}
}
