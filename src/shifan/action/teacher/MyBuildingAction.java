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
		//�ó����иý�ʦ�����¥���װ��һ��list���ϵ���ʽ����ҳ������ʾ�����Ϳ�����
		return "success";
	}

}
