package cn.dao;

import cn.bean.Emoji;
import cn.bean.PageBean;

public interface EmojiDao {
	
	//ͨ��ID���ұ���
	public Emoji findById(Emoji emoji);
	
	//�������б���
	public PageBean<Emoji> findAll(int pageIndex,int pageSize);

}
