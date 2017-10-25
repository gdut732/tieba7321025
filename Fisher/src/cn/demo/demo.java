package cn.demo;

import org.junit.Test;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.dao.FishPoundDao;
import cn.dao.impl.FishPoundDaoImpl;
import cn.framework.Action;

public class demo {
	
	@Test
	public void tryone()
	{
		String path = "Index.jsp";
		System.out.println(path.indexOf(".do")!=-1);
		System.out.println(path);
	}	
}
