package cn.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.Users;
import cn.refresh.ReFreshCotroller;

public class LoginFilter implements Filter{
	private String[] filter={"index.jsp","login.jsp","js/jquery-1.8.3.js"};
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		//获取到请求的路径
		String uri=req.getRequestURI();
		boolean flage=false;
		for(String url:filter){
			if(url.substring(0, 5).equals("image")){
				flage=true;
				break;
			}
			if(uri.indexOf(url)>-1){
				flage=true;
				break;
			}
		}
		if(flage){
			//如果输入的网址在filter中存在，无需提醒登录界面直接转跳
			chain.doFilter(req, resp);
		}else{
			HttpSession session=req.getSession();
			Users user=(Users)session.getAttribute("user");
			if(user!=null){
				//用户已登录过，直接跳过登录步骤
				chain.doFilter(req, resp);
			}else{
				//如果账号未登录 直接转跳登录界面
				String path=req.getServletPath();
				//判断path是否为   .ajax结尾
				if(path.substring(path.length()-5, path.length()).equals(".ajax")){
					ReFreshCotroller rfc=new ReFreshCotroller();
					
					if(rfc.execute(path,req, resp)){
						
						//request.getRequestDispatcher("").forward(req, resp);
					}else{
						
						//空白
						System.out.println("什么都没有运行");
					}
					
				}else{
//				req.getRequestDispatcher("Login.do").forward(req, resp);
				req.getRequestDispatcher("Login").forward(req, resp);
				}
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
}

}
