package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.PageBean;
import cn.bean.UserColl_topic;
import cn.bean.Users;
import cn.dao.Topic1Dao;
import cn.dao.UserColl_topicDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserColl_topicDaoImpl extends BaseDao<UserColl_topic> implements
		UserColl_topicDao
{
	private UsersDao ud = new UsersDaoImpl();
	private Topic1Dao td1=new Topic1DaoImpl();
	@Override
	public boolean Coll_topic(UserColl_topic uct)
	{
		String sql = "insert into UserColl value(?,?)";
		return Update(sql, uct.getUser().getUno(),uct.getTopic1().getTno());
	}

	@Override
	public boolean disColl_topic(UserColl_topic uct)
	{
		String sql = "del UserColl where uno=? and tno=?  ";
		return Update(sql, uct.getUser().getUno(),uct.getTopic1().getTno());
	}

	@Override
	public PageBean<UserColl_topic> allColl_topic(Users user,int pageIndex,int pageSize)
	{
		String sql = "select * from UserColl where uno="+user.getUno();
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public UserColl_topic getEntity(ResultSet rs)
	{
		UserColl_topic uct = new UserColl_topic();
		try
		{
			uct.setUser(ud.findById(rs.getInt(1)));
			uct.setTopic1(td1.findByid(rs.getInt(2)));
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return uct;
	}

}
