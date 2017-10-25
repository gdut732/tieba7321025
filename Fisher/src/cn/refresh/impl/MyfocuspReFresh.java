package cn.refresh.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.UserFocus_Users;
import cn.bean.UserFocus_pound;
import cn.bean.Users;
import cn.dao.UserFocus_UsersDao;
import cn.dao.UserFocus_poundDao;
import cn.dao.impl.UserFocus_UsersDaoImpl;
import cn.dao.impl.UserFocus_poundDaoImpl;
import cn.framework.ReFresh;

public class MyfocuspReFresh implements ReFresh 
{
	private UserFocus_poundDao ufpd = new UserFocus_poundDaoImpl();
	private int pageIndex = 1;
	private String n="1";
	private int fid=0;
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
				FishPond fp = new FishPond();
				fp.setNo(fid);
				ufpd.disfocus_pound(user, fp);
			}
			PageBean<UserFocus_pound> pb = ufpd.findByUno(user, pageIndex, 6);
			if(!n.equals("0"))
			{
				String ta = "";
				for(int i=0;i<pb.getList().size();i++)
				{
					UserFocus_pound ufp=pb.getList().get(i);
					ta=ta+"<div class='friendt'>"
						+"<div class='friend' ><img src='"+ufp.getFishpond().getHeadimg()+"'/></div>"
						+"<div class='fuid' style='display:none'>"+ufp.getFishpond().getNo()+"</div>"
						+"<div><p class='ufname'>"+ufp.getFishpond().getTitle()+"</p><p class='level'>等级："+ufp.getLevel()+"</p>"
						+"<input class='opera' type='button' value='取消关注' /></div></div>";
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
