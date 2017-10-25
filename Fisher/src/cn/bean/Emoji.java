package cn.bean;

public class Emoji {
	//表情
	private int Eno; //表情ID
	private String address;//表情路径
	private String name;//表情名称
	public int getEno() {
		return Eno;
	}
	public void setEno(int eno) {
		Eno = eno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Emoji(int eno, String address, String name) {
		super();
		Eno = eno;
		this.address = address;
		this.name = name;
	}
	public Emoji() {
		super();
	}
	
}
