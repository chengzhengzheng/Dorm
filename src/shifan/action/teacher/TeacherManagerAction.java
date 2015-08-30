package shifan.action.teacher;

import java.util.List;

import org.apache.struts2.views.jsp.SetTag;

import shifan.action.BaseAction;
import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;

public class TeacherManagerAction extends BaseAction {
	private TeacherDAO teacherDao;
	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}
	private List<Teacher> teachers;
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public String list(){
		try {
			teachers = teacherDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	
	private Teacher teacher;
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public String addsave(){
		try {
			log.info("开始增加教师！");
			teacherDao.insert(teacher);
			log.info("增加教师成功!");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("转向success视图");
		return "add_save";
	}

	
	private int teacher_ID;
	public void setTeacher_ID(int teacher_ID) {
		this.teacher_ID = teacher_ID;
	}
	public int getTeacher_ID() {
		return teacher_ID;
	}
	private Teacher current_Teacher;
	public void setCurrent_Teacher(Teacher current_Teacher) {
		this.current_Teacher = current_Teacher;
	}
	public Teacher getCurrent_Teacher() {
		return current_Teacher;
	}
	
	public String update(){
		log.info("进行更新："+teacher_ID);
		try {
			current_Teacher = teacherDao.findById(teacher_ID);
			log.info("查找current_Teacher:"+current_Teacher.getTeacher_Name()+","+current_Teacher.getTeacher_Password()+","
					+current_Teacher.getTeacher_Sex()+","+current_Teacher.getTeacher_Username());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "update";
	}
	

	
	
	public String updatesave(){
		log.info("更新操作。。。");
		try {
			log.info("即将更新的current_Teacher:"+current_Teacher.getTeacher_Name()+","+current_Teacher.getTeacher_Password()+","
					+current_Teacher.getTeacher_Sex()+","+current_Teacher.getTeacher_Username());
			teacherDao.update(current_Teacher);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return "update_save";
	}
	
	public String del(){
		log.info("即将删除："+teacher_ID);
		try {
			teacherDao.delete(teacher_ID);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "del_save";
		
	}
}
