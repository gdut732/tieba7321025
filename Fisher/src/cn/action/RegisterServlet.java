package cn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Users;
import cn.dao.UsersDao;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.Action;

public class RegisterServlet implements Action {

	private UsersDao ud=new UsersDaoImpl();
	private Users user=new Users();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String emailNum=request.getParameter("emailNum");
		String phoneNum=request.getParameter("phoneNum");
		String pwd=request.getParameter("pwd");
		HttpSession hs=request.getSession();
		try
		{
			if(username!=null){
				if(ud.cheak(username, 1)!=true){
					if(phoneNum!=null||emailNum!=null){
						user.setUname(username);
						user.setUemail(emailNum);
						user.setUphone(phoneNum);
						user.setUpwd(pwd);
						Users ru=ud.Register(user);
						if(ru!=null){
							hs.setAttribute("User",ru);
							System.out.println("¹§Ï²×¢²á³É¹¦£¡");
							return "Index.do";
						}
					}else{
						return "register.jsp" ;
					}
				}
				
				
			}

		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
		return "register.jsp";
	}
}
