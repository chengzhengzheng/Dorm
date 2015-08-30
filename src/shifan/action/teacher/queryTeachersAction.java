package shifan.action.teacher;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.TeacherDAO;
import shifan.pojo.Teacher;

public class queryTeachersAction extends BaseAction {
	private String searchRow;
	private String searchKey;
	private TeacherDAO teacherDao;
	private List<Teacher> teachers;

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

	public TeacherDAO getTeacherDao() {
		return teacherDao;
	}

	public void setSearchRow(String searchRow) {
		this.searchRow = searchRow;
	}

	public String getSearchRow() {
		return searchRow;
	}

	public String execute() {
		log.info("searchRow:" + searchRow + ",searchKey:" + searchKey);
		if (searchRow.equals("Teacher_Name")) {
			// 按照姓名查找
			try {
				teachers = teacherDao.findByName(searchKey);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (searchRow.equals("Teacher_Tel")) {
			// 按照电话查找
			try {
				teachers = teacherDao.findByTel(searchKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 按照用户名查找
			try {
				teachers = teacherDao.findByUserName(searchKey);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

}
