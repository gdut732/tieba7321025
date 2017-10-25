package cn.bean;
/*
 * 关注鱼塘
 */
public class UserFocus_pound {
	private Users user;
	private FishPond fishpond;
	private long exp;
	private int level;
	
	public UserFocus_pound() {
	}
	public UserFocus_pound(Users user, FishPond fishpond, long exp) {
	
		this.user = user;
		this.fishpond = fishpond;
		this.exp = exp;
		setLevel();
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public FishPond getFishpond() {
		return fishpond;
	}
	public void setFishpond(FishPond fishpond) {
		this.fishpond = fishpond;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
		setLevel();
	}
	public int getLevel() {
		return level;
	}
	public void setLevel() {
		double t = 50;//初始经验值
		for(int i=1;true;i++){
			if(this.exp<t){
				this.level=i-1;	
				break;
			}
			if(i>42){
				t=t+400;
			}else{
				t=t*1.2;
			}
		}
	}
	
}
