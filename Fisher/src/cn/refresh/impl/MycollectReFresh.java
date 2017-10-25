package cn.refresh.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.UserColl_topic;
import cn.bean.Users;
import cn.dao.UserColl_topicDao;
import cn.dao.impl.UserColl_topicDaoImpl;
import cn.framework.ReFresh;

public class MycollectReFresh implements ReFresh
{
	private UserColl_topicDao uctd = new UserColl_topicDaoImpl();
	private int pageIndex = 1;
	String n="1";
	@Override
	public boolean execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		try
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("utf-8");
			response.setContentType("text/html;charset=utf-8");
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
			PageBean<UserColl_topic> pb = uctd.allColl_topic(user, pageIndex, 6);
			if(!n.equals("0"))
			{
				String ta = "";
				for(int i=0;i<pb.getList().size();i++)
				{
					UserColl_topic uct=pb.getList().get(i);
					ta=ta+"<table class='topic1'>"
					  +"<tr><td class='fishpound'>"+uct.getTopic1().getFp().getTitle()+"</td></tr>"
					  +"<tr><td class='title'><a href='Topic11.do?tno="+uct.getTopic1().getTno()+"'>"+uct.getTopic1().getTitle()+"</a></tr>"
					  +"<tr><td class='speaker'>话题发起者： <a id='"+uct.getTopic1().getUno().getUno()+"' class='otheruserid'>"+uct.getTopic1().getUno().getUname()+"</a></td></tr></table><hr class='topicline' />";
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
