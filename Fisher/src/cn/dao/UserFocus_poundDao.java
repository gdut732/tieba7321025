package cn.dao;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.UserFocus_pound;
import cn.bean.Users;

public interface UserFocus_poundDao {
	
	//��ע����
	public boolean focus_pound(Users user,FishPond fp);
	//ȡ������
	public boolean disfocus_pound(Users user,FishPond fp);
	//���¾���ֵ�͵ȼ�
	public boolean updateLvOrExp(UserFocus_pound ufp );
	//�ҳ�ĳ�û���ע������
	public PageBean<UserFocus_pound> findByUno(Users user,int pageIndex , int pageSize);
	//��ȡ������������ע������������
	public int getThisPoundCollNum(int tno);
	//�жϵ�¼�û��Ƿ��Ѿ���ע������
	public boolean IsFocusPound(int uno,int pno);
	//��ȡ�û���ע����Ϣ
	public UserFocus_pound findbyunopno(int uno,int pon);
}
