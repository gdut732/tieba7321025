package cn.dao;

import cn.bean.Topic1;
import cn.bean.Users;

public interface UserLikeDao {

	
	//�ж�ĳ�û��Ƿ���޹�ĳ����
	public boolean checklike(Users user,Topic1 topic1);
	
	//����
	public boolean likeit(Users user,Topic1 topic1);
	
	//ȡ������
	public boolean dontlike(Users user,Topic1 topic1);
}
