package cn.bean;

public class Topic3 {
	//吐槽层主 3级
	private int tno3;//ID
	private Topic2 topic2;//层主回复的ID
	private Users uno1;//吐槽者
	private Users uno2;//被吐槽者
	private Users uno3;//当前层主
	private String content;//回复内容 （无图片 有表情）
	private String createdate;//创建时间
	private int status;//01 是否为冻结
	public Topic3(int tno3, Topic2 topic2,Users uno1, Users uno2, Users uno3, String content,
			String createdate, int status) {
		super();
		this.tno3 = tno3;
		this.topic2 = topic2;
		this.uno1 = uno1;
		this.uno2 = uno2;
		this.uno3 = uno3;
		this.content = content;
		this.createdate = createdate;
		this.status = status;
	}
	public int getTno3() {
		return tno3;
	}
	public void setTno3(int tno3) {
		this.tno3 = tno3;
	}
	
	public Topic2 getTopic2() {
		return topic2;
	}
	public void setTopic2(Topic2 topic2) {
		this.topic2 = topic2;
	}
	public Users getUno1() {
		return uno1;
	}
	public void setUno1(Users uno1) {
		this.uno1 = uno1;
	}
	public Users getUno2() {
		return uno2;
	}
	public void setUno2(Users uno2) {
		this.uno2 = uno2;
	}
	public Users getUno3() {
		return uno3;
	}
	public void setUno3(Users uno3) {
		this.uno3 = uno3;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Topic3() {
		super();
	}
}
