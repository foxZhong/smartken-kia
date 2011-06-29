package shoes.dao;
import java.util.List;

import shoes.entity.UserInfo;

public interface UserInfoDao {
	
	public UserInfo findUser(String uName,String uPass);
	
	public UserInfo findUser(int uId);
	
	public List findAllUser();
	
	public int addUser(UserInfo userInfo);
	
	public int updateUser(UserInfo userInfo);
	
	public int deleteUser(int uId);
	
	public int addAdmin(String UName,String UPass);
}
