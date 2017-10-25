package cn.dao;

import java.util.List;

import cn.bean.Label;

public interface LabelDao {
	//获取所有大类标签分类
	public List<Label> getAllLabel();
	//管理员身份可以添加标签
	public boolean addLabel(Label lable);
	//管理员身份可以修改标签信息
	public boolean updateLable(Label lable);
	//通过ID查找单个Label
	public Label findLabelByID(int id);
}
