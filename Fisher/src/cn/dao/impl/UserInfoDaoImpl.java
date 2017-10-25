package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.Users;
import cn.bean.userInfo;
import cn.dao.UserInfoDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserInfoDaoImpl extends BaseDao<userInfo> implements UserInfoDao {

	@Override
	public boolean updateUserInfo(userInfo userinfo) {

		String sql = "update userinfo set status="+userinfo.getStatus();
		StringBuffer sb = new StringBuffer(sql);
		
		if(userinfo.getSign()!=null)
		{
			sb.append(",sign='"+userinfo.getSign()+"'");
		}
		if(userinfo.getSignIn()>1)
		{
			sb.append(",signn='"+userinfo.getSignIn()+"'");
		}
		if(userinfo.getRealname()!=null)
		{
			sb.append(",Realname='"+userinfo.getRealname()+"'");
		}
		if(userinfo.getSex()!=null)
		{
			sb.append(",sex='"+userinfo.getSex()+"'");
		}
		if(userinfo.getIdnumber()!=null)
		{
			sb.append(",Idnumber='"+userinfo.getIdnumber()+"'");
		}
		sb.append(" where uno="+userinfo.getUsers().getUno());
		return Update(sb.toString());
	}

	@Override
	public userInfo findByNo(Users user) {
		String sql = "select * from userinfo where uno=?";
		List<userInfo> ui = getQuery(sql, user.getUno());
		if(ui.size()>0)
			return ui.get(0);
		return null;
	}
	
	@Override
	public boolean adduserinfo(userInfo ui) {
		//INSERT INTO userinfo VALUES (5, '辩题','哈哈', 'src/df',1,1,(数据库格式对应是TimeStamp)TO_DATE('1992-05-12 13:12:46', 'yyyy-mm-dd hh24:mi:ss'),1);
		String sql = "insert into userinfo values(?,?,?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss'),?,?,?)";
		return Update(sql, ui.getUsers().getUno(),ui.getSex(),ui.getRealname(),ui.getIdnumber(),ui.getCreateDate(),ui.getStatus(),ui.getSign(),ui.getSignIn());
	}


	@Override
	public userInfo getEntity(ResultSet rs) {
		userInfo ui = new userInfo();
		UsersDao ud = new UsersDaoImpl();
		try
		{
			ui.setUsers(ud.findById(rs.getInt(1)));
			ui.setSex(rs.getString(2));
			ui.setRealname(rs.getString(3));
			ui.setIdnumber(rs.getString(4));
			ui.setCreateDate(rs.getString(5));
			ui.setStatus(rs.getInt(6));
			ui.setSign(rs.getString(7));
			ui.setSignIn(rs.getInt(8));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ui;
	}

	
}
