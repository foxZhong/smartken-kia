package com.smartken.kia.core.model;

import java.util.ArrayList;

import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.pager.PageBounds;

public interface IBaseCrudBiz {

	public ArrayList getModel(Object model) throws Exception;
	public ArrayList getModel(Object model,PageBounds pPage) throws Exception;
	public Object getModelEqId(Object id) throws Exception;
	public ArrayList getModelWithId(ArrayList lListIds,QueryEnum pQuery) throws Exception;
    public ArrayList getModelWithId(ArrayList lListIds,QueryEnum pQuery,PageBounds pPage) throws Exception;
    public int addModel(Object model) throws Exception;
    public int modifyModel(Object model) throws Exception;
    public int modifyModel(Object model,Object pk) throws Exception;
    public int removeModelWithId(ArrayList lListIds,QueryEnum pQuery) throws Exception;
    public int count() throws Exception;
    public void loadCrudMapper(Class c);
}
