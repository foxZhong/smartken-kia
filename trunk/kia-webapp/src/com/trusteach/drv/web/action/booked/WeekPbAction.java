package com.trusteach.drv.web.action.booked;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.web.action.BaseAction;
import com.trusteach.drv.biz.IBookedBiz;
import com.trusteach.drv.biz.IDrvSysBiz;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.BookedWeekRecordModel;
import com.trusteach.drv.model.DepartmentModel;
import com.trusteach.drv.model.DictModel;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class WeekPbAction extends BaseAction implements ModelDriven<BookedWeekRecordModel>{

	private IBookedBiz iBookedBiz;
	private IDrvSysBiz iDrvSysBiz;
	private BookedWeekRecordModel bookedWeekRecordModel;
	private BookedLimitModel tempLimit;
    private Date searchDate;
    private String limitKey;
    
    
	
	public void setiBookedBiz(IBookedBiz iBookedBiz) {
		this.iBookedBiz = iBookedBiz;
	}
	
	public void setiSysBiz(IDrvSysBiz iDrvSysBiz) {
		this.iDrvSysBiz = iDrvSysBiz;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}
	
	

	public void setTempLimit(BookedLimitModel tempLimit) {
		this.tempLimit = tempLimit;
	}

	
	
	
	public BookedLimitModel getTempLimit() {
		return tempLimit;
	}

	public void setLimitKey(String limitKey) {
		this.limitKey = limitKey;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("finally")
	public BookedWeekRecordModel getModel() {
		// TODO Auto-generated method stub
		iBookedBiz.loadCrudMapper(BookedWeekRecordModel.class);
		HttpServletRequest req=this.getRequest();
		try{
		if(req.getMethod().equalsIgnoreCase(METHOD_GET))
		{
			if(StringUtil.isNotBlank(req.getParameter("weekNum")))
			{
				int weekNum=ObjectUtil.formatInt(req.getParameter("weekNum"));
				this.bookedWeekRecordModel=iBookedBiz.getWeekRecord(weekNum);
			    if(this.bookedWeekRecordModel==null)
			    {
			    	this.bookedWeekRecordModel=new BookedWeekRecordModel();
			    }else
			    {
			    	this.bookedWeekRecordModel.setLimits(iBookedBiz.getLimits(this.bookedWeekRecordModel.getIWeekNum()));
			    }
			}
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
			if(ObjectUtil.isNotEmpty(searchDate))
			{
				int weekNum=DateTimeUtil.getWeekOfYear(searchDate);
				BookedWeekRecordModel model=iBookedBiz.getWeekRecord(weekNum);
				this.bookedWeekRecordModel=model==null?new BookedWeekRecordModel():model;
			    this.bookedWeekRecordModel.setLimits(iBookedBiz.getLimits(weekNum));
			}
		}
		}catch(Exception ex)
		{	
		}finally{
		return this.bookedWeekRecordModel;
		}
	}

	
	public String list_DataGrid() throws Exception{
		iBookedBiz.loadCrudMapper(BookedWeekRecordModel.class);
		ArrayList lListWeekRecords=iBookedBiz.getModelWithId(null, QueryEnum.ALL, null);
		JSONArray lListJson=ObjectUtil.toJsonArray(lListWeekRecords);
		writeHTML(EasyUiUtil.toJsonDataGrid(lListJson,iBookedBiz.countModel()).toString());
		return NONE;
	}
	

	public String to_assign() throws Exception{

		return JSP;
	}
	
	public String reload_assign() throws Exception{
		return JSP;
	}

	
	public void select_school() throws Exception
	{
//        DepartmentModel lDep=new DepartmentModel();
//        lDep.setDeptype("驾校");
//        iDrvSysBiz.loadCrudMapper(DepartmentModel.class);
        ArrayList lListSchool=iDrvSysBiz.listSchool(null);
		JSONArray lJsonSchools= ObjectUtil.toJsonArray(lListSchool);
		this.writePlainText(lJsonSchools.toString());
	}
	
	public  void select_kscc() throws Exception
	{
		//DictModel lDict=new DictModel();
		//lDict.setTypeName("考试场次");
		//iDrvSysBiz.loadCrudMapper(DictModel.class);
		ArrayList lListKscc=iDrvSysBiz.listKscc(null);
		JSONArray lJsonKscc= ObjectUtil.toJsonArray(lListKscc);
		this.writePlainText(lJsonKscc.toString());
	}
	
	public void select_ksdd() throws Exception
	{
//		DictModel lDict=new DictModel();
//		lDict.setTypeName("考试地点");
//		iDrvSysBiz.loadCrudMapper(DictModel.class);
		ArrayList lListKsdd=iDrvSysBiz.listKsdd(null);
		JSONArray lJsonKsdd= ObjectUtil.toJsonArray(lListKsdd);
		this.writePlainText(lJsonKsdd.toString());
	}
	
	
	
	public String to_editLimit() throws Exception
	{
		tempLimit=this.bookedWeekRecordModel.getLimits().get(this.limitKey);
		return JSP;
	}
	
	
	public String to_addLimit() throws Exception
	{
		HttpServletRequest req=this.getRequest();
		tempLimit=new BookedLimitModel();
		tempLimit.setDayofweek(ObjectUtil.formatInt(req.getParameter("dw"),1));
		tempLimit.setKm(ObjectUtil.formatInt(req.getParameter("km"),1));
		tempLimit.setWeekNum(bookedWeekRecordModel.getIWeekNum());
		return JSP;
	}

    public void do_editLimit() throws Exception
    {
    	BookedLimitModel editLimit=this.bookedWeekRecordModel.getLimits().get(this.limitKey);
    	//editLimit.setKsccCode(tempLimit.getKsccCode());
    	//editLimit.setKsddCode(tempLimit.getKsddCode());
    	//editLimit.setSchoolCode(tempLimit.getSchoolCode());
    	editLimit.setTotal(tempLimit.getTotal());
    	//editLimit=iDrvSysBiz.fillObject(editLimit);
    	this.bookedWeekRecordModel.getLimits().put(this.limitKey, editLimit);
    	ResultModel result=new ResultModel();
    	if(editLimit==null)
    	{
    		result.setCode(ResultModel.CODE_ERROR);
    		result.setTitle("编辑失败");
    		result.setMsg("限制项"+editLimit.getDateKsrq()+"不存在");
    	}else
    	{
    		result.setCode(ResultModel.CODE_SUCCESS);
    		result.setTitle("编辑成功");
    		result.setMsg("限制项"+editLimit.getDateKsrq()+"保存成功");
    	}
    	this.writePlainText(result.toJson().toString());
    }
    
    public void do_addLimit() throws Exception{
    	BookedLimitModel addLimit=this.tempLimit;
    	addLimit=iDrvSysBiz.fillObject(addLimit);
    	this.bookedWeekRecordModel.getLimits().put((String) addLimit.generalPK(), addLimit);
    	ResultModel result=new ResultModel();
    	if(addLimit==null)
    	{
    		result.setCode(ResultModel.CODE_ERROR);
    		result.setTitle("添加失败");
    		result.setMsg("限制项"+addLimit.getDateKsrq()+"不存在");
    	}else
    	{
    		result.setCode(ResultModel.CODE_SUCCESS);
    		result.setTitle("添加成功");
    		result.setMsg("限制项"+addLimit.getDateKsrq()+"添加成功");
    	}
    	this.writePlainText(result.toJson().toString());
    }
	
    public void do_removeLimit() throws Exception{
    	this.bookedWeekRecordModel.getLimits().remove(limitKey);
    }
    
    public void do_removeLimits() throws Exception{
    	HttpServletRequest req=this.getRequest();
		int dw=ObjectUtil.formatInt(req.getParameter("dw"));
		int km=ObjectUtil.formatInt(req.getParameter("km"));
		for(Iterator<String> it=this.bookedWeekRecordModel.getLimits().keySet().iterator();it.hasNext();)
		{
			String key=it.next();
			BookedLimitModel tempLimit=this.bookedWeekRecordModel.getLimits().get(key);
			if(tempLimit.getKm()==km && tempLimit.getDayofweek() ==dw)
			{
				this.bookedWeekRecordModel.getLimits().remove(key);
			}
		}
		this.writePlainText("");
    }

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
