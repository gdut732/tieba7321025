package cn.dao;

import cn.bean.PageBean;
import cn.bean.Record;
public interface RecordDao {
	//��������¼
	public boolean addRecord(Record r);
	//��ʾ���������¼
	public PageBean<Record> getAllRecord(int pageIndex,int pageSize );
	//����Ƿ�����ظ���¼
	public boolean cheackUnoAndTno(int tno,int uno);
}
