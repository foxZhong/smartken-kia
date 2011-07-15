package com.smartken.kia.core.digu;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.smartken.kia.core.enums.EDataFormat;

public class StatuseApi extends BaseDiguApi {

	public StatuseApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}
	
	
	public String public_timeline(EDataFormat edf) throws DiguException {
	    String pattern="/public_timeline.{0}";
	    String url =MessageFormat.format(pattern,
	       edf		
	    );
	    return this.doGet(edf,url);
	}
	
	public String friends_timeline(EDataFormat edf) throws DiguException{
		String pattern="/friends_timeline.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	    return this.doGet(edf,url);
	}

	public String user_timeline(EDataFormat edf,String userIdOrName) throws DiguException{
		String pattern="/user_timeline.{0}?userIdOrName={1}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	       ,userIdOrName
	 	);
	 	    return this.doGet(edf,url);
	}
	
	//返回指定Id 的一条Digu 消息，返回信息中包含作者信息。
	public String show(EDataFormat edf,String id) throws DiguException{
		String pattern="/show/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	 	        id
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	//更新认证用户的Digu 消息，必须包含content 参数，且必须以POST 方式请求。成功
	//时按指定格式返回当前的Digu 消息。
	public String update(EDataFormat edf,String content) throws DiguException{
		String pattern="/update.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	    this.setContent(content);
	 	return this.doPost(edf,url);
	}
	
	
	//显示20 条最近的对认证用户的回复Digu 消息， ( 消息前缀为@username ) 。该API
	//只开放给认证用户，请求其他用户的收到的回复消息列表是非法的，无论其他用户设置私密
	//与否。
	public String replies(EDataFormat edf) throws DiguException{
		String pattern="/replies.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	//根据指定的id 删除一条Digu 消息，认证用户必须是消息的作者。
	public String destroy(EDataFormat edf,String id) throws DiguException{
		String pattern="/destroy/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	 	        id
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	//返回认证用户的朋友列表，内含每个用户的当前Digu 信息。这个方法同样可以用来请
	//求其他用户的朋友列表，通过下面指明的方法传递id 参数。分页
	public String friends(EDataFormat edf) throws DiguException{
		String pattern="/friends.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	    return this.doGet(edf,url);
	}
	
	//返回认证用户或者指定用户的朋友列表数。这个方法同样可以用来请求其他用户的朋友
	//列表，通过下面指明的方法传递参数
	public String friends_count(EDataFormat edf) throws DiguException{
		String pattern="/friends_count.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	    return this.doGet(edf,url);
	}
	
	//返回认证用户的订阅者，内含每个订阅者的当前Digu 消息。与friends 一样，只需要把
	//friends 地址中的friends 替换为followers 即可，其余一切包括参数都不需要改变，都是一样
	//的用法。分页
	public String followers(EDataFormat edf) throws DiguException{
		String pattern="/followers.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	    return this.doGet(edf,url);
	}
	
	//返回认证用户或者指定用户的跟随者数量。与friends_count 一样，只需要把friends_count
	//地址中的friends_count 替换为followers_count 即可，其余一切包括参数都不需要改变，都是
	//一样的用法。
	public String followers_count(EDataFormat edf) throws DiguException{
		String pattern="/followers_count.{0}";
	    String url =MessageFormat.format(pattern,
	 	       edf		
	 	);
	 	    return this.doGet(edf,url);
	}
	
	public static void main(String[] args){
		DiguClient diguClient=new DiguClient();
		StatuseApi statuseApi=new StatuseApi(diguClient);
		//System.out.println(statuseApi.public_timeline(EDataFormat.json));
		String testUser="smartken";
		DiguClient authDiguClient=new DiguClient(testUser, "chipchina");
		statuseApi=new StatuseApi(authDiguClient);
		try {
//			System.out.println("friends_timeline:"+statuseApi.friends_timeline(EDataFormat.json));
//			System.out.println("followers:"+statuseApi.followers(EDataFormat.json));
//			System.out.println("followers_count:"+statuseApi.followers_count(EDataFormat.json));
//			System.out.println("friends:"+statuseApi.friends(EDataFormat.json));
//			System.out.println("friends_count:"+statuseApi.friends_count(EDataFormat.json));
		//	System.out.println("user_timeline:"+statuseApi.user_timeline(EDataFormat.json,testUser));
			//System.out.println("show:"+statuseApi.show(EDataFormat.json,"85108796"));
			System.out.println("update:"+statuseApi.update(EDataFormat.xml,"龟爷用java api叼叼你4"));
      //		System.out.println("replies:"+statuseApi.replies(EDataFormat.json));
		//	System.out.println("destroy:"+statuseApi.destroy(EDataFormat.json, "85137431"));
		} catch (DiguException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}


	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/statuses";
	}
}
