package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic2;
import cn.bean.Topic3;
import cn.dao.Topic2Dao;
import cn.dao.Topic3Dao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class Topic3DaoImpl extends BaseDao<Topic3> implements Topic3Dao {

	private UsersDao ud = new UsersDaoImpl();
	
	@Override
	public boolean reply(Topic3 t3) {
		String sql ="insert into topic3 values(?,?,?,?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss'),0,?)";
		return Update(sql, getNextId("topic3"),t3.getUno1().getUno(),t3.getUno2().getUno(),t3.getUno3().getUno(),t3.getContent(),getNowDate(),t3.getTopic2().getTno());
	}

	@Override
	public boolean delTopic(Topic3 t3,Topic2 t2) {
		String sql="update topic3 set status=1 where ";
		if(t2.getTno()!=0){
			//冻结Topic3中关联tno2的所有记录
			 sql = sql+"tno2="+t2.getTno();
		}
		else{
			//冻结Topic3中指定tno的一条记录
			 sql = sql+"tno="+t3.getTno3();
		}
		return Update(sql);
	}
	
	@Override
	public PageBean<Topic3> getAllTopic2(Topic3 t3,int pageIndex,int pageSize) {
		String sql ="select * from topic3 where tno2="+t3.getTopic2().getTno();
		return getQueryPage(sql, pageIndex, pageSize);
	}

	@Override
	public Topic3 getEntity(ResultSet rs) {
		Topic3 t3  = new Topic3();
		Topic2Dao t2d = new Topic2DaoImpl(); 
		try
		{
			t3.setTno3(rs.getInt("tno"));
			t3.setTopic2(t2d.findTopic2ByID(rs.getInt("tno2")));
			t3.setUno1(ud.findById(rs.getInt("uno1")));
			t3.setUno2(ud.findById(rs.getInt("uno2")));
			t3.setUno3(ud.findById(rs.getInt("uno3")));
			t3.setContent(rs.getString("CONTENT"));
			t3.setCreatedate(rs.getString("CREATEDATE"));
			t3.setStatus(rs.getInt("STATUS"));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return t3;
	}

	@Override
	public boolean delAllTopic(Topic2 t2)
	{
		String sql="update t3 set status=1 where tno2 in (select tno2 from topic2 where tno1=?)";
		return this.Update(sql, t2.getTno1().getTno());
	}

	@Override
	public List<Topic3> getAlltopic3(int tno2) {
		String sql = "select * from topic3 where tno2="+tno2+" order by tno asc";
		return getQuery(sql);
	}

}
