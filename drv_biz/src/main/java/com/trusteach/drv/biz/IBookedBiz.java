package com.trusteach.drv.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.smartken.kia.core.model.IBaseCrudBiz;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.BookedWeekRecordModel;

public interface IBookedBiz<T> extends IBaseCrudBiz<T>{

	//public BookedWeekRecordModel getWeekRecord(Date pDate);
	public BookedWeekRecordModel getWeekRecord(int weekNum);
	
	public Map<String,BookedLimitModel> getLimits(int weekNum) throws Exception;
	
}
