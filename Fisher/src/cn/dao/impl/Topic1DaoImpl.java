package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Topic2;
import cn.bean.Users;
import cn.dao.FishPoundDao;
import cn.dao.Topic1Dao;
import cn.dao.Topic2Dao;
import cn.dao.UsersDao;
import cn.dbc.BaseDao;
import cn.utils.ImageUtils;

public class Topic1DaoImpl extends BaseDao<Topic1> implements Topic1Dao {

	
	private UsersDao ud = new UsersDaoImpl();
	
	@Override
	public Topic1 findByid(int tid) {
		String sql = "select * from topic1 where tno=?";
		List<Topic1> lt = getQuery(sql, tid);
		if(lt.size()>0)
		{
			return lt.get(0);
		}
		return null;
	}

	
	@Override
	public boolean AddTopic1(Topic1 t1) {
		String sql = "insert into topic1 values(?,?,?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss'),?,?)";
		return Update(sql, (getNextId("topic1")),t1.getTitle(),t1.getUno().getUno(),t1.getContent(),this.getNowDate(),t1.getStatus(),t1.getFp().getNo());
	}

	@Override
	public boolean delTopic1(Topic1 t1,boolean alldel) {
		Topic2Dao td2=new Topic2DaoImpl();
		String sql ="update topic1 set status=? where";
		int t = 0;
		if(alldel){
			sql="UPDATE topic3 set status=1 where tno2 in "
					+ "(SELECT tno2 from topic2 where tno1 in "
					+ "(SELECT tno1 from topic1 where pno=?))";
			t=t1.getFp().getNo();
			
		}else{
			//通过tno1删除单个topic1的记录，包括关联topic1的所有topic2记录
			sql=sql+" tno=?";
			Topic2 t2=new Topic2();
			t2.setTno1(t1);
			td2.delTopic(t2, true);
			t=t1.getTno();		
			}
		return Update(sql,t);
	}

	@Override
	public List<Topic1> getLikeNameList(String name,int pno) {
		String sql = "select * from topic1 where title like '%"+name+"%' and pno="+pno;
		if(pno==0){
			sql="select * from topic1 where title like '%"+name+"%'";
		}
		return getQuery(sql);
	}

	//列出所有小话题     (鱼塘ID,排序显示) 
		//0.无需要Pno就得到所有鱼塘中的推荐话题 
		//1.最新时间发布
		//2.浏览次数高低
	@Override
	public PageBean<Topic1> getAllTopicList(int pno, int px,int pageIndex,int pageSize) {
		if(px==2){
			String sql = "select t.tno,t.title,t.uno,t.content,t.createdate,t.status,t.pno from record r RIGHT JOIN topic1 t on  t.tno = r.tno where pno="+pno+" GROUP BY t.tno,t.title,t.uno,t.content,t.createdate,t.status,t.pno ORDER BY count(r.tno) desc";
			return getQueryPage(sql, pageIndex, pageSize);
		}
		else if(px==1){
			String sql = "select * from topic1 where pno="+pno+" and status=0 order by tno desc";
			return getQueryPage(sql, pageIndex, pageSize);
		}else{
			String sql = "select * from topic1 where status=0 order by tno desc";
			return getQueryPage(sql, pageIndex, pageSize);
		}
	}

	@Override
	public Topic1 getEntity(ResultSet rs) {
		Topic1 t1 = new Topic1();
		
  		FishPoundDao fpd = new FishPoundDaoImpl();
		try 
		{
			t1.setTno(rs.getInt("tno"));
			t1.setFp(fpd.findFishPondByID(rs.getInt("pno")));
			t1.setTitle(rs.getString("title"));
			t1.setUno(ud.findById(rs.getInt("uno")));
			ImageUtils iu = new ImageUtils(rs.getString("content"));
			t1.setContent(iu.getContent());
			t1.setImagesrc(iu.getImageList());
			t1.setCreatedate(rs.getString("CREATEDATE"));
			t1.setStatus(rs.getInt("status"));
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return t1;
	}


	@Override
	public PageBean<Topic1> getAll(int pageIndex, int pageSize) {
		String sql = "select * from topic1";
		return getQueryPage(sql, pageIndex, pageSize);
	}


	@Override
	public PageBean<Topic1> getHotTopicList() {
		//String sql="select * from topic1 where tno in(select tno from record where tno in (select tno from record group by tno having count(tno)> 1) GROUP by tno)";
		String sql="select t1.tno,t1.title,t1.content,t1.createdate,t1.pno,t1.status,t1.uno from topic1 t1 right join record r on r.tno=t1.tno group by t1.tno,t1.title,t1.content,t1.createdate,t1.pno,t1.status,t1.uno order by count(t1.tno) desc";
		PageBean<Topic1> pb=this.getQueryPage(sql, 1, 10);
		if(pb!=null){
			return pb;
		}
		return null;
	}


	@Override
	public int findUserTopicCount(Users user)
	{
		String sql = "select * from topic1 where uno=?";
		List<Topic1> lt = getQuery(sql, user.getUno());
		return lt.size();
	}


	@Override
	public PageBean<Topic1> findUserTopic(Users user,int pageIndex,int pageSize)
	{
		String sql = "select * from topic1 where uno="+user.getUno();
		return getQueryPage(sql, pageIndex, pageSize);
	}


	@Override
	public int getThisPoundTopic1Num(int pno) {
		int num=0;
		num=this.getCount("from topic1 where pno="+pno);
		return num;
	}



}
