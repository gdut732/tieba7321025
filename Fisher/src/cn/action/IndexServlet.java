package cn.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Label;
import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;
import cn.dao.LabelDao;
import cn.dao.Topic1Dao;
import cn.dao.UserAlarmDao;
import cn.dao.UsersDao;
import cn.dao.impl.LabelDaoImpl;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.UserAlarmDaoImpl;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.Action;
public class IndexServlet implements Action {
	private LabelDao ld = new LabelDaoImpl();
	private Topic1Dao td1 = new Topic1DaoImpl();
	private UsersDao ud = new UsersDaoImpl();
	private Users user = null;
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("accountnum");
		String userpwd = request.getParameter("pwd");
		String logout = request.getParameter("user");
		HttpSession senn = request.getSession();
		if (logout != null) {
			Enumeration<String> em = request.getSession().getAttributeNames();
			while (em.hasMoreElements()) {
				request.getSession().removeAttribute(em.nextElement().toString());
			}
			logout=null;
		}
		user=(Users) senn.getAttribute("User");
		if(username!=null&&userpwd!=null){
			user = ud.Login(username, userpwd);
		}
		UserAlarmDao uad=new UserAlarmDaoImpl();
		if (user != null) {	
			int msgsum=uad.getAlarmCount(user.getUno());
			senn.setAttribute("User", user);
			senn.setAttribute("MsgSum", msgsum);
			
		}
			setUnLoginView(request, response);
			setHotFishPoundLabel(request, response);
		
		return "index.jsp";
	}

	// 未登录的界面
	private void setUnLoginView(HttpServletRequest request,
			HttpServletResponse response) {
		setNowFishPoundLabel(request, response);
		List<Label> labellist = ld.getAllLabel();
		request.setAttribute("LabelList", labellist);
	}

	// 获取最新推荐的FishPound标签
	private void setNowFishPoundLabel(HttpServletRequest request,
			HttpServletResponse response) {
		PageBean<Topic1> pb = td1.getAllTopicList(0, 0, 1, 5);
		List<Topic1> allls = pb.getList();
		List<Topic1> ls=new ArrayList<Topic1>();
		for(int i=0;i<allls.size();i++){
			Topic1 t1=allls.get(i);
			String content=t1.getContent();
			List<String> imgsrc=t1.getImagesrc();
			List<String> ts=imgsrc;
			if(imgsrc.size()>0){
				if(imgsrc.size()>3){
					ts=null;
					ts=new ArrayList<String>();	
					for(int j=0;j<3;j++){
						ts.add(imgsrc.get(j));
					}
				}
				
			}
			t1.setImagesrc(ts);
			if(content.length()>30){
				content=t1.getContent().substring(0,30)+".....";
			}
			t1.setContent(content);
			ls.add(t1);
		}
		request.setAttribute("NowTop1List", ls);
		request.setAttribute("NowTop1Listpb", pb);
	}

	private void setHotFishPoundLabel(HttpServletRequest request,
			HttpServletResponse response) {
		PageBean<Topic1> pb = td1.getHotTopicList();
		List<Topic1> ls = pb.getList();
		request.setAttribute("HotTop1List", ls);
	}

}
