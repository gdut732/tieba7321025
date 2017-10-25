package cn.refresh.impl;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Topic2;
import cn.dao.Topic1Dao;
import cn.dao.Topic2Dao;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.Topic2DaoImpl;
import cn.framework.ReFresh;

public class Topic1ReFresh implements ReFresh
{

	private int pageIndex=1;
	private int listType=0;
	@Override
	public boolean execute(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Topic2Dao t2d = new Topic2DaoImpl();
			PrintWriter out = response.getWriter();
			int tno = Integer.parseInt(request.getParameter("tno"));
			if(request.getParameter("pageIndex")!=null)
			{
				pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
			}
			String x =request.getParameter("listType");
			
			System.out.println(x);
			
			
			if(x!=null)
			{
				this.listType=Integer.parseInt(x);
			}
			List<Topic2> lpb=null;
			if(listType==3)
			{
				lpb =  t2d.findbycengzhu(tno, pageIndex, 6).getList();
			}
			else if(listType==2||listType==1)
			{
				lpb = t2d.findbytno1(tno,pageIndex , 6, listType).getList();
			}
			JSONArray json = JSONArray.fromObject(lpb);
			out.print(json.toString());
			out.flush();
			out.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
