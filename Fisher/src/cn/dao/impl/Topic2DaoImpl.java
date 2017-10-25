package cn.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic2;
import cn.dao.Topic1Dao;
import cn.dao.Topic2Dao;
import cn.dao.Topic3Dao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class Topic2DaoImpl extends BaseDao<Topic2> implements Topic2Dao{
	private Topic1Dao td1=new Topic1DaoImpl();
	private UsersDao ud=new UsersDaoImpl();
	@Override
	public boolean reply(Topic2 t2)
	{	
		t2.setTno(this.getNextId("topic2"));
		t2.setCreatedate(this.getNowDate());
		t2.setStatus(0);
		String sql="insert into topic2 values(?,?,?,?,TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),?)";
		return this.Update(sql,t2.getTno(),t2.getUno().getUno(),t2.getContent(),t2.getTno1().getTno(),t2.getCreatedate(),t2.getStatus());
	}

	@Override
	public boolean delTopic(Topic2 t2,boolean alldel)
	{
		Topic3Dao td3=new Topic3DaoImpl();
		String sql="update topic2 set status=1 where ";
		if(alldel){
			//冻结topic2所有的记录
			 sql = sql+"tno1="+t2.getTno1().getTno();
			 td3.delAllTopic(t2);
		}
		else{
			//冻结topic2一条记录
			 sql = sql+"tno="+t2.getTno();
			//冻结topic3中对应tno2的所有记录
			 td3.delTopic(null, t2);
		}
		
		return Update(sql);
	}

	@Override
	public PageBean<Topic2> getAllTopic2(Topic2 t2 ,int index,int size)
	{	
		String sql="select * from where tno="+t2.getTno();
		PageBean<Topic2> pb=this.getQueryPage(sql, index, size);
		if(pb!=null){
			return pb;
		}
		return null;
	}

	@Override
	public Topic2 getEntity(ResultSet rs)
	{
		Topic2 t2=null;
		try
		{
			t2=new Topic2();
			t2.setTno(rs.getInt("tno"));
			t2.setUno(ud.findById(rs.getInt("uno")));
			t2.setContent(rs.getString("content"));
			t2.setTno1(td1.findByid(rs.getInt("tno1")));
			t2.setCreatedate(rs.getString("createdate"));
			t2.setStatus(rs.getInt("status"));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return t2;
	}

	@Override
	public Topic2 findTopic2ByID(int id)
	{
		String sql="select * from topic2 where tno=?";
		if(getQuery(sql, id).size()>0)
		{
			return getQuery(sql, id).get(0);
		}
		return null;
	}

	@Override
	public PageBean<Topic2> findbytno1(int tno1,int pageIndex,int pageSize,int type)
	{
		String sql = "select * from topic2 where tno1="+tno1;
		if(type==1)
		{
			sql=sql+" order by tno desc";
		}
		else
		{
			sql=sql+" order by tno asc";
		}
		System.out.println("sql========"+sql);
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public PageBean<Topic2> findbycengzhu(int tno1, int pageIndex, int pageSize) {
		String sql = "select * from topic2 where uno in (select uno from topic1 where tno="+tno1+")";
		System.out.println("sql========"+sql);
		return getQueryPage(sql, pageIndex, pageSize);
	}
	
}