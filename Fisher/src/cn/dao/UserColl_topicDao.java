package cn.dao;

import cn.bean.PageBean;
import cn.bean.UserColl_topic;
import cn.bean.Users;

public interface UserColl_topicDao {
	
	//�ղػ���
	public boolean Coll_topic(UserColl_topic uct);
	
	//ȡ���ղ�
	public boolean disColl_topic(UserColl_topic uct);
	
	//����Ŷĳ�û����ղ�
	public PageBean<UserColl_topic> allColl_topic(Users user,int pageIndex,int pageSize);

}
