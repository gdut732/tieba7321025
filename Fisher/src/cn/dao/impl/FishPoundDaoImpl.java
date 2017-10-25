package cn.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.dao.FishPoundDao;
import cn.dao.LabelDao;
import cn.dao.Topic1Dao;
import cn.dao.impl.LabelDaoImpl;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;

public class FishPoundDaoImpl extends BaseDao<FishPond> implements FishPoundDao{
	private Topic1Dao td1=new Topic1DaoImpl();

	
	@Override
	public FishPond getEntity(ResultSet rs) {
		UsersDao ud = new UsersDaoImpl();
		LabelDao ld = new LabelDaoImpl();
		FishPond pd=null;
		try{
			pd=new FishPond();
			pd.setUno(ud.findById(rs.getInt("uno")));
			pd.setTitle(rs.getString("title"));
			pd.setStatus(rs.getInt("status"));
			pd.setSign(rs.getString("sign"));
			pd.setNo(rs.getInt("fno"));
			pd.setLno(ld.findLabelByID(rs.getInt("lno")));
			pd.setHeadimg(rs.getString("headimg"));
			pd.setCreatedate(rs.getString("createddate"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public List<FishPond> getLikeNameList(String name) {

		String sql="select * from fishpond where title like '%"+name+"%'";
		return getQuery(sql);
	}

	@Override
	public PageBean<FishPond> getAllFishPound(int size, int index) {

		String sql="select * from fishpond where status=0 order by fno desc";
		return getQueryPage(sql, index, size);
	}
	
	@Override
	public boolean createFishPound(FishPond fishpound) {
		//²åÈëÀý¾ä£º
		//INSERT INTO FISHPOND VALUES (5, '±çÌâ','¹þ¹þ', 'src/df',1,1,TO_DATE('1992-05-12 13:12:46', 'yyyy-mm-dd hh24:mi:ss'),1);
		String nowtime=this.getNowDate();
		fishpound.setNo(this.getNextId("fishpond"));
		fishpound.setCreatedate(nowtime);
		String sql="insert into fishpond values (?,?,?,?,?,?,TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),?)";
		return this.Update(sql, fishpound);
	}
	
	@Override
	public boolean updateFishPound(FishPond fishpound) {
		FishPond fp=this.findFishPondByID(fishpound.getNo());
		String sql="update fishpond set createddate="+fp.getCreatedate();
		StringBuffer sb=new StringBuffer(sql);
		if(fishpound.getTitle()!=null){
			sb.append(",title="+fishpound.getTitle());
		}
		if(fishpound.getSign()!=null){
			sb.append(",sign="+fishpound.getSign());
		}
		if(fishpound.getHeadimg()!=null){
			sb.append(",headimg="+fishpound.getHeadimg());
		}
		if(fishpound.getUno().getUno()!=0){
			sb.append(",uno="+fishpound.getUno().getUno());
		}
		sb.append(" where fno=?");
		return this.Update(sb.toString(), fishpound.getNo());
	}

	@Override
	public boolean checkName(String name) {
		String sql="select * from fishpond where title=?";
		return this.Update(sql, name);
	}

	@Override
	public FishPond findFishPondByID(int ID) {
		String sql="select * from fishpond where fno=?";
		List<FishPond> ls=this.getQuery(sql, ID);
		FishPond fd=null;
		if(ls.size()>0){
			fd=(FishPond)ls.get(0);
		}
		return fd;
	}

	@Override
	public boolean freezeFishPound(int ID)
	{
		String sql="update fishpond set status=1 where pno=?";
		if(this.Update(sql, ID)){	
			Topic1 t1=new Topic1();
			t1.setFp(this.findFishPondByID(ID));			
			return td1.delTopic1(t1, true);
		}
		return false;
	}

	@Override
	public PageBean<FishPond> findLabelFishPound(int id, int size, int index) {
		String sql="select * from fishpond where status=0 and lno="+id;
		return this.getQueryPage(sql,index, size);
	}

	@Override
	public FishPond getFishPound(int no) {
		String sql="select * from fishpond where fno=?";
		FishPond fp=null;
		List<FishPond> ls=this.getQuery(sql, no);
		if(ls.size()>0){
			fp=new FishPond();
			fp=ls.get(0);
			return fp;
		}
		return null;
	}

}
