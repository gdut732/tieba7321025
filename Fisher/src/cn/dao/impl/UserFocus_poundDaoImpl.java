package cn.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.UserFocus_pound;
import cn.bean.Users;
import cn.dao.FishPoundDao;
import cn.dao.UserFocus_poundDao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class UserFocus_poundDaoImpl extends BaseDao<UserFocus_pound> implements
		UserFocus_poundDao
{
	
	@Override
	public boolean focus_pound(Users user,FishPond fp)
	{
		String sql= "insert into UserFocus_pound values(?,?,?,?)";
		return Update(sql, user.getUno(),fp.getNo(),1,0);
	}

	@Override
	public boolean disfocus_pound(Users user,FishPond fp)
	{
		String sql ="delete from UserFocus_pound where uno=? and tno1=?";
		return Update(sql, user.getUno(),fp.getNo());
	}

	@Override
	public PageBean<UserFocus_pound> findByUno(Users user, int pageIndex,
			int pageSize)
	{
		String sql = "select * from UserFocus_pound where uno="+user.getUno();
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public boolean updateLvOrExp(UserFocus_pound ufp)
	{
		String sql = "update UserFocus_pound set level=? ,exp=? where uno=?";
		return Update(sql,ufp.getLevel(),ufp.getExp(),ufp.getUser().getUno());
	}
	
	@Override
	public UserFocus_pound getEntity(ResultSet rs)
	{
		UserFocus_pound ufp = new UserFocus_pound();
		try{
			FishPoundDao fpd=new FishPoundDaoImpl();
			UsersDao ud=new UsersDaoImpl();
			ufp.setFishpond(fpd.findFishPondByID(rs.getInt("tno1")));
			ufp.setUser(ud.findById(rs.getInt("uno")));
			ufp.setExp(rs.getLong("exp"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ufp;
	}

	@Override
	public int getThisPoundCollNum(int tno) {

		int num=0;
		num=this.getCount("from UserFocus_pound where tno1="+tno);
		return num;
	}

	@Override
	public boolean IsFocusPound(int uno, int pno) {
		String sql="select * from UserFocus_pound where uno=? and tno1=?";
		List<UserFocus_pound> ls=this.getQuery(sql, uno,pno);
		if(ls.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public UserFocus_pound findbyunopno(int uno, int pon)
	{
		String sql= "select * from UserFocus_pound where uno=? and tno1=?";
		if(getQuery(sql,uno,pon).size()>0)
		{
			return getQuery(sql,uno,pon).get(0);
		}
		return null;
	}

	

}
