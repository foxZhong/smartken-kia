package com.trusteach.drv.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.util.StringUtil;
import com.trusteach.drv.biz.IDrvSysBiz;
import com.trusteach.drv.mapper.sys.IDepartmentMapper;
import com.trusteach.drv.mapper.sys.IDictMapper;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.DepartmentModel;
import com.trusteach.drv.model.DictModel;

public class DrvSysBiz extends BaseCurdBiz implements IDrvSysBiz {

	private IDictMapper<DictModel> iDictMapper;
	private IDepartmentMapper<DepartmentModel> iDepartmentMapper;
	
	
	
	public void setiDictMapper(IDictMapper<DictModel> iDictMapper) {
		this.iDictMapper = iDictMapper;
	}
	

	public void setiDepartmentMapper(
			IDepartmentMapper<DepartmentModel> iDepartmentMapper) {
		this.iDepartmentMapper = iDepartmentMapper;
	}





	@Override
	public void loadCrudMapper(Class c) {
		// TODO Auto-generated method stub
		if(c.equals(DictModel.class))
		{
			this.iCRUDMapper=iDictMapper;
		}else if(c.equals(DepartmentModel.class))
		{
			this.iCRUDMapper=iDepartmentMapper;
		}
	}


	public ArrayList<DictModel> listKscc(String code) throws Exception {
		// TODO Auto-generated method stub
		DictModel lDict=new DictModel();
		lDict.setTypeName(TYPE_NAME_KSCC);
		lDict.setDictValue(code);
		ArrayList<DictModel> lListKscc=iDictMapper.select(lDict);
		return lListKscc;
	}


	public ArrayList<DictModel> listKsdd(String code) throws Exception {
		// TODO Auto-generated method stub
		DictModel lDict=new DictModel();
		lDict.setTypeName(TYPE_NAME_KSDD);
		lDict.setDictValue(code);
		ArrayList<DictModel> lListKsdd=iDictMapper.select(lDict);
		return lListKsdd;
	}


	public ArrayList<DepartmentModel> listSchool(String code) throws Exception {
		// TODO Auto-generated method stub
	    DepartmentModel lDep=new DepartmentModel();
        lDep.setDeptype(DEP_TYPE_SCHOOL);
        lDep.setDepcode(code);
        ArrayList<DepartmentModel> lListSchool=iDepartmentMapper.select(lDep);
        return lListSchool;
	}


	public BookedLimitModel fillObject(BookedLimitModel pLimit)
			throws Exception {
		// TODO Auto-generated method stub
		if(StringUtil.isNotBlank(pLimit.getKsccCode()))
		{
		   DictModel dict=new DictModel();
		   dict.setTypeName(TYPE_NAME_KSCC);
		   dict.setDictValue(pLimit.getKsccCode());
		   DictModel dictKscc=iDictMapper.select(dict).get(0);
		   pLimit.setKscc(dictKscc.getDictText());
		}
		if(StringUtil.isNotBlank(pLimit.getKsddCode()))
		{
		   DictModel dict=new DictModel();
		   dict.setTypeName(TYPE_NAME_KSDD);
		   dict.setDictValue(pLimit.getKsddCode());
		   DictModel dictKsdd=iDictMapper.select(dict).get(0);
		   pLimit.setKsdd(dictKsdd.getDictText());
		}
		if(StringUtil.isNotBlank(pLimit.getSchoolCode()))
		{
		   DepartmentModel dep=new DepartmentModel();
		   dep.setDeptype(DEP_TYPE_SCHOOL);
		   dep.setDepcode(pLimit.getSchoolCode());
		   DepartmentModel depSchool=iDepartmentMapper.select(dep).get(0);
		   pLimit.setSchoolName(depSchool.getDepnickname());
		}
		return pLimit;
	}
	

	
	

}
