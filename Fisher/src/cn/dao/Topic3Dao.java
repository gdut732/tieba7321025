package cn.dao;


import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic2;
import cn.bean.Topic3;

public interface Topic3Dao {
	//�ظ�����������
	public boolean reply(Topic3 t3);
	//���ء����ᡢ
	public boolean delTopic(Topic3 t3,Topic2 t2);
	//��ʾ��ǰ���лظ�����
	public PageBean<Topic3> getAllTopic2(Topic3 t3,int pageIndex,int pageSize);
	//����Topic3�й�������Topic2�е�tno2�ļ�¼
	public boolean delAllTopic(Topic2 t2);
	//ͨ��tno2 �������е�tno3
	public List<Topic3> getAlltopic3(int tno2);
}
