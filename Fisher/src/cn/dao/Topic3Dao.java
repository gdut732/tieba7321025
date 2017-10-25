package cn.dao;


import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic2;
import cn.bean.Topic3;

public interface Topic3Dao {
	//回复层主主功能
	public boolean reply(Topic3 t3);
	//撤回、冻结、
	public boolean delTopic(Topic3 t3,Topic2 t2);
	//显示当前所有回复话题
	public PageBean<Topic3> getAllTopic2(Topic3 t3,int pageIndex,int pageSize);
	//冻结Topic3中关联所有Topic2中的tno2的记录
	public boolean delAllTopic(Topic2 t2);
	//通过tno2 查找所有的tno3
	public List<Topic3> getAlltopic3(int tno2);
}
