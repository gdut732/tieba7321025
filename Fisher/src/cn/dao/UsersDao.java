package cn.dao;

import java.util.List;

import cn.bean.Users;


public interface UsersDao {
	
	//登录
	public  Users  Login(String login,String upwd);
	
	//注册
	public Users Register(Users u);
	
	//用户名检测
	public boolean cheak(String name,int checkType);
	
	//更新信息（手机，email，头像）
	public boolean updateInfo(Users user);
	
	//通过id查询用户
	public Users findById(int id);
	
	//条件查找匹配用户
	public List<Users> findByItems(Users user);
	
	//通过名字查找用户
	public Users findbyname(String uname);
	
}
