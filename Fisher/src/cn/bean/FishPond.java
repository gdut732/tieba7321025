package cn.bean;

public class FishPond {
	//����
	private int no;//�������
	private String title;//��������
	private String sign;//��������ǩ��
	private String headimg;//����ͷ��·��
	private Label lno;//�����ǩID
	private Users uno;//�����߱��
	private String createdate;//��������
	private int status;//0 1 �Ƿ񶳽�
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public Label getLno() {
		return lno;
	}
	public void setLno(Label lno) {
		this.lno = lno;
	}
	public Users getUno() {
		return uno;
	}
	public void setUno(Users uno) {
		this.uno = uno;
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
	public FishPond(int no, String title, String sign, String headimg,
			Label lno, Users uno, String createdate, int status) {
		super();
		this.no = no;
		this.title = title;
		this.sign = sign;
		this.headimg = headimg;
		this.lno = lno;
		this.uno = uno;
		this.createdate = createdate;
		this.status = status;
	}
	public FishPond() {
		super();
	}
	
}
