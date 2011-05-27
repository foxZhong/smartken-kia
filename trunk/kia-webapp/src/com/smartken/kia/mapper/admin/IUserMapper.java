package com.smartken.kia.mapper.admin;

import java.util.ArrayList;

import com.smartken.kia.core.model.IMapper;
import com.smartken.kia.model.admin.UserModel;


public interface IUserMapper<T> extends IMapper<T> {

	public ArrayList selectInRole(ArrayList<String> pListRole);
	
	public T login(String pStrLoginId,String pStrLoginPwd);
}
