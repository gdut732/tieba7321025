package cn.dao;


import cn.bean.PageBean;
import cn.bean.UserAlarm;
import cn.bean.Users;

public interface UserAlarmDao {

	
	//ͨ��id��ѯ��ͬ���͵���Ϣ(1�Ѷ�����0δ��)
	public PageBean<UserAlarm> findbyitems(Users user,int MsgType,int isread,int index,int size);
	
	//ɾ����Ϣ 
	public boolean delAlarm(Users user,int uano);
	
	//������Ϣ
	public boolean addAlarm(UserAlarm ua);
	
	//��ȡ�û��յ���δ����Ϣ����
	public int getAlarmCount(int uid);
}
