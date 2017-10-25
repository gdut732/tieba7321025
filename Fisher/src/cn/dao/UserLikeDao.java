package cn.dao;

import cn.bean.Topic1;
import cn.bean.Users;

public interface UserLikeDao {

	
	//判断某用户是否点赞过某话题
	public boolean checklike(Users user,Topic1 topic1);
	
	//点赞
	public boolean likeit(Users user,Topic1 topic1);
	
	//取消点赞
	public boolean dontlike(Users user,Topic1 topic1);
}
