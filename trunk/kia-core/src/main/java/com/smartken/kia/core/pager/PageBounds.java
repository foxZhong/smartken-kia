package com.smartken.kia.core.pager;

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
