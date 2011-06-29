package shoes.test;
import shoes.entity.UserInfo;
import shoes.dao.UserInfoDao;
import shoes.dao.impl.UserInfoDaoImpl;

public class UserInfoTest {
	public static void main(String[] args) {
		
//		UserInfo userInfo = new UserInfo("lvsiwei","lvsiwei","ÄÐ","Admin");
//		UserInfoDao uid = new UserInfoDaoImpl();
//		int result = uid.addUser(userInfo);
//		System.out.println(result);
		
//		UserInfo userInfo = null;
//		UserInfoDao uid = new UserInfoDaoImpl();
//		userInfo = uid.findUser(3);
//		System.out.println(userInfo.getUName());
		
		UserInfo userInfo = new UserInfo("lvsiwei","123","guest");
		UserInfoDao uid = new UserInfoDaoImpl();
		int result = uid.updateUser(userInfo);
		System.out.println(result);
	}
}
