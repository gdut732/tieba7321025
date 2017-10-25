package cn.dao;
import java.util.List;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;

public interface Topic1Dao {
	//����һ��С����
	public boolean AddTopic1(Topic1 t1);
	//ɾ������С����
	public boolean delTopic1(Topic1 t1,boolean alldel);
	//ͨ��ID��ѯ��ȡ����
	public Topic1 findByid(int tid); 
	//ģ������  ɸѡ����������С����
	public List<Topic1> getLikeNameList(String name,int pno);
	//�г�����С����     (����ID,������ʾ) 
	//1.����ʱ�䷢��
	//2.��������ߵ�
	public PageBean<Topic1> getAllTopicList(int pno,int px,int pageIndex,int pageSize);
	//����Աֱ�Ӳ�����л���
	public PageBean<Topic1> getAll(int pageIndex,int pageSize);
	//��ʾ�����С���⣨�������ߵģ�
	public PageBean<Topic1> getHotTopicList();
	//ͨ��uno��ѯ�����û�������
	public int findUserTopicCount(Users user);
	//��ѯĳ�û�������
	public PageBean<Topic1> findUserTopic(Users user,int pageIndex,int pageSize);
	//��ȡָ��Tno��С���������
	public int getThisPoundTopic1Num(int pno);
}
