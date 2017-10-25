package cn.dao;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;

public interface Topic1Dao {
	//发布一个小话题
	public boolean AddTopic1(Topic1 t1);
	//删除单个小话题
	public boolean delTopic1(Topic1 t1,boolean alldel);
	//通过ID查询获取话题
	public Topic1 findByid(int tid); 
	//模糊搜索  筛选出名称类似小话题
	public List<Topic1> getLikeNameList(String name,int pno);
	//列出所有小话题     (鱼塘ID,排序显示) 
	//1.最新时间发布
	//2.浏览次数高低
	public PageBean<Topic1> getAllTopicList(int pno,int px,int pageIndex,int pageSize);
	//管理员直接查出所有话题
	public PageBean<Topic1> getAll(int pageIndex,int pageSize);
	//显示热议榜小话题（点击率最高的）
	public PageBean<Topic1> getHotTopicList();
	//通过uno查询所有用户帖子数
	public int findUserTopicCount(Users user);
	//查询某用户的帖子
	public PageBean<Topic1> findUserTopic(Users user,int pageIndex,int pageSize);
	//获取指定Tno的小话题的总数
	public int getThisPoundTopic1Num(int pno);
}
