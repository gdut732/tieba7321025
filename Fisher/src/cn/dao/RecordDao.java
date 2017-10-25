package cn.dao;

import cn.bean.PageBean;
import cn.bean.Record;
public interface RecordDao {
	//添加浏览记录
	public boolean addRecord(Record r);
	//显示所有浏览记录
	public PageBean<Record> getAllRecord(int pageIndex,int pageSize );
	//检查是否存在重复记录
	public boolean cheackUnoAndTno(int tno,int uno);
}
