package cn.dao;

import java.util.List;

import cn.bean.Users;


public interface UsersDao {
	
	//��¼
	public  Users  Login(String login,String upwd);
	
	//ע��
	public Users Register(Users u);
	
	//�û������
	public boolean cheak(String name,int checkType);
	
	//������Ϣ���ֻ���email��ͷ��
	public boolean updateInfo(Users user);
	
	//ͨ��id��ѯ�û�
	public Users findById(int id);
	
	//��������ƥ���û�
	public List<Users> findByItems(Users user);
	
	//ͨ�����ֲ����û�
	public Users findbyname(String uname);
	
}
