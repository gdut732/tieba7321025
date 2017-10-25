package cn.bean;

public class Users {

	private int uno;
	private String uname;
	private String uemail;
	private String uphone;
	private String Upwd;
	private String uheadimg;
	
	public Users() {
		super();
	}
	public Users(int uno, String uname, String uemail, String uphone,
			String upwd,String uheadimg) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.uemail = uemail;
		this.uphone = uphone;
		this.Upwd = upwd;
		this.uheadimg=uheadimg;
	}
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUpwd() {
		return Upwd;
	}
	public void setUpwd(String upwd) {
		Upwd = upwd;
	}
	public String getUheadimg() {
		return uheadimg;
	}
	public void setUheadimg(String uheadimg) {
		this.uheadimg = uheadimg;
	}
	
}
