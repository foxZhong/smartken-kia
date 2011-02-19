package com.smartken.kia.core.model;

import java.util.ArrayList;

import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.pager.PageBounds;

public interface IBaseCrudBiz<Model> {

	public ArrayList<Model> getModel(Model model) throws Exception;
	public ArrayList<Model> getModel(Model model,PageBounds pPage) throws Exception;
	public ArrayList<Model> getModelWithId(ArrayList lListIds,QueryEnum pQuery) throws Exception;
    public ArrayList<Model> getModelWithId(ArrayList lListIds,QueryEnum pQuery,PageBounds pPage) throws Exception;
    public int addModel(Model model) throws Exception;
    public int modifyModel(Model model) throws Exception;
    public int removeModelWithId(ArrayList lListIds,QueryEnum pQuery) throws Exception;
    public int count() throws Exception;
    public void loadCrudMapper(Class c);
}
