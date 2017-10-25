package cn.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.PageBean;
import cn.bean.Record;
import cn.bean.Topic1;
import cn.bean.Topic2;
import cn.bean.UserFocus_pound;
import cn.bean.Users;
import cn.dao.RecordDao;
import cn.dao.Topic1Dao;
import cn.dao.Topic2Dao;
import cn.dao.UserAlarmDao;
import cn.dao.UserFocus_poundDao;
import cn.dao.impl.RecordDaoImpl;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.Topic2DaoImpl;
import cn.dao.impl.UserAlarmDaoImpl;
import cn.dao.impl.UserFocus_poundDaoImpl;
import cn.framework.Action;

public class Topic11Servlet implements Action {

	
	private UserFocus_poundDao ufpd= new  UserFocus_poundDaoImpl();
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		try 
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Topic1Dao td = new Topic1DaoImpl();
			Topic2Dao t2d = new Topic2DaoImpl(); 
			RecordDao rd=new RecordDaoImpl();
			HttpSession session = request.getSession();
			int tno=0;
			String t=request.getParameter("tno");
			String ano=request.getParameter("ano");
			if(t!=null)
			{
				tno=Integer.parseInt(t);
			}
			if(session.getAttribute("t1")!=null)
			{
				Topic1 t1 = (Topic1) session.getAttribute("t1");
				session.removeAttribute("t1");
				tno=t1.getTno();
			}
			/*
			 * @test
			 * user
			 * topic
			 */
			
			/*Users u = new Users(1, "zhangsan", "1", "1", "123","1.jpg");
			session.setAttribute("User", u);*/
			
			/*tno=1;*/
			
			/*
			 * 获取话题信息
			 */
			
			
			Topic1 t1= td.findByid(tno);
			UserFocus_pound ufp= new UserFocus_pound();
			if(session.getAttribute("User")!=null)
			{
				Users user = (Users) session.getAttribute("User");
				ufp=ufpd.findbyunopno(user.getUno(),t1.getFp().getNo());
				if(ano!=null){
					int Ano=Integer.parseInt(ano);
					UserAlarmDao uad=new UserAlarmDaoImpl();
					boolean flage=uad.delAlarm(user, Ano);
					if(flage!=true){
						System.out.println("未读通知修改失败！");
					}
				}
				Record r=new Record();
				r.setTno1(t1);
				r.setUno(user);
				boolean flage=rd.addRecord(r);
				if(flage==false){
					System.out.println("用户重复点击");
				}
				request.setAttribute("ufp", ufp);
			}
			
			
			int tcount =td.getThisPoundTopic1Num(t1.getFp().getNo());
			int collnum=ufpd.getThisPoundCollNum(t1.getTno());
			PageBean<Topic2> pb = t2d.findbytno1(t1.getTno(), 1, 6,1);
			
			request.setAttribute("topic", t1);
			request.setAttribute("pb", pb);
			request.setAttribute("collnum", collnum);
			request.setAttribute("tcount", tcount);
			return "topic1.jsp";
		} 
		catch (Exception e)
		{
			e.getMessage();
		}
		
		return null;
	}

}
