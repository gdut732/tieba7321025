package cn.refresh.impl;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;
import cn.dao.Topic1Dao;
import cn.dao.impl.Topic1DaoImpl;
import cn.framework.ReFresh;

public class Mytopic1ReFresh implements ReFresh
{
	private Topic1Dao t1d = new Topic1DaoImpl();

	private int pageIndex = 1;
	String n="1";
	@Override
	public boolean execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		try
		{
			
		/*	request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("utf-8");
			response.setContentType("text/html;charset=utf-8");*/
			PrintWriter out = response.getWriter();
			if(request.getParameter("pageIndex")!=null)
			{
				this.pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
			}
			if(request.getParameter("n")!=null)
			{
				this.n = request.getParameter("n");
			}
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("User");
			PageBean<Topic1> pb = t1d.findUserTopic(user, pageIndex, 6);
			if(!n.equals("0"))
			{
				String ta = "";
				for(int i=0;i<pb.getList().size();i++)
				{
					Topic1 t1=pb.getList().get(i);
					ta=ta+"<table class='topic1'>"
					  +"<tr><td class='fishpound'>"+t1.getFp().getTitle()+"</td></tr>"
					  +"<tr><td class='title'><a href='Topic11.do?tno="+t1.getTno()+"'>"+t1.getTitle()+"</a></tr>"
					  +"<tr><td class='speaker'>话题发起者："+t1.getUno().getUname()+"</td></tr></table><hr class='topicline' />";
				}
				out.print(ta);
				out.flush();
				out.close();
			}
			else
			{
				int maxpage=pb.getPageCount();
				out.print(maxpage);
				out.flush();
				out.close();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
