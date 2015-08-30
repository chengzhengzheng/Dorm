package shifan.action.teacher;

import java.util.ArrayList;
import java.util.List;

import shifan.action.BaseAction;
import shifan.pojo.Building;

public class MyBuildingAction extends BaseAction{
	private int teacherId;
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public List<Building> list = new ArrayList<Building>();
	public void setList(List<Building> list) {
		this.list = list;
	}
	public List<Building> getList() {
		return list;
	}
	public String execute(){
		//拿出所有该教师管理的楼宇包装成一个list集合的形式、在页面中显示出来就可以了
		return "success";
	}

}
