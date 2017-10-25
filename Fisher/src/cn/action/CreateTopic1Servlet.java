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
					System.out.println("�ɹ����һ��С����");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "FishPound.do";
		}
		return "Index.do";
	}

	// ������Ϣ
	private Topic1 getMsg(Topic1 t1,HttpServletRequest request,
			HttpServletResponse response) {
		// ServletFileUpload��Apache�ļ��ϴ���������ļ��ĺ��ĸ߼���
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// ����һ��FileItemFactory��������
			// DiskFileItemFactory����Ĭ���ٽ�ֵ��ϵͳ�ļ��������ļ���������
			FileItemFactory factory = new DiskFileItemFactory();
			// ��ȡservletFileUpload����
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// ����request������,parseRequest������ServletFileUpload�е���Ҫ����
				// ͨ����http����request��ȡ������
				List<FileItem> list = upload.parseRequest(request);
				if (list != null) {
					for (FileItem fi : list) {
						// isFormField�����ж�FileItem������װ�������Ƿ�Ϊһ����ͨ���ļ�
						// ����Ƿ���true
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
							// ��ȡ������������
							// ��������ĵ���ʵ·��
							String path = request.getSession()
									.getServletContext().getRealPath("/upload");
							System.out.println(path);
							File parentPath = new File(path);
							if (!parentPath.exists()) {
								parentPath.mkdirs();
							}
							// ��ȡ�ϴ����ļ���
							String fileName = fi.getName();
							/* user.setUheadimg(fileName); */
							// ͨ���ϴ����ļ���,�����ļ�----��path·���µ��ļ����д���
							File newFile = new File(path, fileName);
							try {
								// ����������д���ļ���
								fi.write(newFile);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}
				} else {
					System.out.println("������û������!");
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return t1;
	}

}
