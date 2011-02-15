package com.smartken.kia.core.model.impl;

import java.util.ArrayList;



import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IMapper;


public abstract class BaseCurdBiz implements IBaseCrudBiz {
	
	protected IMapper iCRUDMapper;
	
	public int addModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		lIntSqlResult=iCRUDMapper.insertOne(model);
		return lIntSqlResult;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getModelWithId(ArrayList lListIds, QueryEnum pQuery,PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList lListModel=null;
		pPage=pPage==null?new PageBounds():pPage;
		switch(pQuery)
		{
		  case IN:{
			  lListModel=iCRUDMapper.selectInPk(lListIds,pPage);break;
		  }
		  case NOTIN:{
			  lListModel=iCRUDMapper.selectNotInPk(lListIds,pPage);break;
		  }
		  case EQ:{
			    //String lStrPk=lListIds.get(0).toString();
				Object model=iCRUDMapper.selectEqPk(lListIds.get(0));
				lListModel=new ArrayList();
				lListModel.add(model);
				break;
		  }
		  case LIKE:{
			  String lStrPk=lListIds.get(0).toString();
			  lListModel=iCRUDMapper.selectLike(lStrPk);
		  }
		  case ALL:{
			  lListModel=iCRUDMapper.selectAll(pPage);
			   break;
		  }
		  default:break;
		}
		return lListModel;
	}

	public int modifyModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		lIntSqlResult=iCRUDMapper.updateOne(model);
		return lIntSqlResult;
	}

	public int removeModelWithId(ArrayList lListIds, QueryEnum pQuery) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;
        switch(pQuery)
        {
	        case IN:{
	        	lIntSqlResult=iCRUDMapper.deleteInPk(lListIds);
	        	break;
	        }
	        case NOTIN:{
	        	lIntSqlResult=iCRUDMapper.deleteNotInPk(lListIds);
	        }
	        default:break;
        }
		return lIntSqlResult;
	}
	
	
	
	public int countModel() throws Exception {
		// TODO Auto-generated method stub
		return iCRUDMapper.count();
	}
	
	public ArrayList getModel(Object model) throws Exception{
		return iCRUDMapper.select(model);
	}

	public abstract void loadCrudMapper(Class c);
}
