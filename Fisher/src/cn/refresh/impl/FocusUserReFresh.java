package cn.refresh.impl;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Users;
import cn.dao.UserFocus_UsersDao;
import cn.dao.impl.UserFocus_UsersDaoImpl;
import cn.framework.ReFresh;

public class FocusUserReFresh implements ReFresh {

	@Override
	public boolean execute(HttpServletRequest request,HttpServletResponse response) {


		try
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			UserFocus_UsersDao ufu = new UserFocus_UsersDaoImpl();
			Users user=  (Users) session.getAttribute("User");
			String flag=null;
			flag=request.getParameter("flag");
			if(flag!=null)
			{
				String uno2=null;
				Users user2 = new Users();
				uno2=request.getParameter("uno2");
				System.out.println(uno2);
				if(uno2!=null)
				{
					user2.setUno(Integer.parseInt(uno2));
				}
				if(flag.equals("add"))
				{
					if(ufu.addfocus(user, user2))
					{
						out.print("ok");
						System.out.println("Ìí¼Ó³É¹¦£¡");
					}
					else
					{
						out.print("no");
						System.out.println("Ìí¼ÓÊ§°Ü£¡");
					}
				}
				else if(flag.equals("del"))
				{
					if(ufu.delfocus(user, user2))
					{
						out.print("ok");
						System.out.println("É¾³ý³É¹¦£¡");
					}
					else
					{
						out.print("no");
						System.out.println("É¾³ýÊ§°Ü£¡");
					}
				}
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
