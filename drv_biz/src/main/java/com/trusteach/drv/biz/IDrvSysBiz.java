package com.trusteach.drv.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.IMapper;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.DepartmentModel;
import com.trusteach.drv.model.DictModel;

public interface IDrvSysBiz extends IBaseCrudBiz {
	
	public static String TYPE_NAME_KSCC="考试场次";
	public static String TYPE_NAME_KSDD="考试地点";
	public static String DEP_TYPE_SCHOOL="驾校";
	
	public ArrayList<DictModel> listKscc(String code) throws Exception;
	
	public ArrayList<DictModel> listKsdd(String code) throws Exception;
	
	public ArrayList<DepartmentModel> listSchool(String code) throws Exception;

	public BookedLimitModel fillObject(BookedLimitModel pLimit) throws Exception;
}
