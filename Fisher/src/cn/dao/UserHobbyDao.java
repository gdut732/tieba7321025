package cn.dao;

import java.util.List;

import cn.bean.UserHobby;
import cn.bean.Users;

public interface UserHobbyDao {

	
	//��������
	public boolean addHobby(Users user,String strhobby);
	
	//ɾȥ����
	public boolean delHobby(Users user);
	
	//��ѯĳ�û�����
	public String findbyUno(Users user);
	
}
