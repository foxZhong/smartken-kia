package com.smartken.kia.util.model.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.smartken.kia.util.model.IBaseCrudBiz;
import com.smartken.kia.util.model.IMapper;
import com.smartken.kia.util.page.PageBounds;
import com.smartken.kia.util.StringUtil;
import com.smartken.kia.util.enums.QueryEnum;

public abstract class BaseCurdBiz<Model> implements IBaseCrudBiz<Model> {
	
	protected IMapper<Model> iCRUDMapper;
	
	public int addModel(Model model) throws Exception {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		lIntSqlResult=iCRUDMapper.insertOne(model);
		return lIntSqlResult;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Model> getModelWithId(ArrayList lListIds, QueryEnum pQuery,PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Model> lListModel=null;
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
				Model model=iCRUDMapper.selectEqPk(lListIds.get(0));
				lListModel=new ArrayList<Model>();
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

	public int modifyModel(Model model) throws Exception {
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
	
	public abstract void loadCrudMapper(Class c);
}
