package cn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import cn.bean.PageBean;
import cn.bean.Topic1;

public abstract class BaseDao<T>
{
	
	private Connection getConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	private void getClose(Connection conn , ResultSet rs , PreparedStatement pst)
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
			if(conn!=null)
				conn.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean Update(String sql , Object...obj)
	{
		Connection conn=getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean flag=false;
		try
		{
			pst=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++)
			{
				pst.setObject(i+1, obj[i]);
			}
			int t = pst.executeUpdate();
			if(t>0)
			{
				flag=true;
			}
				
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			getClose(conn, rs, pst);
		}
		return flag;
	}
	
	public String getNowDate(){     
	    String temp_str="";     
	    Date dt = new Date();     
	    //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制     
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
	    temp_str=sdf.format(dt);     
	   // System.out.println(temp_str); 
	    return temp_str;
	} 
	
	public List<T> getQuery(String sql,Object...obj)
	{
		List<T> list= new ArrayList<T>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs =null;
		conn=getConnection();
		try
		{
			pst=conn.prepareStatement(sql);
			for(int i =0;i<obj.length;i++)
			{
				pst.setObject(i+1, obj[i]);
			}
			rs=pst.executeQuery();
			while(rs.next())
			{
				list.add(getEntity(rs));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}finally{
			getClose(conn, rs, pst);
		}
		return list;
	}
	
	public PageBean<T> getQueryPage(String sql,int pageIndex,int pageSize)
	{
		int count = getCount(sql);
		PageBean<T> pb= new PageBean<T>(count,pageSize);
		pb.setPageIndex(pageIndex);
		String SQL = "select * from (select x.*,rownum r from ("+sql+") x where rownum<=?) where r>?";
		int startrow = (pageIndex-1)*pageSize;
		int endrow = pageIndex*pageSize;
		pb.setList(getQuery(SQL,endrow,startrow));
		return pb;
	}
	
	public int getNextId(String tabname){
		int id=0;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs =null;
		String sql="select count(*) from "+tabname;
		conn=getConnection();
		//ghg
		try
		{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
				id=id+1;
			}else{
				id=1;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
	}
	//取得总条数
	protected int getCount(String sql)
	{
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs =null;
		int count=0;
		String SQL = "select count(*) from ("+sql+")";
		if(sql.substring(0,4).equals("from")){
			SQL = "select count(*) "+sql;
		}
		
		conn=getConnection();
		try
		{
			pst=conn.prepareStatement(SQL);
			rs=pst.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			getClose(conn, rs, pst);
		}
		return count;
	}
	

	public abstract T getEntity(ResultSet rs);
}
