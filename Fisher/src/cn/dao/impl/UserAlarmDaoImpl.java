package cn.dao.impl;

import java.sql.ResultSet;

import cn.bean.PageBean;
import cn.bean.UserAlarm;
import cn.bean.Users;
import cn.dao.Topic1Dao;
import cn.dao.UserAlarmDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserAlarmDaoImpl extends BaseDao<UserAlarm> implements UserAlarmDao
{
	private UsersDao ud=new UsersDaoImpl();
	private Topic1Dao t1d=new Topic1DaoImpl();
	@Override
	public PageBean<UserAlarm> findbyitems(Users user, int MsgType, int isread,int index,int size)
	{
		/*
		 * 1.回复 
		 * 2.私信 
		 * 3.点赞
		 * 4.系统通知 
		 * 5.被人@
		 */
		String sql="select * from useralarm where uno1="+user.getUno()+" and msgtype="+MsgType+" and isread="+isread;
		PageBean<UserAlarm> pb=this.getQueryPage(sql, index, size);
		if(pb!=null){
			return pb;
		}
		return null;
	}

	@Override
	public boolean delAlarm(Users user,int uano)
	{
		String sql="update useralarm set isread=0 where uano=?";
		return this.Update(sql,uano);
	}

	@Override
	public boolean addAlarm(UserAlarm ua)
	{
		ua.setUano(this.getNextId("useralarm"));
		String sql="insert into useralarm values (?,?,?,?,?,?,?)";
		return this.Update(sql,ua.getUser().getUno(),ua.getSender().getUno(),ua.getMsgtype(),ua.getMsg(),1,ua.getTopic1().getTno(),ua.getUano());
	}

	@Override
	public UserAlarm getEntity(ResultSet rs)
	{
		UserAlarm ua=null;
		try{
			ua=new UserAlarm();
			ua.setUser(ud.findById(rs.getInt("uno1")));
			ua.setSender(ud.findById(rs.getInt("uno2")));
			ua.setMsgtype(rs.getInt("msgtype"));
			ua.setMsg(rs.getString("msg"));
			ua.setTopic1(t1d.findByid(rs.getInt("tno1")));
			ua.setIsread(rs.getInt("isread"));
			ua.setUano(rs.getInt("uano"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ua;
	}

	@Override
	public int getAlarmCount(int uid) {
		String sql="from useralarm where isread=1 and uno1="+uid;
		return this.getCount(sql);
	}

}
