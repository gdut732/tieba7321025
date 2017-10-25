package cn.bean;

public class UserHobby {

	private Users users;
	private String hobby;
	
	public UserHobby() {
	}
	public UserHobby(Users users, String hobby) {
	
		this.users = users;
		this.hobby = hobby;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
