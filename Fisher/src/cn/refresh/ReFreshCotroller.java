package cn.refresh;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.framework.ReFresh;

public class ReFreshCotroller{

	public ReFreshCotroller() {
	}
	
	public boolean execute(String name, HttpServletRequest request, HttpServletResponse response){	
		ReFresh rf=this.getReFresh(name);
		return rf.execute(request, response);
	}
	public ReFresh getReFresh(String name){
		ReFresh rf=null;
		String className="cn.refresh.impl."+name.substring(1, name.length()-5)+"ReFresh";
		try{
			Class<?> c=Class.forName(className);
			rf=(ReFresh) c.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rf;
	};
}
