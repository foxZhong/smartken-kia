package com.trusteach.drv.mapper.booked;

import org.apache.ibatis.annotations.Param;

import com.smartken.kia.core.model.IMapper;

public interface IWeekRecordMapper<T> extends IMapper<T>{

	
	public T selectEqWeekNum(@Param("model") T t);
}
