package cn.refresh.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.PageBean;
import cn.bean.UserColl_topic;
import cn.bean.UserFocus_Users;
import cn.bean.Users;
import cn.dao.UserFocus_UsersDao;
import cn.dao.impl.UserFocus_UsersDaoImpl;
import cn.framework.ReFresh;

public class MyfocusuReFresh implements ReFresh
{
	private UserFocus_UsersDao ufud = new UserFocus_UsersDaoImpl();
	private int pageIndex = 1;
	private String n="1";
	private int fid=0;
	private boolean flag=false;
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
			if(request.getParameter("fid")!=null)
			{
				this.fid=Integer.parseInt(request.getParameter("fid"));
			}
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("User");
			if(fid!=0)
			{
				Users user2 = new Users();
				user2.setUno(fid);
				flag=ufud.delfocus(user, user2);
			}
			PageBean<UserFocus_Users> pb = ufud.findAllFocus(user, pageIndex, 6);
			if(!n.equals("0"))
			{
				String ta = "";
				for(int i=0;i<pb.getList().size();i++)
				{
					UserFocus_Users ufu=pb.getList().get(i);
					ta=ta+"<div class='friendt'>"
						+"<div class='friend' ><img src='"+ufu.getUser2().getUheadimg()+"'/></div>"
						+"<div class='fuid' style='display:none'>"+ufu.getUser2().getUno()+"</div>"
						+"<div><p class='ufname'><a id='"+ufu.getUser2().getUno()+"' class='otheruserid'>"+ufu.getUser2().getUname()+"</a></p>"
						+"<input class='opera' type='button' value='È¡Ïû¹Ø×¢' /></div></div>";
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
