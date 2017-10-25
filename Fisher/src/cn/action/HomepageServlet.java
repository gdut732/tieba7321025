package cn.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.UserAlarm;
import cn.bean.Users;
import cn.bean.userInfo;
import cn.dao.Topic1Dao;
import cn.dao.UserAlarmDao;
import cn.dao.UserInfoDao;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.UserAlarmDaoImpl;
import cn.dao.impl.UserInfoDaoImpl;
import cn.framework.Action;

public class HomepageServlet implements Action
{

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		try
		{
			UserInfoDao uid = new UserInfoDaoImpl();
			Topic1Dao t1d = new Topic1DaoImpl();
			UserAlarmDao ual=new UserAlarmDaoImpl();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("User");
			/*
			 * ≤‚ ‘”√µƒ¥˙¬Î
			 */
			/*Users user = new Users(1, "zhangsan", "1", "1", "123","1.jpg");
			session.setAttribute("User", user);*/
			String change=null;
			change=request.getParameter("change");
			
			if(user!=null)
			{
				userInfo ui = uid.findByNo(user);
				if(change!=null)
				{
					String csex=request.getParameter("csex");
					String realname=request.getParameter("realname");
					String idnum=request.getParameter("idnum");
					ui.setIdnumber(idnum);
					ui.setRealname(realname);
					ui.setSex(csex);
					uid.updateUserInfo(ui);
				}
				int count = t1d.findUserTopicCount(user);
				PageBean<UserAlarm> pb=ual.findbyitems(user, 1, 1, 1, 6);
				List<UserAlarm> alarmlist=pb.getList();
				int msgcount=ual.getAlarmCount(user.getUno());
				request.setAttribute("alarmlist",alarmlist);
				request.setAttribute("msgcount", msgcount);
				request.setAttribute("userinfo", ui);
				request.setAttribute("topic1count", count);
				return "personalHomepage.jsp";
			}
		} 
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return "Index.do";
	}

}
