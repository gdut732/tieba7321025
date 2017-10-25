package cn.dao;

import java.util.List;

import cn.bean.Label;

public interface LabelDao {
	//��ȡ���д����ǩ����
	public List<Label> getAllLabel();
	//����Ա��ݿ�����ӱ�ǩ
	public boolean addLabel(Label lable);
	//����Ա��ݿ����޸ı�ǩ��Ϣ
	public boolean updateLable(Label lable);
	//ͨ��ID���ҵ���Label
	public Label findLabelByID(int id);
}
