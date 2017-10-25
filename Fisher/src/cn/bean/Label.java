package cn.bean;

public class Label {
	private int lno;//ID
	private String name;//总类标签名
	public Label(int lno, String name) {
		super();
		this.lno = lno;
		this.name = name;
	}
	public Label() {
		super();
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
