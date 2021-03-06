package com.smartken.kia.core.model;

import java.util.List;


import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.PageList;

public interface IBaseCrudBiz {

 
    public boolean loadCrudMapper(Class c) throws NullPointerException;
    public void addCrudMapper(Class c,IMapper mapper) ;
	public void setCrudMapper(IMapper crudMapper);
	public List getModel();
	public List getModel(PageBounds pPage);
    public List getModel(Object model)  ;
    public Object getTopModel(Object model)  ;
    public PageArrayList getModel(Object model,PageBounds pPage) ;
    public List getModel(List listQuery);
    public PageArrayList getModel(List listQuery,PageBounds pPage);
    public Object getModelEqPk(Object pk)  ;
    public List getModelInPk(List listPk)  ;
    public PageArrayList getModelInPk(List listPk,PageBounds pPage) ;
    public List getModelNotInPk(List listPk)  ;
    public PageArrayList getModelNotInPk(List listPk,PageBounds pPage) ;
    
	public List getView();
	public List getView(PageBounds pPage);
    public List getView(Object model)  ;
    public Object getTopView(Object model)  ;
    public PageArrayList getView(Object model,PageBounds pPage) ;
    public List getView(List listQuery);
    public PageArrayList getView(List listQuery,PageBounds pPage);
    public Object getViewEqPk(Object pk)  ;
    public List getViewInPk(List listPk)  ;
    public PageArrayList getViewInPk(List listPk,PageBounds pPage) ;
    public List getViewNotInPk(List listPk)  ;
    public PageArrayList getViewNotInPk(List listPk,PageBounds pPage) ;
    
    public ResultModel removeModelEqPk(Object pk);
    public ResultModel removeModelInPk(List listPk)  ;
    public ResultModel removeModelNotInPk(List listPk)  ;
    public ResultModel addModel(Object model)  ;
    public ResultModel modifyModel(Object model)  ;
    public ResultModel modifyModel(Object model,Object pkNew)  ; 
    
    public ResultModel addOrModifyModel(Object model)  ;
    public ResultModel addOrModifyModel(Object model,Object pkNewPk)  ;
    
    public ResultModel modifyOrAddModel(Object model)  ;
    public ResultModel modifyOrAddModel(Object model,Object pkNewPk)  ;
    public int count()  ;
}
