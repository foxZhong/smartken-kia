package com.trusteach.drv.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.util.DateTimeUtil;
import com.trusteach.drv.biz.IBookedBiz;
import com.trusteach.drv.mapper.booked.ILimitMapper;
import com.trusteach.drv.mapper.booked.IWeekRecordMapper;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.BookedWeekRecordModel;

public class BookedBiz extends BaseCurdBiz implements IBookedBiz {

	private IWeekRecordMapper<BookedWeekRecordModel> iWeekRecordMapper;
	private ILimitMapper<BookedLimitModel> iLimitMapper;
	
	
	public void setiWeekRecordMapper(IWeekRecordMapper iWeekRecordMapper) {
		this.iWeekRecordMapper = iWeekRecordMapper;
	}
	

	public void setiLimitMapper(ILimitMapper<BookedLimitModel> iLimitMapper) {
		this.iLimitMapper = iLimitMapper;
	}



	@Override
	public void loadCrudMapper(Class c) {
		// TODO Auto-generated method stub
		if(c.equals(BookedWeekRecordModel.class))
		{
			this.iCRUDMapper=iWeekRecordMapper;
		}
	}

	
	public BookedWeekRecordModel getWeekRecord(int weekNum) {
		// TODO Auto-generated method stub
		
		//int lIntWeek=DateTimeUtil.getWeekOfYear(pDate);
		BookedWeekRecordModel lWeekReurn=new BookedWeekRecordModel();
		lWeekReurn.setIWeekNum(weekNum);
		try {
		ArrayList<BookedWeekRecordModel> lListWeek= iWeekRecordMapper.select(lWeekReurn);
		lWeekReurn=lListWeek.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lWeekReurn;
	}
	
	
	public Map<String,BookedLimitModel> getLimits(int weekNum) throws Exception{
		Map<String, BookedLimitModel> lMapReturn=new HashMap<String, BookedLimitModel>();
		BookedLimitModel lLimit=new BookedLimitModel();
		lLimit.setWeekNum(weekNum);
        ArrayList<BookedLimitModel> lListLimit=iLimitMapper.select(lLimit);
		for (BookedLimitModel bookedLimitModel : lListLimit) {
			   lMapReturn.put((String) bookedLimitModel.generalPK(), bookedLimitModel);	
		}
	   return lMapReturn;
	}

}
