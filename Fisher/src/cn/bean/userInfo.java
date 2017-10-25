package cn.bean;
/*
 * 用户信息表
 * */
public class userInfo {
	private Users users;
	private String sex;
	private String realname;
	private String idnumber;	//身份证号
	private String createDate; //创建日期
	private int status;	 //是否冻结
	private String sign; //个性签名
	private int signIn;  //当天签到标志位
	
	public userInfo() {
	}
	
	public userInfo(Users users, String sex, String realname, String idnumber,
			String createDate, int status, String sign, int signIn) {
		super();
		this.users = users;
		this.sex = sex;
		this.realname = realname;
		this.idnumber = idnumber;
		this.createDate = createDate;
		this.status = status;
		this.sign = sign;
		this.signIn = signIn;
	}

	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getSignIn() {
		return signIn;
	}

	public void setSignIn(int signIn) {
		this.signIn = signIn;
	}
	
}
