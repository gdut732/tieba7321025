package cn.dao;

import cn.bean.PageBean;
import cn.bean.UserFocus_Users;
import cn.bean.Users;

public interface UserFocus_UsersDao {
	
	//��ע�û�
	public boolean addfocus(Users user,Users user2);
	
	//ȡ����ע
	public boolean delfocus(Users user,Users user2);
	
	//��ѯĳ�û����й�ע
	public PageBean<UserFocus_Users> findAllFocus(Users user,int pageIndex,int pageSize);
	
	//�鿴�û��Ƿ񱻹�ע
	public boolean isfocus(Users user1 ,Users user2);

}
