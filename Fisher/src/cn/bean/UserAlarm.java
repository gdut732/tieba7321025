package cn.bean;

public class UserAlarm {

	private Users user;//�յ���Ϣ��
	private Users sender;
	/*
	 * 1.�ظ� 
	 * 2.˽�� 
	 * 3.����
	 * 4.ϵͳ֪ͨ 
	 * 5.����@
	 */
	private int msgtype;
	private Topic1 topic1;//Ŀ�껰��
	private String msg;
	private int isread;//01�Ƿ��Ѷ���־λ
	private int uano; //����
	public UserAlarm() {}
	public UserAlarm(Users user, Users sender, int msgtype, Topic1 topic1,
			String msg, int isread, int uano)
	{
		super();
		this.user = user;
		this.sender = sender;
		this.msgtype = msgtype;
		this.topic1 = topic1;
		this.msg = msg;
		this.isread = isread;
		this.uano = uano;
	}
	public Users getUser()
	{
		return user;
	}
	public void setUser(Users user)
	{
		this.user = user;
	}
	public Users getSender()
	{
		return sender;
	}
	public void setSender(Users sender)
	{
		this.sender = sender;
	}
	public int getMsgtype()
	{
		return msgtype;
	}
	public void setMsgtype(int msgtype)
	{
		this.msgtype = msgtype;
	}
	public Topic1 getTopic1()
	{
		return topic1;
	}
	public void setTopic1(Topic1 topic1)
	{
		this.topic1 = topic1;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public int getIsread()
	{
		return isread;
	}
	public void setIsread(int isread)
	{
		this.isread = isread;
	}
	public int getUano()
	{
		return uano;
	}
	public void setUano(int uano)
	{
		this.uano = uano;
	}
	
}
