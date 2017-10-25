package cn.refresh.impl;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Users;
import cn.dao.UsersDao;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.ReFresh;

public class RegisterReFresh implements ReFresh
{
	private UsersDao ud=new UsersDaoImpl();
	@Override
	public boolean execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String emailNum=request.getParameter("emailNum");
		String phoneNum=request.getParameter("phoneNum");
		PrintWriter out=null;
		try
		{
		
			out=response.getWriter();
			if(phoneNum!=null){
				System.out.println(ud.cheak(phoneNum, 2));
				if(ud.cheak(phoneNum, 2)==true){
					out.print("2");
				}
			}
			if(emailNum!=null){
				if(ud.cheak(emailNum, 3)==true){
					out.print("3");
				}
			}
			if(username!=null){
				if(ud.cheak(username, 1)!=true){
					out.print("1");
				}
			}
			out.flush();
			out.close();
		} catch (Exception e)
		{	
			e.printStackTrace();
		}
		
		out.flush();
    	out.close();
		return false;
	}

}
