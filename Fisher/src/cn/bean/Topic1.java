package cn.bean;

import java.util.List;

public class Topic1 {
	//小话题 一级
	private int tno;//ID
	private FishPond fp;//所属鱼塘
	private String title;//帖子标题
	private Users uno;//发布用户ID
	private String content;//文章内容 包括图片
	private String createdate;//创建日期
	private int status;//0 1 是否冻结封闭
	private List<String> imagesrc; // 图片路径
	public List<String> getImagesrc() {
		return imagesrc;
	}
	public void setImagesrc(List<String> imagesrc) {
		this.imagesrc = imagesrc;
	}
	public Topic1(int tno,FishPond fp, String title, Users uno, String content,
			String createdate, int status) {
		super();
		this.tno = tno;
		this.fp = fp;
		this.title = title;
		this.uno = uno;
		this.content = content;
		this.createdate = createdate;
		this.status = status;
	}
	public Topic1() {
		super();
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	
	public FishPond getFp() {
		return fp;
	}
	public void setFp(FishPond fp) {
		this.fp = fp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
