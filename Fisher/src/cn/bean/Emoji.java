package cn.bean;

public class Emoji {
	//����
	private int Eno; //����ID
	private String address;//����·��
	private String name;//��������
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
