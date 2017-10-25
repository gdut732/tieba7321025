package cn.refresh.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Users;
import cn.dao.UsersDao;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.ReFresh;

public class LoginReFresh implements ReFresh{
	private UsersDao ud=new UsersDaoImpl();
	@Override
	public boolean execute(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flage=false;
		PrintWriter out=null;
		response.setContentType("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("accountnum");
		String upwd = request.getParameter("pwd");
		try {
			out = response.getWriter();
			for (int i = 1; i <= 3; i++) {
				if (ud.cheak(name, i) == true) {
					flage = true;
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(flage){
			Users user=ud.Login(name, upwd);
			if(user!=null){
				System.out.println("登录成功！"+user.getUname());
				try {			
					out.print(1);
					//request.getRequestDispatcher("Index.do").forward(request, response);
					//response.sendRedirect("Index.do");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("密码输入有误！");
				out.print("密码输入有误!");
				return false;
			}
		}else{
			out.print("改账号名不存在!");
		}
		out.flush();
    	out.close();
		return flage;
	}
	
}
