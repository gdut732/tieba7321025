package cn.bean;

public class UserLike {

	private Users user;			//������
	private Topic1 topic1;		//��������
	
	public UserLike() {
		super();
	}
	public UserLike(Users user, Topic1 topic1) {
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
