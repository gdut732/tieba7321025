package cn.dao;

import java.util.List;

import cn.bean.FishPond;
import cn.bean.PageBean;

public interface FishPoundDao {
	//ģ����ѯ   ɸѡ�������Ƶ�����
	public List<FishPond> getLikeNameList(String namex);
	//��ȡ���������б�
	public PageBean<FishPond> getAllFishPound(int size,int index);
	//�û����Դ���һ������
	public boolean createFishPound(FishPond fishpound);
	//�޸ġ�����ͷ�񡢸���ǩ��������
	public boolean updateFishPound(FishPond fishpound);
	//������������Ƿ�Ϊ�ظ�
	public boolean checkName(String name);
	//ͨ��ID���ҵ���Fishpound
	public FishPond findFishPondByID(int ID);
	//����һ������
	public boolean freezeFishPound(int ID);
	//�������ͱ�ǩID��ѯ
	public PageBean<FishPond> findLabelFishPound(int id,int size,int index);
	//��ȡ��ǰһ����������Ϣ
	public FishPond getFishPound(int no);
	
}
