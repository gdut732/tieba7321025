package cn.dao;

import cn.bean.PageBean;
import cn.bean.Topic2;

public interface Topic2Dao {
	//回复塘主功能
	public boolean reply(Topic2 t2);
	//撤回、冻结、
	public boolean delTopic(Topic2 t2,boolean alldel);
	//显示当前所有回复话题
	public PageBean<Topic2> getAllTopic2(Topic2 t2 ,int index,int size);
	//查找单个Topic2
	public Topic2 findTopic2ByID(int id);
	//查找某话题的所有回复
	/*
	 * 1正序
	 * 2倒叙
	 */
	public PageBean<Topic2> findbytno1(int tno1,int pageIndex,int pageSize,int type);
	//只看楼主的
	public PageBean<Topic2> findbycengzhu(int tno1,int pageIndex,int pageSize);
}
