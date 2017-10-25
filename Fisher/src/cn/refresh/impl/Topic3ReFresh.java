package cn.refresh.impl;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.bean.Topic2;
import cn.bean.Topic3;
import cn.dao.Topic2Dao;
import cn.dao.Topic3Dao;
import cn.dao.impl.Topic2DaoImpl;
import cn.dao.impl.Topic3DaoImpl;
import cn.framework.ReFresh;

public class Topic3ReFresh implements ReFresh {

	@Override
	public boolean execute(HttpServletRequest request,HttpServletResponse response) {
		
		try 
		{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			/*Topic2Dao t2d = new Topic2DaoImpl();*/
			Topic3Dao t3d = new Topic3DaoImpl();
			int tno2=0;
			/*String textf=request.getParameter("textf");*/
			String t=request.getParameter("tno2");
			if(t!=null)
			{
				tno2=Integer.parseInt(t);
			}
			/*Topic2 t2 = t2d.findTopic2ByID(tno2);*/
			List<Topic3> lt3 = t3d.getAlltopic3(tno2);
			JSONArray json = JSONArray.fromObject(lt3);
			out.println(json.toString());
			out.flush();
			out.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return false;
	}

}
