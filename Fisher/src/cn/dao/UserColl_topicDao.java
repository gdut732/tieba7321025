package cn.dao;

import cn.bean.PageBean;
import cn.bean.UserColl_topic;
import cn.bean.Users;

public interface UserColl_topicDao {
	
	//收藏话题
	public boolean Coll_topic(UserColl_topic uct);
	
	//取消收藏
	public boolean disColl_topic(UserColl_topic uct);
	
	//查找哦某用户的收藏
	public PageBean<UserColl_topic> allColl_topic(Users user,int pageIndex,int pageSize);

}
