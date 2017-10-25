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
import cn.dao.FishPoundDao;
import cn.dao.Topic1Dao;
import cn.dao.impl.FishPoundDaoImpl;
import cn.dao.impl.Topic1DaoImpl;
import cn.framework.ReFresh;
public class IndexReFresh implements ReFresh{
	private FishPoundDao fpd=new FishPoundDaoImpl();
	@Override
	public boolean execute(HttpServletRequest request,HttpServletResponse response) {
		String name ="";
		response.setCharacterEncoding("utf-8");
		if(request.getParameter("lno")!=null){
			name = request.getParameter("lno");
			setFishPoundLabel(name, request, response);
		}
		if(request.getParameter("likename")!=null){
			try{
				String likename=request.getParameter("likename");
				findTopic1(likename, request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(request.getParameter("page")!=null){
			int page=1;
			try {
				page=Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {
				e.printStackTrace();
			}		
			setTopic1Page(page, request, response);
		}
		return false;
	}
	//搜索带有指定关键字的小话题和鱼塘名
	private void findTopic1(String likename,HttpServletRequest request,HttpServletResponse response){
		Topic1Dao td1 = new Topic1DaoImpl();
		FishPoundDao fpd=new FishPoundDaoImpl();
		List<Topic1> tls=td1.getLikeNameList(likename,0);
		List<FishPond> fls=fpd.getLikeNameList(likename);
		int num=tls.size()+fls.size();
		String html="<table width='100%'border='0'><tr><td>搜索结果：</td><td width='133'>共"+num+"条数据</td></tr>";
		PrintWriter out;
		if(tls.size()>0){
			for(Topic1 t1:tls){
				html=html+" <tr><td height='25'><a href='Topic11.do?tno="+t1.getTno()+"'>"+t1.getTitle()+"</a></td><td><div align='right'>小话题</div></td></tr>";
			}
		}
		if(fls.size()>0){
			for(FishPond fp:fls){
				html=html+"<tr><td height='25'><a href='FishPound.do?fno="+fp.getNo()+"'>"+fp.getTitle()+"</a></td><td><div align='right'>鱼塘</div></td></tr>";
			}
		}
		html=html+"</table>";
		try {
			out=response.getWriter();
			out.print(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(html);
	}

	//上一页 下一页 末页 首页
	private void setTopic1Page(int PageIndex,HttpServletRequest request,HttpServletResponse response){
		Topic1Dao td1 = new Topic1DaoImpl();
		PageBean<Topic1> pb = td1.getAllTopicList(0, 0, PageIndex, 5);
		PrintWriter out;
		try {
			out = response.getWriter();
			List<Topic1> ls=pb.getList();
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
					out.print("<table class='topic1'>"
							+ "<tr><td class='fishpound'>"+t1.getFp().getTitle()+"</td>"
							+ "</tr><tr><td class='title'><a href='Topic11.do?tno="+t1.getTno()+"'>"+t1.getTitle()+"</a></td>"
							+ "</tr><tr><td>"+t1.getContent()+"<br/>"+img+"</td></tr><tr><td class='speaker'>"
							+ "话题发起者：<a id='"+t1.getUno().getUno()+"' class='otheruserid'>"+t1.getUno().getUname()+"</a></td></tr><tr><td><hr class='topicline'/></td></tr></table>");
				}
			}
//			System.out.println("PageIndex="+PageIndex);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取指定Lno的FishPound标签
	private void setFishPoundLabel(String name,HttpServletRequest request,HttpServletResponse response){
		
    	PrintWriter out=null;
		try
		{
			String outchar="<ul>";
			out = response.getWriter();
			int id=Integer.parseInt(name);
			PageBean<FishPond> pb=fpd.findLabelFishPound(id, 5, 1);
			List<FishPond> ls =pb.getList();
			for (FishPond fishPond : ls) {
				outchar=outchar+"<li class='t3' value="+fishPond.getNo()+">"+fishPond.getTitle()+"</li>";
			}
			outchar=outchar+"</ul>";
			//outchar="wowoow";
			out.print(outchar);
			//System.out.println(outchar);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
    	out.flush();
    	out.close();
	}

}
