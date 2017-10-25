package cn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.framework.Action;
import cn.refresh.ReFreshCotroller;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String path=request.getServletPath();
		//判断path是否为   .ajax结尾
		if(path.substring(path.length()-5, path.length()).equals(".ajax")){
			ReFreshCotroller rfc=new ReFreshCotroller();
 			if(rfc.execute(path,request, response)){ 
				//request.getRequestDispatcher("Index.do").forward(request, response);
			}else{
				//空白 
			}
			
		}else{
			Action action=getAction(request,null);
			path="Login";	
			if(action!=null){
				path=action.execute(request, response);	
			}
			
			boolean flag =path.indexOf(".do")!=-1;
			while(flag)
			{
				Action action1=getAction(null,path);	
				if(action1!=null){
					path=action1.execute(request, response);	
				}
				flag =path.indexOf(".do")!=-1;
			}
			request.getRequestDispatcher(path).forward(request, response);
				
		}
		
		
			
	}
	
	public Action getAction(HttpServletRequest request,String str){
		Action action=null;
		String path="Index.do";
		if(str==null)
		{
			path=request.getServletPath();
		}
		else
		{
			path=str;
		}
		String className=path.substring(path.lastIndexOf("/")+1,path.length()-3);
		className="cn.action."+className+"Servlet";
		try {
			Class<?> classs=Class.forName(className);
			action=(Action)classs.newInstance();
		} catch (Exception e) {
			System.out.println("该"+className+"文件不存在，错误信息："+e.getMessage());
			Class<?> classs;
			try {
				classs = Class.forName("cn.action.IndexServlet");
				action=(Action)classs.newInstance();
				System.out.println("系统自动转跳至主页");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return action;
		
	}
	public void init() throws ServletException {
		
	}

}
