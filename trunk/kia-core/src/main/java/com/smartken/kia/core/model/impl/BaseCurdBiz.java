package com.smartken.kia.core.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.text.MaskFormatter;



import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.PageList;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IMapper;


public abstract class BaseCurdBiz implements IBaseCrudBiz {
	
	private IMapper crudMapper;
	private Map<Class,IMapper> mappers=new HashMap<Class, IMapper>();
	
	public int count()  {
		// TODO Auto-generated method stub
		int count=0;
		try{
			count+=this.crudMapper.count();
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}finally{
			return count;
		}
	}
	
	
	
	public List getModel() {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectAll();
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public List getModel(PageBounds pPage) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectAll(pPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}
 

	public List getModel(Object model) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
           list= this.crudMapper.select(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}
	

	public PageArrayList getModel(Object model, PageBounds pPage) {
		// TODO Auto-generated method stub
          List list=this.getModel(model);
          PageArrayList pageList=new PageArrayList(list, pPage);
          return pageList;
	}
	

	
	public Object getModelEqPk(Object pk) {
		// TODO Auto-generated method stub
		Object obj=null;
		try{
			System.out.println(this.crudMapper.toString());
			obj=this.crudMapper.selectEqPk(pk);
		}catch(Exception ex){
			ex.printStackTrace();
			return obj;
		}
		return obj;
	}

	
	
	public List getModelInPk(List listPk)  {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		return list;
	}
	public PageArrayList getModelInPk(List listPk, PageBounds pPage)
	 {
		// TODO Auto-generated method stub
		List list = this.getModelInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
     }
	
	
	public PageArrayList getModelNotInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
        List list=this.getModelNotInPk(listPk);
        PageArrayList pageList=new PageArrayList(list, pPage);
        return pageList;
	}
	
	public List getModelNotInPk(List listPk)  {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		return list;
	}

	public ResultModel modifyModel(Object model, Object pkNew) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try{
			re+=this.crudMapper.updateOne(model,pkNew);
			reModel.setRe(re);
			if(re==1){
				reModel.setTitle("操作成功");
				reModel.setMsg("记录修改成功");
			}else {
				reModel.setAction(ResultModel.ACTION_ALERT);
				reModel.setTitle("操作失败");
				reModel.setMsg("记录修改失败");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			reModel.setAction(ResultModel.ACTION_ALERT);
			reModel.setTitle("操作失败");
			reModel.setMsg("错误信息:"+ex.getLocalizedMessage());
			return reModel;
		}
		return reModel;
	}
	public ResultModel modifyModel(Object model) {
		// TODO Auto-generated method stub
		return modifyModel(model, null);
	}
	
	public ResultModel removeModelEqPk(Object pk) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try{
			re+=this.crudMapper.deleteEqPk(pk);
			reModel.setRe(re);
			if(re==1){
				reModel.setTitle("操作成功");
				reModel.setMsg(re+"条记录删除成功");
			}else {
				reModel.setAction(ResultModel.ACTION_ALERT);
				reModel.setTitle("操作失败");
				reModel.setMsg("没有记录被删除");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			reModel.setAction(ResultModel.ACTION_ALERT);
			reModel.setTitle("操作失败");
			reModel.setMsg("错误信息:"+ex.getLocalizedMessage());
			return reModel;
		}
		return reModel;
	}
	
	public ResultModel removeModelInPk(List listPk)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try{
			re+=this.crudMapper.deleteInPk(listPk);
			reModel.setRe(re);
			if(re>0){
				reModel.setTitle("操作成功");
				reModel.setMsg(re+"条记录删除成功");
			}else {
				reModel.setAction(ResultModel.ACTION_ALERT);
				reModel.setTitle("操作失败");
				reModel.setMsg("没有记录被删除");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			reModel.setAction(ResultModel.ACTION_ALERT);
			reModel.setTitle("操作异常");
			reModel.setMsg("错误信息:"+ex.getLocalizedMessage());
			return reModel;
		}
		return reModel;
	}
	public ResultModel removeModelNotInPk(List listPk) {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try{
			re+=this.crudMapper.deleteNotInPk(listPk);
			reModel.setRe(re);
			if(re>0){
				reModel.setTitle("操作成功");
				reModel.setMsg(re+"条记录删除成功");
			}else {
				reModel.setAction(ResultModel.ACTION_ALERT);
				reModel.setTitle("操作失败");
				reModel.setMsg("没有记录被删除");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			reModel.setAction(ResultModel.ACTION_ALERT);
			reModel.setTitle("操作异常");
			reModel.setMsg("错误信息:"+ex.getLocalizedMessage());
			return reModel;
		}
		return reModel;
	}
	
	
	
	public ResultModel addModel(Object model)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		int re=0;
		try{
			re+=this.crudMapper.insertOne(model);
			reModel.setRe(re);
			if(re==1){
				reModel.setTitle("操作成功");
				reModel.setMsg(re+"条记录创建成功");
			}else {
				reModel.setAction(ResultModel.ACTION_ALERT);
				reModel.setTitle("操作失败");
				reModel.setMsg("没有记录被创建");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			reModel.setAction(ResultModel.ACTION_ALERT);
			reModel.setTitle("操作异常");
			reModel.setMsg("错误信息:"+ex.getLocalizedMessage());
			return reModel;
		}
	    return reModel;
	}
	
	
	
	
	public ResultModel addOrModifyModel(Object model, Object pkNewPk)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		reModel=addModel(model);
		if(reModel.getRe()==0){
			reModel=modifyModel(model,pkNewPk);
		}
		return reModel;
	}
	public ResultModel addOrModifyModel(Object model)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		reModel=addModel(model);
		if(reModel.getRe()==0){
			reModel=modifyModel(model);
		}
		return reModel;
	}
	public ResultModel modifyOrAddModel(Object model, Object pkNewPk)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		reModel =modifyModel(model,pkNewPk);
		if(reModel.getRe()==0){
			reModel=addModel(model);
		}
		return reModel;
	}
	public ResultModel modifyOrAddModel(Object model)  {
		// TODO Auto-generated method stub
		ResultModel reModel=new ResultModel();
		reModel=modifyModel(model);
		if(reModel.getRe()==0){
			reModel=addModel(model);
		}
		return reModel;
	}
	public boolean loadCrudMapper(Class c) throws NullPointerException{
		IMapper mapper=mappers.get(c);
		if(mapper==null){
			return false;
		}else{
			this.crudMapper=mappers.get(c);
			return true;
		}
	};
	
	
	public void setCrudMapper(IMapper crudMapper) {
		this.crudMapper = crudMapper;
	}
	
	
	
	public void addCrudMapper(Class c, IMapper mapper){
		// TODO Auto-generated method stub
		mappers.put(c, mapper);
	}
	public Map<Class, IMapper> getMappers() {
		return mappers;
	}



	public PageArrayList getModel(List listQuery, PageBounds pPage) {
		// TODO Auto-generated method stub
		List listModel=this.getModel(listQuery);
		PageArrayList pageList=new PageArrayList(listModel, pPage);
        return pageList;
	}



	public List getModel(List querys) {
		// TODO Auto-generated method stub
        List listModel=new ArrayList();
        try{
          listModel=  this.crudMapper.selectUnion((ArrayList) querys);
        }catch(Exception ex){
        	return new ArrayList();
        }
        return listModel;
	}



	public List getView() {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewAll();
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getView(List listQuery, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getView(listQuery);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getView(List listQuery) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewUnion(listQuery);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getView(Object model, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getView(model);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getView(Object model) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectView(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public List getView(PageBounds pPage) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectView(pPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public Object getViewEqPk(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}



	public PageArrayList getViewInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getViewInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getViewInPk(List listPk) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getViewNotInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getViewNotInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getViewNotInPk(List listPk) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}








	
	
	


}
