package cn.bean;
/*
 * 收藏话题
 */
public class UserColl_topic {
	
	private Users user;
	private Topic1 topic1;//收藏话题
	
	public UserColl_topic() {
		super();
	}
	public UserColl_topic(Users user, Topic1 topic1) {
		super();
		this.user = user;
		this.topic1 = topic1;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Topic1 getTopic1() {
		return topic1;
	}
	public void setTopic1(Topic1 topic1) {
		this.topic1 = topic1;
	}
	
}
