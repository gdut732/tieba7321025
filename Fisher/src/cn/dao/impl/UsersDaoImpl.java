package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.Users;
import cn.bean.userInfo;
import cn.dao.UserInfoDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UsersDaoImpl extends BaseDao<Users> implements UsersDao {

	@Override
	public Users Login(String login,String upwd ) {
		//登录名为用户的名字
		String sql = "select * from users where uname=? and upassword=?";
		if(getQuery(sql, login,upwd).size()>0)
			return getQuery(sql, login,upwd).get(0);
		//登录名为用户的手机
		sql = "select * from users where uphone=? and upassword=?";
		if(getQuery(sql, login,upwd).size()>0)
			return getQuery(sql, login,upwd).get(0);
		//登录名为用户的邮箱
		sql = "select * from users where uemail=? and upassword=?";
		if(getQuery(sql, login,upwd).size()>0)
			return getQuery(sql, login,upwd).get(0);
		return null;
	}

	@Override
	public Users Register(Users u) {
		String sql="insert into users values(?,?,?,?,?,?)";
		UserInfoDao uid = new UserInfoDaoImpl();
		
		int nextid = getNextId("users");
		if(Update(sql, nextid,u.getUname(),u.getUemail(),u.getUphone(),u.getUpwd(),u.getUheadimg()))
		{
			
			u.setUno(nextid);
			userInfo ui = new userInfo(u, null, null, null, getNowDate(), 0, null, 0);
			uid.adduserinfo(ui);
			return u;
		}
		return null;
	}

	@Override
	public boolean cheak(String name,int checkType) {
		if(checkType==1)
		{
			String sql="select * from users where uname=?";
			if(getQuery(sql, name).size()>0)
				return true;
		}
		else if(checkType==2)
		{
			String sql="select * from users where uphone=?";
			if(getQuery(sql, name).size()>0)
				return true;
		}
		else if(checkType==3)
		{
			String sql="select * from users where uemail=?";
			if(getQuery(sql, name).size()>0)
				return true;
		}
		return false;
	}

	@Override
	public boolean updateInfo(Users user) {

		String sql="update users set uname=?";
		StringBuffer sb= new StringBuffer(sql);
		if(user.getUemail()!=null)
		{
			sb.append(",uemail='"+user.getUemail()+"'");
		}
		if(user.getUheadimg()!=null)
		{
			sb.append(",uheadimg='"+user.getUheadimg()+"'");
		}
		if(user.getUphone()!=null)
		{
			sb.append(",uphone='"+user.getUphone()+"'");
		}
		if(user.getUpwd()!=null)
		{
			sb.append(",upassword='"+user.getUpwd()+"'");
		}
		sb.append(" where uno=?");
		System.out.println(sb.toString());
		return Update(sb.toString(), user.getUname(),user.getUno());
	}

	@Override
	public Users findById(int id) {
		String sql ="select * from users where uno=?";
		Users u = getQuery(sql, id).get(0);
		if(u.getUpwd()!=null)
		{
			return u;
		}
		return null;
	}

	@Override
	public List<Users> findByItems(Users user) {
		
		String sql = "select * from users where 1=1";
		StringBuffer sb = new StringBuffer(sql);
		if(user.getUname()!=null)
		{
			sb.append(" and uname like %'"+user.getUname()+"'%");
		}
		if(user.getUemail()!=null)
		{
			sb.append(" and uemail like %'"+user.getUemail()+"'%");
		}
		if(user.getUphone()!=null)
		{
			sb.append(" and uphone=like %'"+user.getUphone()+"'%");
		}
		List<Users> u = getQuery(sb.toString());
		if(u.size()>0)
			return u;
		return null;
	}

	@Override
	public Users getEntity(ResultSet rs) {
		Users u = new Users();
		try 
		{
			u.setUno(rs.getInt(1));
			u.setUname(rs.getString(2));
			u.setUemail(rs.getString(3));
			u.setUphone(rs.getString(4));
			u.setUpwd(rs.getString(5));
			u.setUheadimg(rs.getString(6));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public Users findbyname(String uname) {
		String sql = "select * from users where uname=?";
		if(getQuery(sql, uname).size()>0)
		{
			return getQuery(sql, uname).get(0);
		}
		return null;
	}

}
