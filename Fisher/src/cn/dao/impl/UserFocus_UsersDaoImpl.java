package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bean.PageBean;
import cn.bean.UserFocus_Users;
import cn.bean.Users;
import cn.dao.UserFocus_UsersDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserFocus_UsersDaoImpl extends BaseDao<UserFocus_Users> implements
		UserFocus_UsersDao
{
	private UsersDao ud = new UsersDaoImpl();
	@Override
	public boolean addfocus(Users user, Users user2)
	{
		String sql = "insert into UserFocus_User values(?,?)";
		return Update(sql, user.getUno(),user2.getUno());
	}

	@Override
	public boolean delfocus(Users user, Users user2)
	{
		String sql = "delete from UserFocus_User where uno1=? and uno2=?";
		return Update(sql, user.getUno(),user2.getUno());
	}

	@Override
	public PageBean<UserFocus_Users> findAllFocus(Users user,int pageIndex , int pageSize)
	{
		String sql = "select * from UserFocus_User where uno1="+user.getUno();
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public UserFocus_Users getEntity(ResultSet rs)
	{
		UserFocus_Users ufu= new UserFocus_Users();
		try
		{
			ufu.setUser1(ud.findById(rs.getInt("uno1")));
			ufu.setUser2(ud.findById(rs.getInt("uno2")));
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ufu;
	}

	@Override
	public boolean isfocus(Users user1, Users user2) {
		String sql =  "select * from UserFocus_User where uno1=? and uno2=?";
		return getQuery(sql, user1.getUno(),user2.getUno()).size()>0;
	}

}
