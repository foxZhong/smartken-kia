package com.smartken.kia.biz.impl;

import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.mapper.admin.IMenuMapper;
import com.smartken.kia.mapper.admin.IUserMapper;
import com.smartken.kia.model.admin.MenuModel;
import com.smartken.kia.model.admin.UserModel;

public class BaseKiaBiz extends BaseCurdBiz{

	
	
	protected IMenuMapper<MenuModel> menuMapper;
	protected IUserMapper<UserModel> userMapper;

	public void setMenuMapper(IMenuMapper iMenuTreeNodeMapper) {
		this.menuMapper = iMenuTreeNodeMapper;
		this.addCrudMapper(MenuModel.class, iMenuTreeNodeMapper);
	}

	public void setUserMapper(IUserMapper iUserMapper) {
		this.userMapper = iUserMapper;
		this.addCrudMapper(UserModel.class, iUserMapper);
	}
}
