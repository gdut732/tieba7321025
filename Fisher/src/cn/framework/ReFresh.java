package cn.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReFresh {
	public boolean execute(HttpServletRequest request,HttpServletResponse response);
}
