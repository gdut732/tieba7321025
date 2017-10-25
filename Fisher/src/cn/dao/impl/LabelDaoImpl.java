package cn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.Label;
import cn.dao.LabelDao;
import cn.dbc.BaseDao;

public class LabelDaoImpl extends BaseDao<Label> implements LabelDao
{

	@Override
	public List<Label> getAllLabel()
	{
		String sql="select * from label";
		return getQuery(sql);
	}

	@Override
	public boolean addLabel(Label lable)
	{
		String sql="insert into label(lno,name) values(?,?)";
		int nextid=getNextId("label");
		return Update(sql, nextid,lable.getName());
	}

	@Override
	public boolean updateLable(Label lable)
	{
		String sql="update label where name=?";
		return Update(sql, lable.getName());
	}
	
	@Override
	public Label findLabelByID(int id)
	{
		String sql="select * from label where lno=?";
		return getQuery(sql,id).get(0);
	}

	@Override
	public Label getEntity(ResultSet rs)
	{
		Label lb=null;
		try
		{
			lb=new Label(rs.getInt(1),rs.getString(2));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lb;
	}



}
