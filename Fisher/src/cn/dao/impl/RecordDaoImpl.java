package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Record;
import cn.bean.Topic1;
import cn.dao.RecordDao;
import cn.dao.Topic1Dao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class RecordDaoImpl extends BaseDao<Record> implements RecordDao
{
	
	private UsersDao ud=new UsersDaoImpl();
	private Topic1Dao tc1=new Topic1DaoImpl();

	@Override
	public boolean addRecord(Record r)
	{
		boolean flage=cheackUnoAndTno(r.getTno1().getTno(), r.getUno().getUno());
		if(flage==false){
			String sql="insert into record values(?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss'))";
			String nowDate=getNowDate();
			return Update(sql, r.getUno().getUno(),r.getTno1().getTno(),nowDate);
		}
		return false;
	}

	@Override
	public PageBean<Record> getAllRecord(int pageIndex,int pageSize)
	{
		String sql="select * from record";
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public Record getEntity(ResultSet rs)
	{
		Record rc=new Record();
		try
		{
			rc.setUno(ud.findById(rs.getInt(1)));
			rc.setTno1(tc1.findByid(rs.getInt(2)));
			rc.setCreatedate(rs.getString(3));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rc;
	}

	@Override
	public boolean cheackUnoAndTno(int tno, int uno) {
		String sql="select * from record where uno=? and tno=?";
		List<Record> ls=this.getQuery(sql, uno,tno);
		if(ls.size()>0){
			return true;
		}
		return false;
	}
	
}
