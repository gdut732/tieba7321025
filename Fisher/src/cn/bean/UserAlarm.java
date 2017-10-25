package cn.bean;

public class UserAlarm {

	private Users user;//收到消息者
	private Users sender;
	/*
	 * 1.回复 
	 * 2.私信 
	 * 3.点赞
	 * 4.系统通知 
	 * 5.被人@
	 */
	private int msgtype;
	private Topic1 topic1;//目标话题
	private String msg;
	private int isread;//01是否已读标志位
	private int uano; //表编号
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
