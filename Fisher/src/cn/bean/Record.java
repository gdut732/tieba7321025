package cn.bean;

public class Record {
  //�����¼
	private Users uno;//�����û�ID
	private Topic1 tno1;//С����
	private String createdate;//��������
	public Record(Users uno, Topic1 tno1, String createdate) {
		super();
		this.uno = uno;
		this.tno1 = tno1;
		this.createdate = createdate;
	}
	public Record() {
		super();
	}
	public Users getUno() {
		return uno;
	}
	public void setUno(Users uno) {
		this.uno = uno;
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
	
}
