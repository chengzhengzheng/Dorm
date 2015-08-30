package shifan.action.teacher;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.TeacherDAO;
import shifan.dao.impl.TeacherDAOImpl;
import shifan.pojo.Teacher;
import shifan.service.TeacherService;

public class findTeachersByBuildingID extends BaseAction {
	private List<Teacher> teachers ;
	private int current_BuildingID;
	
	public int getCurrent_BuildingID() {
		return current_BuildingID;
	}
	public void setCurrent_BuildingID(int current_BuildingID) {
		this.current_BuildingID = current_BuildingID;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	private TeacherService teacherService;
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String execute(){
		try {
			teachers = teacherService.findTeachersByBuildingID(current_BuildingID);
		} catch (Exception e) {
			TeacherDAO dao = new TeacherDAOImpl();
			try {
				teachers = dao.findAll();
			} catch (Exception e1) {
			}
		}
		return "success";
	}

}
