package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import cn.bean.Emoji;
import cn.bean.PageBean;
import cn.dao.EmojiDao;
import cn.dbc.BaseDao;

public class EmojiDaoImpl extends BaseDao<Emoji> implements EmojiDao
{

	@Override
	public Emoji findById(Emoji emoji)
	{
		String sql="select * from emoji where eno=?";
		Emoji ej=getQuery(sql, emoji.getEno()).get(0);
		if(ej!=null){
			return ej;
		}
		return null;
	}

	@Override
	public PageBean<Emoji> findAll(int pageIndex,int pageSize)
	{
		
        String sql="select * from emoji";
        return  getQueryPage(sql,pageIndex,pageSize);

	}

	@Override
	public Emoji getEntity(ResultSet rs)
	{
		Emoji ej=new Emoji();
		try
		{
			ej.setEno(rs.getInt(1));
			ej.setAddress(rs.getString(2));
			ej.setName(rs.getString(3));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ej;
	}

}
