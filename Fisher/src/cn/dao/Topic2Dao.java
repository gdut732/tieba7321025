package cn.dao;

import cn.bean.PageBean;
import cn.bean.Topic2;

public interface Topic2Dao {
	//�ظ���������
	public boolean reply(Topic2 t2);
	//���ء����ᡢ
	public boolean delTopic(Topic2 t2,boolean alldel);
	//��ʾ��ǰ���лظ�����
	public PageBean<Topic2> getAllTopic2(Topic2 t2 ,int index,int size);
	//���ҵ���Topic2
	public Topic2 findTopic2ByID(int id);
	//����ĳ��������лظ�
	/*
	 * 1����
	 * 2����
	 */
	public PageBean<Topic2> findbytno1(int tno1,int pageIndex,int pageSize,int type);
	//ֻ��¥����
	public PageBean<Topic2> findbycengzhu(int tno1,int pageIndex,int pageSize);
}
