package cn.dao;

import cn.bean.PageBean;
import cn.bean.UserFocus_Users;
import cn.bean.Users;

public interface UserFocus_UsersDao {
	
	//关注用户
	public boolean addfocus(Users user,Users user2);
	
	//取消关注
	public boolean delfocus(Users user,Users user2);
	
	//查询某用户所有关注
	public PageBean<UserFocus_Users> findAllFocus(Users user,int pageIndex,int pageSize);
	
	//查看用户是否被关注
	public boolean isfocus(Users user1 ,Users user2);

}
