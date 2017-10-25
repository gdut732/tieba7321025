package cn.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.Topic1;
import cn.bean.Users;
import cn.dao.FishPoundDao;
import cn.dao.Topic1Dao;
import cn.dao.UserFocus_poundDao;
import cn.dao.impl.FishPoundDaoImpl;
import cn.dao.impl.Topic1DaoImpl;
import cn.dao.impl.UserFocus_poundDaoImpl;
import cn.framework.Action;
public class FishPoundServlet implements Action{
	private FishPoundDao fpd=new FishPoundDaoImpl();
	private UserFocus_poundDao ufd=new UserFocus_poundDaoImpl();
	private Topic1Dao td1=new Topic1DaoImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
			String x = request.getParameter("fno");
			int fno=1;
			if(x!=null)
			{
				fno=Integer.parseInt(x);
			}
			HttpSession session = request.getSession();
			
			FishPond fp=(FishPond) session.getAttribute("fp");
			if(fp!=null)
			{
				session.removeAttribute("fp");
			}
			else
			{
				fp=fpd.getFishPound(fno);
			}
			int pno=fp.getNo();
			int topic1num=td1.getThisPoundTopic1Num(pno);
			int collnum=ufd.getThisPoundCollNum(pno);
			PageBean<Topic1> pb=td1.getAllTopicList(pno, 1, 1, 5);
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
					content=content.substring(0,30)+".....";
				}
				t1.setContent(content);
				ls.add(t1);
			}
			HttpSession sion=request.getSession();
			if(sion.getAttribute("User")!=null){
				Users user=(Users)sion.getAttribute("User");
				int uno=user.getUno();
				boolean flage=ufd.IsFocusPound(uno, fno);
				if(flage){
					request.setAttribute("IsFocusPound",1);
				}
			}
			request.setAttribute("FishPond", fp);
			request.setAttribute("CollNum", collnum);
			request.setAttribute("Topic1Num", topic1num);
			request.setAttribute("Topic1ListPb", pb);
			request.setAttribute("Topic1List", ls);
			return "fishpound.jsp";
	}

}
