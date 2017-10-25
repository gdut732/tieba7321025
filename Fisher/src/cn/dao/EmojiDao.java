package cn.dao;

import cn.bean.Emoji;
import cn.bean.PageBean;

public interface EmojiDao {
	
	//通过ID查找表情
	public Emoji findById(Emoji emoji);
	
	//查找所有表情
	public PageBean<Emoji> findAll(int pageIndex,int pageSize);

}
