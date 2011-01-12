package com.smartken.kia.mapper.sys;

import java.util.ArrayList;

import com.smartken.kia.mapper.IMapper;


public interface IUserMapper extends IMapper {

	public ArrayList selectInRole(ArrayList<String> pListRole);
}
