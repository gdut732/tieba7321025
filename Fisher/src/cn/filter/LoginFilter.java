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
		//��ȡ�������·��
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
			//����������ַ��filter�д��ڣ��������ѵ�¼����ֱ��ת��
			chain.doFilter(req, resp);
		}else{
			HttpSession session=req.getSession();
			Users user=(Users)session.getAttribute("user");
			if(user!=null){
				//�û��ѵ�¼����ֱ��������¼����
				chain.doFilter(req, resp);
			}else{
				//����˺�δ��¼ ֱ��ת����¼����
				String path=req.getServletPath();
				//�ж�path�Ƿ�Ϊ   .ajax��β
				if(path.substring(path.length()-5, path.length()).equals(".ajax")){
					ReFreshCotroller rfc=new ReFreshCotroller();
					
					if(rfc.execute(path,req, resp)){
						
						//request.getRequestDispatcher("").forward(req, resp);
					}else{
						
						//�հ�
						System.out.println("ʲô��û������");
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
