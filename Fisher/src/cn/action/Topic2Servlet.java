package cn.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Topic1;
import cn.bean.Topic2;
import cn.bean.UserAlarm;
import cn.bean.Users;
import cn.dao.Topic1Dao;
import cn.dao.Topic2Dao;
import cn.dao.UserAlarmDao;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.Topic2DaoImpl;
import cn.dao.impl.UserAlarmDaoImpl;
import cn.framework.Action;

public class Topic2Servlet implements Action {

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response)
	{
		try 
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Topic1Dao td = new Topic1DaoImpl();
			Topic2Dao t2d = new Topic2DaoImpl();
			UserAlarmDao uad=new UserAlarmDaoImpl();
			HttpSession session = request.getSession();
			int tno1=0;
			
			String textf=request.getParameter("textf");
			
			String t=request.getParameter("tno1");
			if(t!=null)
			{
				tno1=Integer.parseInt(t);
			}
			;
			
			/*
			 * @test
			 * user
			 * topic
			 */
			/*Users u = new Users(1, "zhangsan", "1", "1", "123","1.jpg");
			session.setAttribute("User", u);*/
			
			
			Users u = (Users)session.getAttribute("User");
			Topic1 t1= td.findByid(tno1);
			Topic2 t2 = new Topic2(u, textf, t1);
			
			session.setAttribute("t1", t1);
			if(t2d.reply(t2))
			{
				UserAlarm ua = new UserAlarm();
				ua.setIsread(0);
				ua.setMsg(textf);
				ua.setMsgtype(1);
				ua.setSender(u);
				ua.setTopic1(t1);
				ua.setUser(t1.getUno());
				boolean flage=uad.addAlarm(ua);
				if(flage){
					return "Topic11.do";
				}
			}
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return "Index.do";
	}

}
