package cn.bean;
/*
 * 关注用户表
 */
public class UserFocus_Users {
	private Users user1;//关注人
	private Users user2;//被关注人
	
	public UserFocus_Users() {
		super();
	}
	public UserFocus_Users(Users user1, Users user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}
	public Users getUser1() {
		return user1;
	}
	public void setUser1(Users user1) {
		this.user1 = user1;
	}
	public Users getUser2() {
		return user2;
	}
	public void setUser2(Users user2) {
		this.user2 = user2;
	}
	
}
