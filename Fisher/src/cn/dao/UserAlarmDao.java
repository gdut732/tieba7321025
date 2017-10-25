package cn.dao;


import cn.bean.PageBean;
import cn.bean.UserAlarm;
import cn.bean.Users;

public interface UserAlarmDao {

	
	//通过id查询不同类型的信息(1已读或者0未读)
	public PageBean<UserAlarm> findbyitems(Users user,int MsgType,int isread,int index,int size);
	
	//删除信息 
	public boolean delAlarm(Users user,int uano);
	
	//发送消息
	public boolean addAlarm(UserAlarm ua);
	
	//读取用户收到的未度消息数量
	public int getAlarmCount(int uid);
}
