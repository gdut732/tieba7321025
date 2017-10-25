package cn.dao;

import cn.bean.FishPond;
import cn.bean.PageBean;
import cn.bean.UserFocus_pound;
import cn.bean.Users;

public interface UserFocus_poundDao {
	
	//关注鱼塘
	public boolean focus_pound(Users user,FishPond fp);
	//取关鱼塘
	public boolean disfocus_pound(Users user,FishPond fp);
	//更新经验值和等级
	public boolean updateLvOrExp(UserFocus_pound ufp );
	//找出某用户关注的鱼塘
	public PageBean<UserFocus_pound> findByUno(Users user,int pageIndex , int pageSize);
	//获取单个鱼塘被关注的人数数量、
	public int getThisPoundCollNum(int tno);
	//判断登录用户是否已经关注该鱼塘
	public boolean IsFocusPound(int uno,int pno);
	//获取用户关注的信息
	public UserFocus_pound findbyunopno(int uno,int pon);
}
