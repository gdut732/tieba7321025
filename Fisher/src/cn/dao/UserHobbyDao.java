package cn.dao;

import java.util.List;

import cn.bean.UserHobby;
import cn.bean.Users;

public interface UserHobbyDao {

	
	//新增爱好
	public boolean addHobby(Users user,String strhobby);
	
	//删去爱好
	public boolean delHobby(Users user);
	
	//查询某用户爱好
	public String findbyUno(Users user);
	
}
