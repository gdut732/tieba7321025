package cn.refresh.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.framework.ReFresh;
import cn.utils.ImageUtils;

public class FishPoundReFresh  implements ReFresh{
	private FishPoundDao fpd=new FishPoundDaoImpl();
	private Topic1Dao td1=new Topic1DaoImpl();
	private UserFocus_poundDao ufpd=new UserFocus_poundDaoImpl();
	@Override
	public boolean execute(HttpServletRequest request,
			HttpServletResponse response) {
		//点击上一页·下一页·尾页·首页
		if(request.getParameter("page")!=null&&request.getParameter("pno")!=null){
			int page=1;
			int pno=1;
			try {
				page=Integer.parseInt(request.getParameter("page"));
				pno=Integer.parseInt(request.getParameter("pno"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}				
			setTopic1Page(pno,page, request, response);
		}
		//点击排序
		if(request.getParameter("listorder")!=null&&request.getParameter("fno")!=null){
			String listorder=request.getParameter("listorder").toString();
			int fno = Integer.parseInt((String)request.getParameter("fno"));
			int orderby=1;
			if(listorder.equals("uptodate")){
				orderby=1;
			}else{
				orderby=2;
			}
			setTopci1Order(fno, orderby, request, response);
		}
		//点击关注   and  取消关注
		if(request.getParameter("uno")!=null&&request.getParameter("fno")!=null&&request.getParameter("focus")!=null){
			Users user=new Users();
			FishPond fp=new FishPond();
			try {
				PrintWriter out=null;
				int uno=Integer.parseInt((String)request.getParameter("uno"));
				int no=Integer.parseInt((String)request.getParameter("fno"));
				int focus=Integer.parseInt((String)request.getParameter("focus"));
				user.setUno(uno);	
				fp.setNo(no);
				boolean flage=false;
				if(focus==1){
					flage=ufpd.focus_pound(user, fp);
					if(flage){
						out=response.getWriter();
						out.print("<input type='button' class='focusbt' id='cancelfocus' value='取消关注' />");
					}
				}else{
					flage=ufpd.disfocus_pound(user, fp);
					if(flage){
						out=response.getWriter();
						out.print("<input type='button' class='focusbt' id='surefocus' value='关注' />");
					}
				}		
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		//鱼塘内搜索小话题
		if(request.getParameter("likename")!=null&&request.getParameter("pno")!=null){
			try {
				String likename=request.getParameter("likename");
				int pno=Integer.parseInt((String)request.getParameter("pno"));
				PrintWriter out=null;
				List<Topic1> ls = td1.getLikeNameList(likename, pno);
				String html="";
				if(ls!=null){
						out=response.getWriter();
						for(int i=0;i<ls.size();i++){
							Topic1 t1=ls.get(i);
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
							String img="";
							for(int j=0;j<ts.size();j++){
								img=img+"<img src='upload/"+ts.get(j)+"'/>";
							}
							html=html+"<table class='topic1'><tr><td class='title'><a href='Topic11.do?tno="+t1.getTno()+"'>"
									+ t1.getTitle()
									+ "</a></td></tr><tr><td>"+t1.getContent()
									+ "<br/>"+img+"</td></tr><tr><td>"
									+ "<span class='speaker'>话题发起者：<a id='"+t1.getUno().getUno()+"' class='otheruserid'>"+t1.getUno().getUname()+"</a>"
									+ "</span><span class='ponudinfo_split'></span><span class=‘speaker’>话题时间："+t1.getCreatedate()
									+ "</span></td></tr><tr><td><hr class='topicline'/></td></tr></table>";
						}
						out.print(html);
					
				}
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	//设置小话题的排序 *分别：（ 最新发布 ）（热门话题）
	private void setTopci1Order(int fno,int orderby,HttpServletRequest request,HttpServletResponse response){
		PrintWriter out=null;
		FishPond fp=fpd.getFishPound(fno);
		int pno=fp.getNo();
		PageBean<Topic1> pb=td1.getAllTopicList(pno,orderby, 1, 5);
		List<Topic1> ls=pb.getList();
		String html="";
		if(ls.size()>0){
			//ls.equals(o)
			try {
				out=response.getWriter();
				for(int i=0;i<ls.size();i++){
					Topic1 t1=ls.get(i);
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
					String img="";
					for(int j=0;j<ts.size();j++){
						img=img+"<img src='upload/"+ts.get(j)+"'/>";
					}
					html=html+"<table class='topic1'><tr><td class='title'><a href='Topic11.do?tno="+t1.getTno()+"'>"
							+ t1.getTitle()
							+ "</a></td></tr><tr><td>"+t1.getContent()
							+ "<br/>"+img+"</td></tr><tr><td>"
							+ "<span class='speaker'>话题发起者："+t1.getUno().getUname()
							+ "</span><span class='ponudinfo_split'></span><span class=‘speaker’>话题时间："+t1.getCreatedate()
							+ "</span></td></tr><tr><td><hr class='topicline'/></td></tr></table>";
				}
				out.print(html);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}			
	};
	
	//上一页 下一页 末页 首页
		private void setTopic1Page(int pno,int PageIndex,HttpServletRequest request,HttpServletResponse response){
			Topic1Dao td1 = new Topic1DaoImpl();
			PageBean<Topic1> pb = td1.getAllTopicList(0, 0, PageIndex, 5);
			PrintWriter out;
			try {
				out = response.getWriter();
				List<Topic1> ls=pb.getList();
				String html="";
				if(ls!=null){
					for(int i=0;i<ls.size();i++){
						Topic1 t1=ls.get(i);
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
						String img="";
						for(int j=0;j<ts.size();j++){
							img=img+"<img src='upload/"+ts.get(j)+"'/>";
						}
						html=html+"<table class='topic1'><tr><td class='title'><a href='Topic11.do?tno="+t1.getTno()+"'>"
								+ t1.getTitle()
								+ "</a></td></tr><tr><td>"+t1.getContent()
								+ "<br/>"+img+"</td></tr><tr><td>"
								+ "<span class='speaker'>话题发起者："+t1.getUno().getUname()
								+ "</span><span class='ponudinfo_split'></span><span class=‘speaker’>话题时间："+t1.getCreatedate()
								+ "</span></td></tr><tr><td><hr class='topicline'/></td></tr></table>";
					}
				}
				out.print(html);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
