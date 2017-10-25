package cn.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bean.FishPond;
import cn.bean.Topic1;
import cn.bean.Users;
import cn.dao.FishPoundDao;
import cn.dao.Topic1Dao;
import cn.dao.impl.FishPoundDaoImpl;
import cn.dao.impl.Topic1DaoImpl;
import cn.framework.Action;

public class CreateTopic1Servlet implements Action {
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int pno = 0;
		Topic1 t1=new Topic1();
		HttpSession sess=request.getSession();
		Users user=(Users)sess.getAttribute("User");
		FishPoundDao fpd = new FishPoundDaoImpl();
		if(user!=null){
			try {
				pno = Integer.parseInt((String) request.getParameter("pno"));
				FishPond fp=fpd.findFishPondByID(pno);
				t1.setFp(fp);
				t1.setUno(user);
				t1.setStatus(0);
				this.getMsg(t1,request, response);
				Topic1Dao td1=new Topic1DaoImpl();
				boolean flage=td1.AddTopic1(t1);
				if(flage){
					sess.setAttribute("fp", fp);
					System.out.println("成功添加一个小话。");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "FishPound.do";
		}
		return "Index.do";
	}

	// 接收信息
	private Topic1 getMsg(Topic1 t1,HttpServletRequest request,
			HttpServletResponse response) {
		// ServletFileUpload类Apache文件上传组件处理文件的核心高级类
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 创建一个FileItemFactory工厂对象
			// DiskFileItemFactory采用默认临界值和系统文件来创建文件工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 获取servletFileUpload对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 接续request中请求,parseRequest方法是ServletFileUpload中的重要方法
				// 通过对http解析request获取到数据
				List<FileItem> list = upload.parseRequest(request);
				if (list != null) {
					for (FileItem fi : list) {
						// isFormField方法判断FileItem类对象封装的数据是否为一个普通表单文件
						// 如果是返回true
						if (fi.isFormField()) {
							try {
								if (fi.getFieldName().equals("topictitle")) {
									t1.setTitle(fi.getString("utf-8"));
								}
								if (fi.getFieldName().equals("topictext")) {
									t1.setContent(fi.getString("utf-8"));
								}
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							// 获取二进制流数据
							// 获得上下文的真实路径
							String path = request.getSession()
									.getServletContext().getRealPath("/upload");
							System.out.println(path);
							File parentPath = new File(path);
							if (!parentPath.exists()) {
								parentPath.mkdirs();
							}
							// 获取上传的文件名
							String fileName = fi.getName();
							/* user.setUheadimg(fileName); */
							// 通过上传的文件名,创建文件----在path路径下的文件夹中创建
							File newFile = new File(path, fileName);
							try {
								// 将二进制流写入文件中
								fi.write(newFile);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}
				} else {
					System.out.println("集合中没有数据!");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return t1;
	}

}
