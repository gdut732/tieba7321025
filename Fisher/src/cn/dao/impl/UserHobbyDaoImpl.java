package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.UserHobby;
import cn.bean.Users;
import cn.dao.UserHobbyDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserHobbyDaoImpl extends BaseDao<UserHobby> implements
		UserHobbyDao
{

	private UsersDao ud = new UsersDaoImpl();
	@Override
	public boolean addHobby(Users user, String strhobby)
	{
		String sql = "insert into userhoby values(?,?)";
		return Update(sql, user.getUno(),strhobby);
	}

	@Override
	public boolean delHobby(Users user)
	{
		String sql = "delete from userhobby where uno=? ";
		return Update(sql, user.getUno());
	}

	@Override
	public String findbyUno(Users user)
	{
		String sql = "select * from userhobby where uno=?";
		List<UserHobby> luh= getQuery(sql, user.getUno());
		if(luh.size()>0)
		{
			return luh.get(0).getHobby();
		}
		return null;
	}

	@Override
	public UserHobby getEntity(ResultSet rs)
	{
		UserHobby uh= new UserHobby();
		try
		{
			uh.setUsers(ud.findById(rs.getInt(1)));
			uh.setHobby(rs.getString(2));
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return uh;
	}

}
