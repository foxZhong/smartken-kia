package com.smartken.kia.util.page;

import org.apache.ibatis.session.RowBounds;

public class PageBounds extends RowBounds{

	
	public PageBounds()
	{
		super();
	}
	
	public PageBounds(int offset,int page)
	{
		super(offset,page);
	}
}
