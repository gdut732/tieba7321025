package cn.dao;

import java.util.List;

import cn.bean.FishPond;
import cn.bean.PageBean;

public interface FishPoundDao {
	//模糊查询   筛选名称相似的鱼塘
	public List<FishPond> getLikeNameList(String namex);
	//获取所有鱼塘列表
	public PageBean<FishPond> getAllFishPound(int size,int index);
	//用户可以创建一个鱼溏
	public boolean createFishPound(FishPond fishpound);
	//修改、鱼塘头像、个性签名、冻结
	public boolean updateFishPound(FishPond fishpound);
	//检查鱼塘名字是否为重复
	public boolean checkName(String name);
	//通过ID查找单个Fishpound
	public FishPond findFishPondByID(int ID);
	//冻结一个鱼塘
	public boolean freezeFishPound(int ID);
	//根据类型标签ID查询
	public PageBean<FishPond> findLabelFishPound(int id,int size,int index);
	//获取当前一个鱼塘的信息
	public FishPond getFishPound(int no);
	
}
