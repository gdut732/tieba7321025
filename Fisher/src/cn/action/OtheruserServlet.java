package cn.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.UserDataHandler;

import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;
import cn.bean.userInfo;
import cn.dao.Topic1Dao;
import cn.dao.UserFocus_UsersDao;
import cn.dao.UserInfoDao;
import cn.dao.UsersDao;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.UserFocus_UsersDaoImpl;
import cn.dao.impl.UserFocus_poundDaoImpl;
import cn.dao.impl.UserInfoDaoImpl;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.Action;

public class OtheruserServlet implements Action {
	private int pageIndex=1;
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		

		try 
		{
			UsersDao ud = new UsersDaoImpl();
			Topic1Dao t1d = new Topic1DaoImpl();
			UserInfoDao uid = new UserInfoDaoImpl();
			UserFocus_UsersDao ufu= new UserFocus_UsersDaoImpl();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String uno2=null;
			uno2=request.getParameter("uno2");
			Users user = (Users) session.getAttribute("User");
			/*
			 * ≤‚ ‘”√µƒ¥˙¬Î
			 */
			/*Users user = new Users(1, "zhangsan", "1", "1", "123","1.jpg");
			session.setAttribute("User", user);
			uno2="2";*/
			
			Users user2=new Users();
			
			if(uno2!=null)
			{
				if(user.getUno()==Integer.parseInt(uno2))
				{
					return "Homepage.do";
				}
				user2 = ud.findById(Integer.parseInt(uno2));
				userInfo ui2 = uid.findByNo(user2);
				PageBean<Topic1> pb=t1d.findUserTopic(user2, pageIndex, 10);
				boolean isfocus = ufu.isfocus(user, user2);
				if(isfocus)
				{
					request.setAttribute("isfocus", 1);
				}
				else
				{
					request.setAttribute("isfocus", 0);
				}
				request.setAttribute("pb", pb);
				request.setAttribute("ui2", ui2);
				request.setAttribute("user2",user2);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return "otheruser.jsp";
	}

}
