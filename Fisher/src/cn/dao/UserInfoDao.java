package cn.dao;

import cn.bean.Users;
import cn.bean.userInfo;

public interface UserInfoDao {

	//�����û���Ϣ������,ǩ���������յ��ޱ�־λ��
	public boolean updateUserInfo(userInfo userinfo);
	
	//ͨ��uno����
	public userInfo findByNo(Users user);
	
	//�����û���Ϣ
	public boolean adduserinfo(userInfo ui);
}
