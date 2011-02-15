package com.trusteach.drv.model;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.model.impl.BaseModel;

public class BookedWeekRecordModel extends BaseModel{

	private Integer id;
	private Integer IWeekNum;
	private Integer IWeek1Km1Num;
	private String IWeek1Km1Fp;
	private Integer IWeek1Km2Num;
	private String IWeek1Km2Fp;
	private Integer IWeek1Km3Num;
	private String IWeek1Km3Fp;
	private Integer IWeek2Km1Num;
	private String IWeek2Km1Fp;
	private Integer IWeek2Km2Num;
	private String IWeek2Km2Fp;
	private Integer IWeek2Km3Num;
	private String IWeek2Km3Fp;
	private Integer IWeek3Km1Num;
	private String IWeek3Km1Fp;
	private Integer IWeek3Km2Num;
	private String IWeek3Km2Fp;
	private Integer IWeek3Km3Num;
	private String IWeek3Km3Fp;
	private Integer IWeek4Km1Num;
	private String IWeek4Km1Fp;
	private Integer IWeek4Km2Num;
	private String IWeek4Km2Fp;
	private Integer IWeek4Km3Num;
	private String IWeek4Km3Fp;
	private Integer IWeek5Km1Num;
	private String IWeek5Km1Fp;
	private Integer IWeek5Km2Num;
	private String IWeek5Km2Fp;
	private Integer IWeek5Km3Num;
	private String IWeek5Km3Fp;
	private Integer IWeek6Km1Num;
	private String IWeek6Km1Fp;
	private Integer IWeek6Km2Num;
	private String IWeek6Km2Fp;
	private Integer IWeek6Km3Num;
	private String IWeek6Km3Fp;
	private Integer IWeek7Km1Num;
	private String IWeek7Km1Fp;
	private Integer IWeek7Km2Num;
	private String IWeek7Km2Fp;
	private Integer IWeek7Km3Num;
	private String IWeek7Km3Fp;
	private String CCheckOperator;
	private String CCheckDate;
	private Integer IChecked;
	private String CWeekRange;
	private Integer year;
	
	private Integer IWeek1Km1Assgined=0;
	private Integer IWeek1Km2Assgined=0;
	private Integer IWeek1Km3Assgined=0;
	private Integer IWeek2Km1Assgined=0;
	private Integer IWeek2Km2Assgined=0;
	private Integer IWeek2Km3Assgined=0;
	private Integer IWeek3Km1Assgined=0;
	private Integer IWeek3Km2Assgined=0;
	private Integer IWeek3Km3Assgined=0;
	private Integer IWeek4Km1Assgined=0;
	private Integer IWeek4Km2Assgined=0;
	private Integer IWeek4Km3Assgined=0;
	private Integer IWeek5Km1Assgined=0;
	private Integer IWeek5Km2Assgined=0;
	private Integer IWeek5Km3Assgined=0;
	private Integer IWeek6Km1Assgined=0;
	private Integer IWeek6Km2Assgined=0;
	private Integer IWeek6Km3Assgined=0;
	private Integer IWeek7Km1Assgined=0;
	private Integer IWeek7Km2Assgined=0;
	private Integer IWeek7Km3Assgined=0;

	private Date monday;
	private Date tuesday;
	private Date wednesday;
	private Date thursday;
	private Date friday;
	private Date saturday;
	private Date sunday;
	
	private Map<String, BookedLimitModel> limits;
	
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	private void loadWeekDays()
	{
		if(this.IWeekNum==null||this.year==null)return;
		ArrayList<Date> lWeekDays= DateTimeUtil.getWeekDays(this.year, this.IWeekNum);
		this.monday=lWeekDays.get(DateTimeUtil.MONDAY);
		this.tuesday=lWeekDays.get(DateTimeUtil.TUESDAY);
		this.wednesday=lWeekDays.get(DateTimeUtil.WEDNESDAY);
		this.thursday=lWeekDays.get(DateTimeUtil.THURSDAY);
		this.friday=lWeekDays.get(DateTimeUtil.FRIDAY);
		this.saturday=lWeekDays.get(DateTimeUtil.SATURDAY);
		this.sunday=lWeekDays.get(DateTimeUtil.SUNDAY);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIWeekNum() {
		return IWeekNum;
	}


	public void setIWeekNum(Integer iWeekNum) {
		IWeekNum = iWeekNum;
		this.loadWeekDays();
	}


	public Integer getIWeek1Km1Num() {
		return IWeek1Km1Num;
	}


	public void setIWeek1Km1Num(Integer iWeek1Km1Num) {
		IWeek1Km1Num = iWeek1Km1Num;
	}


	public String getIWeek1Km1Fp() {
		return IWeek1Km1Fp;
	}


	public void setIWeek1Km1Fp(String iWeek1Km1Fp) {
		IWeek1Km1Fp = iWeek1Km1Fp;
	}


	public Integer getIWeek1Km2Num() {
		return IWeek1Km2Num;
	}


	public void setIWeek1Km2Num(Integer iWeek1Km2Num) {
		IWeek1Km2Num = iWeek1Km2Num;
	}


	public String getIWeek1Km2Fp() {
		return IWeek1Km2Fp;
	}


	public void setIWeek1Km2Fp(String iWeek1Km2Fp) {
		IWeek1Km2Fp = iWeek1Km2Fp;
	}


	public Integer getIWeek1Km3Num() {
		return IWeek1Km3Num;
	}


	public void setIWeek1Km3Num(Integer iWeek1Km3Num) {
		IWeek1Km3Num = iWeek1Km3Num;
	}


	public String getIWeek1Km3Fp() {
		return IWeek1Km3Fp;
	}


	public void setIWeek1Km3Fp(String iWeek1Km3Fp) {
		IWeek1Km3Fp = iWeek1Km3Fp;
	}


	public Integer getIWeek2Km1Num() {
		return IWeek2Km1Num;
	}


	public void setIWeek2Km1Num(Integer iWeek2Km1Num) {
		IWeek2Km1Num = iWeek2Km1Num;
	}


	public String getIWeek2Km1Fp() {
		return IWeek2Km1Fp;
	}


	public void setIWeek2Km1Fp(String iWeek2Km1Fp) {
		IWeek2Km1Fp = iWeek2Km1Fp;
	}


	public Integer getIWeek2Km2Num() {
		return IWeek2Km2Num;
	}


	public void setIWeek2Km2Num(Integer iWeek2Km2Num) {
		IWeek2Km2Num = iWeek2Km2Num;
	}


	public String getIWeek2Km2Fp() {
		return IWeek2Km2Fp;
	}


	public void setIWeek2Km2Fp(String iWeek2Km2Fp) {
		IWeek2Km2Fp = iWeek2Km2Fp;
	}


	public Integer getIWeek2Km3Num() {
		return IWeek2Km3Num;
	}


	public void setIWeek2Km3Num(Integer iWeek2Km3Num) {
		IWeek2Km3Num = iWeek2Km3Num;
	}


	public String getIWeek2Km3Fp() {
		return IWeek2Km3Fp;
	}


	public void setIWeek2Km3Fp(String iWeek2Km3Fp) {
		IWeek2Km3Fp = iWeek2Km3Fp;
	}


	public Integer getIWeek3Km1Num() {
		return IWeek3Km1Num;
	}


	public void setIWeek3Km1Num(Integer iWeek3Km1Num) {
		IWeek3Km1Num = iWeek3Km1Num;
	}


	public String getIWeek3Km1Fp() {
		return IWeek3Km1Fp;
	}


	public void setIWeek3Km1Fp(String iWeek3Km1Fp) {
		IWeek3Km1Fp = iWeek3Km1Fp;
	}


	public Integer getIWeek3Km2Num() {
		return IWeek3Km2Num;
	}


	public void setIWeek3Km2Num(Integer iWeek3Km2Num) {
		IWeek3Km2Num = iWeek3Km2Num;
	}


	public String getIWeek3Km2Fp() {
		return IWeek3Km2Fp;
	}


	public void setIWeek3Km2Fp(String iWeek3Km2Fp) {
		IWeek3Km2Fp = iWeek3Km2Fp;
	}


	public Integer getIWeek3Km3Num() {
		return IWeek3Km3Num;
	}


	public void setIWeek3Km3Num(Integer iWeek3Km3Num) {
		IWeek3Km3Num = iWeek3Km3Num;
	}


	public String getIWeek3Km3Fp() {
		return IWeek3Km3Fp;
	}


	public void setIWeek3Km3Fp(String iWeek3Km3Fp) {
		IWeek3Km3Fp = iWeek3Km3Fp;
	}


	public Integer getIWeek4Km1Num() {
		return IWeek4Km1Num;
	}


	public void setIWeek4Km1Num(Integer iWeek4Km1Num) {
		IWeek4Km1Num = iWeek4Km1Num;
	}


	public String getIWeek4Km1Fp() {
		return IWeek4Km1Fp;
	}


	public void setIWeek4Km1Fp(String iWeek4Km1Fp) {
		IWeek4Km1Fp = iWeek4Km1Fp;
	}


	public Integer getIWeek4Km2Num() {
		return IWeek4Km2Num;
	}


	public void setIWeek4Km2Num(Integer iWeek4Km2Num) {
		IWeek4Km2Num = iWeek4Km2Num;
	}


	public String getIWeek4Km2Fp() {
		return IWeek4Km2Fp;
	}


	public void setIWeek4Km2Fp(String iWeek4Km2Fp) {
		IWeek4Km2Fp = iWeek4Km2Fp;
	}


	public Integer getIWeek4Km3Num() {
		return IWeek4Km3Num;
	}


	public void setIWeek4Km3Num(Integer iWeek4Km3Num) {
		IWeek4Km3Num = iWeek4Km3Num;
	}


	public String getIWeek4Km3Fp() {
		return IWeek4Km3Fp;
	}


	public void setIWeek4Km3Fp(String iWeek4Km3Fp) {
		IWeek4Km3Fp = iWeek4Km3Fp;
	}


	public Integer getIWeek5Km1Num() {
		return IWeek5Km1Num;
	}


	public void setIWeek5Km1Num(Integer iWeek5Km1Num) {
		IWeek5Km1Num = iWeek5Km1Num;
	}


	public String getIWeek5Km1Fp() {
		return IWeek5Km1Fp;
	}


	public void setIWeek5Km1Fp(String iWeek5Km1Fp) {
		IWeek5Km1Fp = iWeek5Km1Fp;
	}


	public Integer getIWeek5Km2Num() {
		return IWeek5Km2Num;
	}


	public void setIWeek5Km2Num(Integer iWeek5Km2Num) {
		IWeek5Km2Num = iWeek5Km2Num;
	}


	public String getIWeek5Km2Fp() {
		return IWeek5Km2Fp;
	}


	public void setIWeek5Km2Fp(String iWeek5Km2Fp) {
		IWeek5Km2Fp = iWeek5Km2Fp;
	}


	public Integer getIWeek5Km3Num() {
		return IWeek5Km3Num;
	}


	public void setIWeek5Km3Num(Integer iWeek5Km3Num) {
		IWeek5Km3Num = iWeek5Km3Num;
	}


	public String getIWeek5Km3Fp() {
		return IWeek5Km3Fp;
	}


	public void setIWeek5Km3Fp(String iWeek5Km3Fp) {
		IWeek5Km3Fp = iWeek5Km3Fp;
	}


	public Integer getIWeek6Km1Num() {
		return IWeek6Km1Num;
	}


	public void setIWeek6Km1Num(Integer iWeek6Km1Num) {
		IWeek6Km1Num = iWeek6Km1Num;
	}


	public String getIWeek6Km1Fp() {
		return IWeek6Km1Fp;
	}


	public void setIWeek6Km1Fp(String iWeek6Km1Fp) {
		IWeek6Km1Fp = iWeek6Km1Fp;
	}


	public Integer getIWeek6Km2Num() {
		return IWeek6Km2Num;
	}


	public void setIWeek6Km2Num(Integer iWeek6Km2Num) {
		IWeek6Km2Num = iWeek6Km2Num;
	}


	public String getIWeek6Km2Fp() {
		return IWeek6Km2Fp;
	}


	public void setIWeek6Km2Fp(String iWeek6Km2Fp) {
		IWeek6Km2Fp = iWeek6Km2Fp;
	}


	public Integer getIWeek6Km3Num() {
		return IWeek6Km3Num;
	}


	public void setIWeek6Km3Num(Integer iWeek6Km3Num) {
		IWeek6Km3Num = iWeek6Km3Num;
	}


	public String getIWeek6Km3Fp() {
		return IWeek6Km3Fp;
	}


	public void setIWeek6Km3Fp(String iWeek6Km3Fp) {
		IWeek6Km3Fp = iWeek6Km3Fp;
	}


	public Integer getIWeek7Km1Num() {
		return IWeek7Km1Num;
	}


	public void setIWeek7Km1Num(Integer iWeek7Km1Num) {
		IWeek7Km1Num = iWeek7Km1Num;
	}


	public String getIWeek7Km1Fp() {
		return IWeek7Km1Fp;
	}


	public void setIWeek7Km1Fp(String iWeek7Km1Fp) {
		IWeek7Km1Fp = iWeek7Km1Fp;
	}


	public Integer getIWeek7Km2Num() {
		return IWeek7Km2Num;
	}


	public void setIWeek7Km2Num(Integer iWeek7Km2Num) {
		IWeek7Km2Num = iWeek7Km2Num;
	}


	public String getIWeek7Km2Fp() {
		return IWeek7Km2Fp;
	}


	public void setIWeek7Km2Fp(String iWeek7Km2Fp) {
		IWeek7Km2Fp = iWeek7Km2Fp;
	}


	public Integer getIWeek7Km3Num() {
		return IWeek7Km3Num;
	}


	public void setIWeek7Km3Num(Integer iWeek7Km3Num) {
		IWeek7Km3Num = iWeek7Km3Num;
	}


	public String getIWeek7Km3Fp() {
		return IWeek7Km3Fp;
	}


	public void setIWeek7Km3Fp(String iWeek7Km3Fp) {
		IWeek7Km3Fp = iWeek7Km3Fp;
	}


	public String getCCheckOperator() {
		return CCheckOperator;
	}


	public void setCCheckOperator(String cCheckOperator) {
		CCheckOperator = cCheckOperator;
	}


	public String getCCheckDate() {
		return CCheckDate;
	}


	public void setCCheckDate(String cCheckDate) {
		CCheckDate = cCheckDate;
	}


	public Integer getIChecked() {
		return IChecked;
	}


	public void setIChecked(Integer iChecked) {
		IChecked = iChecked;
	}


	public String getCWeekRange() {
		return CWeekRange;
	}


	public void setCWeekRange(String cWeekRange) {
		CWeekRange = cWeekRange;
		String lStrYear="";
		try{
		lStrYear=this.CWeekRange.substring(0,4);
		this.year=Integer.parseInt(lStrYear);
		}catch(Exception ex)
		{
			Calendar c=Calendar.getInstance();
			this.year=c.get(Calendar.YEAR);
		}finally
		{
			this.loadWeekDays();
		}
		
	}



	public Date getMonday() {
		return monday;
	}

	public Date getTuesday() {
		return tuesday;
	}

	public Date getWednesday() {
		return wednesday;
	}

	public Date getThursday() {
		return thursday;
	}

	public Date getFriday() {
		return friday;
	}

	public Date getSaturday() {
		return saturday;
	}

	public Date getSunday() {
		return sunday;
	}



	public Map<String, BookedLimitModel> getLimits() {
		return limits;
	}



	public void setLimits(Map<String, BookedLimitModel> limits) {
		this.limits = limits;
	}

	public Integer getYear() {
		return year;
	}
	
	public void calLimitAssgined(Map<String, BookedLimitModel> mapLimt)
	{
		for(Iterator<String> itKey=mapLimt.keySet().iterator();itKey.hasNext();)
		{
			String tempKey=itKey.next();
			BookedLimitModel tempLimit=mapLimt.get(tempKey);
			if(tempLimit.getDayofweek()==1&&tempLimit.getKm()==1)
			{
				this.IWeek1Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==1&&tempLimit.getKm()==2)
			{
				this.IWeek1Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==1&&tempLimit.getKm()==3)
			{
				this.IWeek1Km3Assgined+=tempLimit.getTptotal();
			}
			//2
			else if(tempLimit.getDayofweek()==2&&tempLimit.getKm()==1)
			{
				this.IWeek1Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==2&&tempLimit.getKm()==2)
			{
				this.IWeek1Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==2&&tempLimit.getKm()==3)
			{
				this.IWeek1Km3Assgined+=tempLimit.getTptotal();
			}
			
			//3
			else if(tempLimit.getDayofweek()==3&&tempLimit.getKm()==1)
			{
				this.IWeek3Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==3&&tempLimit.getKm()==2)
			{
				this.IWeek3Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==3&&tempLimit.getKm()==3)
			{
				this.IWeek3Km3Assgined+=tempLimit.getTptotal();
			}
			
			//4
			else if(tempLimit.getDayofweek()==4&&tempLimit.getKm()==1)
			{
				this.IWeek4Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==4&&tempLimit.getKm()==2)
			{
				this.IWeek4Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==4&&tempLimit.getKm()==3)
			{
				this.IWeek4Km3Assgined+=tempLimit.getTptotal();
			}
			
			//5
			else if(tempLimit.getDayofweek()==5&&tempLimit.getKm()==1)
			{
				this.IWeek5Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==5&&tempLimit.getKm()==2)
			{
				this.IWeek5Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==5&&tempLimit.getKm()==3)
			{
				this.IWeek5Km3Assgined+=tempLimit.getTptotal();
			}
			//6
			else if(tempLimit.getDayofweek()==6&&tempLimit.getKm()==1)
			{
				this.IWeek6Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==6&&tempLimit.getKm()==2)
			{
				this.IWeek6Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==6&&tempLimit.getKm()==3)
			{
				this.IWeek6Km3Assgined+=tempLimit.getTptotal();
			}
			//7
			else if(tempLimit.getDayofweek()==7&&tempLimit.getKm()==1)
			{
				this.IWeek7Km1Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==7&&tempLimit.getKm()==2)
			{
				this.IWeek7Km2Assgined+=tempLimit.getTptotal();
			}
			else if(tempLimit.getDayofweek()==7&&tempLimit.getKm()==3)
			{
				this.IWeek7Km3Assgined+=tempLimit.getTptotal();
			}
			
			
		}
			
	}

	
    
}
