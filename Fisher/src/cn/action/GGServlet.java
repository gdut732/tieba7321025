package cn.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.dao.UserInfoDao;
import cn.dao.UsersDao;
import cn.dao.impl.UserInfoDaoImpl;
import cn.dao.impl.UsersDaoImpl;
import cn.framework.Action;
import cn.framework.ReFresh;
import cn.bean.Users;
import cn.bean.userInfo;

public class GGServlet implements Action
{
	private UserInfoDao uid=new UserInfoDaoImpl();
	private UsersDao ud = new UsersDaoImpl();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			request.setCharacterEncoding("utf-8");
		} 
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("User");
		userInfo ui = new userInfo();
		ui=uid.findByNo(user);
		int flag=0;
		String t="x";
		if(request.getParameter("t")!=null)
		{
			t=request.getParameter("t");
		};
		
		if(t.equals("1")){
				String text =null;
				text = request.getParameter("text");
				ui.setSign(text);
				uid.updateUserInfo(ui);
		}
		else
		{
		//ServletFileUpload类Apache文件上传组件处理文件的核心高级类
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			//创建一个FileItemFactory工厂对象
			//DiskFileItemFactory采用默认临界值和系统文件来创建文件工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			//获取servletFileUpload对象
			ServletFileUpload upload = new ServletFileUpload(factory);			
			try
			{
				//接续request中请求,parseRequest方法是ServletFileUpload中的重要方法
				//通过对http解析request获取到数据
				List<FileItem> list = upload.parseRequest(request);
				boolean flage = false;
				if(list!=null){
					for(FileItem fi:list){
						//isFormField方法判断FileItem类对象封装的数据是否为一个普通表单文件
						//如果是返回true
						if(fi.isFormField()){
							
						}else{
							//获取二进制流数据
							//获得上下文的真实路径
							String path = request.getSession().getServletContext().getRealPath("/upload");
							System.out.println(path);
							File parentPath = new File(path);
							if(!parentPath.exists()){
								parentPath.mkdirs();
							}
							
							//获取上传的文件名
							String fileName = fi.getName();
							user.setUheadimg(fileName);
							//通过上传的文件名,创建文件----在path路径下的文件夹中创建
							File newFile = new File(path, fileName);
							try
							{
								//将二进制流写入文件中
								fi.write(newFile);
								if(ud.updateInfo(user))
								{
									session.setAttribute("User", user);
									flag=2;
								}
							} catch (Exception e)
							{
								System.out.println(e.getMessage());
							}
						}
					}
				}else{
					System.out.println("集合中没有数据!");
				}
				if(flag==1){
					System.out.println("签名档为:--------"+ui.getSign());
				}
				else if(flag==2)
				{
					
				}
			} catch (FileUploadException e)
			{
				e.printStackTrace();
			}
			
			
		}else{
			
		}
		}
		return "Homepage.do";
	}

}
