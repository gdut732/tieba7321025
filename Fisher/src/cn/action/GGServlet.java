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
		//ServletFileUpload��Apache�ļ��ϴ���������ļ��ĺ��ĸ߼���
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			//����һ��FileItemFactory��������
			//DiskFileItemFactory����Ĭ���ٽ�ֵ��ϵͳ�ļ��������ļ���������
			FileItemFactory factory = new DiskFileItemFactory();
			//��ȡservletFileUpload����
			ServletFileUpload upload = new ServletFileUpload(factory);			
			try
			{
				//����request������,parseRequest������ServletFileUpload�е���Ҫ����
				//ͨ����http����request��ȡ������
				List<FileItem> list = upload.parseRequest(request);
				boolean flage = false;
				if(list!=null){
					for(FileItem fi:list){
						//isFormField�����ж�FileItem������װ�������Ƿ�Ϊһ����ͨ���ļ�
						//����Ƿ���true
						if(fi.isFormField()){
							
						}else{
							//��ȡ������������
							//��������ĵ���ʵ·��
							String path = request.getSession().getServletContext().getRealPath("/upload");
							System.out.println(path);
							File parentPath = new File(path);
							if(!parentPath.exists()){
								parentPath.mkdirs();
							}
							
							//��ȡ�ϴ����ļ���
							String fileName = fi.getName();
							user.setUheadimg(fileName);
							//ͨ���ϴ����ļ���,�����ļ�----��path·���µ��ļ����д���
							File newFile = new File(path, fileName);
							try
							{
								//����������д���ļ���
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
					System.out.println("������û������!");
				}
				if(flag==1){
					System.out.println("ǩ����Ϊ:--------"+ui.getSign());
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
