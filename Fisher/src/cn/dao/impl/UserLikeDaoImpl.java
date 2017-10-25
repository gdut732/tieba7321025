package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.Topic1;
import cn.bean.UserLike;
import cn.bean.Users;
import cn.dao.Topic1Dao;
import cn.dao.UserLikeDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserLikeDaoImpl extends BaseDao<UserLike> implements UserLikeDao {

	private UsersDao ud = new UsersDaoImpl();
	private Topic1Dao td = new Topic1DaoImpl();
	@Override
	public boolean checklike(Users user, Topic1 topic1) {
		String sql = "select * from userlike where uno=? and tno=?";
		UserLike ul = getQuery(sql, user.getUno(),topic1.getTno()).get(0);
		if(ul.getTopic1()!=null)
			return true;
		return false;
	}

	@Override
	public boolean likeit(Users user, Topic1 topic1) {
		String sql = "insert into userlike value(?,?)";
		return Update(sql, user.getUno(),topic1.getTno());
	}

	@Override
	public boolean dontlike(Users user, Topic1 topic1) {
		String sql = "delete from userlike where uno=? and tno=?";
		return Update(sql, user.getUno(),topic1.getTno());
	}

	@Override
	public UserLike getEntity(ResultSet rs) {
		UserLike ul = new UserLike();
		try 
		{
			ul.setUser(ud.findById(rs.getInt(1)));
			ul.setTopic1(td.findByid(rs.getInt(2)));
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ul;
	}

}
