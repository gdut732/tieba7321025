package cn.bean;

public class Topic2 {
	//吐槽话题层主
	private int tno;//ID
	private Users uno;//回复者ID
	private String content;//回复层主内容
	private Topic1 tno1;//小话题 topic1编号
	private String createdate;//创建日期
	private int status;//01是否为冻结
	public Topic2() {
		
	}
	
	public Topic2(Users uno, String content, Topic1 tno1) {
		super();
		this.uno = uno;
		this.content = content;
		this.tno1 = tno1;
	}

	public Topic2(int tno, Users uno, String content, Topic1 tno1,
			String createdate, int status) {
		super();
		this.tno = tno;
		this.uno = uno;
		this.content = content;
		this.tno1 = tno1;
		this.createdate = createdate;
		this.status = status;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public Users getUno() {
		return uno;
	}
	public void setUno(Users uno) {
		this.uno = uno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Topic1 getTno1() {
		return tno1;
	}
	public void setTno1(Topic1 tno1) {
		this.tno1 = tno1;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
