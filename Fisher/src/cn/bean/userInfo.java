package cn.bean;
/*
 * �û���Ϣ��
 * */
public class userInfo {
	private Users users;
	private String sex;
	private String realname;
	private String idnumber;	//���֤��
	private String createDate; //��������
	private int status;	 //�Ƿ񶳽�
	private String sign; //����ǩ��
	private int signIn;  //����ǩ����־λ
	
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
