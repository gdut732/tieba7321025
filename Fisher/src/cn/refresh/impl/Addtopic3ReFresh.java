package cn.refresh.impl;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.UserDataHandler;

import net.sf.json.JSONArray;
import cn.bean.Topic2;
import cn.bean.Topic3;
import cn.bean.UserAlarm;
import cn.bean.Users;
import cn.dao.Topic2Dao;
import cn.dao.Topic3Dao;
import cn.dao.UserAlarmDao;
import cn.dao.UsersDao;
import cn.dao.impl.Topic2DaoImpl;
import cn.dao.impl.Topic3DaoImpl;
import cn.dao.impl.UserAlarmDaoImpl;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.ReFresh;

public class Addtopic3ReFresh implements ReFresh {

	@Override
	public boolean execute(HttpServletRequest request,HttpServletResponse response) {


		try 
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			Topic3Dao t3d = new Topic3DaoImpl();
			Topic2Dao t2d = new Topic2DaoImpl();
			UsersDao ud = new UsersDaoImpl();
			UserAlarmDao uad=new UserAlarmDaoImpl();
			int tno2=0;
			String content = null;
			String u2name=null;
			String draft = request.getParameter("content");
			String t=request.getParameter("tno2");
			if(t!=null)
			{
				tno2=Integer.parseInt(t);
			}
			if(draft.indexOf("ªÿ∏¥")!=0)
			{
				content=draft;
			}
			else if(draft.indexOf(":")!=-1)
			{
				u2name = draft.substring(draft.indexOf("ªÿ∏¥")+2, draft.indexOf(":"));
				content = draft.substring(draft.indexOf(":")+1);
			}
			Users uno1 = (Users) session.getAttribute("User");
//			System.out.println(content);
//			System.out.println(u2name);
			Topic2 t2 = t2d.findTopic2ByID(tno2);
			Users uno2 = ud.findbyname(u2name);
			Topic3 t3 =null;
			if(uno2!=null)
			{
				t3 = new Topic3(0, t2, uno1, uno2, t2.getUno(),content, null, 0);
				if(t3d.reply(t3))
				{
					List<Topic3> lt3 = t3d.getAlltopic3(tno2);
					JSONArray json = JSONArray.fromObject(lt3);
//					System.out.println(json.toString());
					out.println(json.toString());
				}
			}
			else
			{
				t3 = new Topic3(0, t2, uno1,t2.getUno(), t2.getUno(),content, null, 0);
				if(t3d.reply(t3))
				{
					List<Topic3> lt3 = t3d.getAlltopic3(tno2);
					JSONArray json = JSONArray.fromObject(lt3);
				
					out.println(json.toString());
					
				}
			}
			UserAlarm ua = new UserAlarm();
			ua.setIsread(1);
			ua.setMsg(draft);
			ua.setMsgtype(1);
			ua.setSender(uno1);
			ua.setTopic1(t2.getTno1());
			ua.setUser(t3.getUno2());
			boolean flage=uad.addAlarm(ua);
			if(flage==false){
				System.out.println("T3ÃÌº” ß∞‹£°");
			}
			out.flush();
			out.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
