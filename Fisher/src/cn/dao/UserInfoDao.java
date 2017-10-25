package cn.dao;

import cn.bean.Users;
import cn.bean.userInfo;

public interface UserInfoDao {

	//更新用户信息（冻结,签名档，单日点赞标志位）
	public boolean updateUserInfo(userInfo userinfo);
	
	//通过uno查找
	public userInfo findByNo(Users user);
	
	//新增用户信息
	public boolean adduserinfo(userInfo ui);
}
