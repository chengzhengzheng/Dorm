package shifan.action.student;

import java.util.ArrayList;
import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.dao.StudentDAO;
import shifan.dao.TBDAO;
import shifan.pojo.Domitory;
import shifan.pojo.Student;
import shifan.pojo.Teacher;
import shifan.util.Constants;

public class queryStudentsAction extends BaseAction {
	private StudentDAO studentDao;

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public StudentDAO getStudentDao() {
		return studentDao;
	}

	public String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSearchRow() {
		return searchRow;
	}

	public void setSearchRow(String searchRow) {
		this.searchRow = searchRow;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	private List<Student> students = new ArrayList<Student>();

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	public String execute() {
		log.info("state:" + state + ",searchRow:" + searchRow + ",searchKey:"
				+ searchKey);

		try {
			if (searchKey == null || searchKey.equals("")) {
				// 只是按照状态查找
				if (state.equals("全部")) {
					students = studentDao.findAll();
				} else {
					students = studentDao.findStudentsByState(state);
				}
			} else {
				students = studentDao.findStudents(searchRow, searchKey, state);
			}
			for (Student s : students) {
				String domitory_Name = null;
				if (s.getDomitory_ID() == 0) {
					domitory_Name = "宿舍未定";

				} else {
					domitory_Name = domitoryDao.findById(s.getDomitory_ID())
							.getDomitory_Name();
				}
				s.setDomitory_Name(domitory_Name);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}

	private String searchRow;
	private String searchKey;
private TBDAO tbDao;
public void setTbDao(TBDAO tbDao) {
	this.tbDao = tbDao;
}
private BuildingDAO buildingDao;

public void setBuildingDao(BuildingDAO buildingDao) {
	this.buildingDao = buildingDao;
}

	public String queryMyStudent() {
		try {

			List<Student>all = studentDao.findStudents(searchRow, searchKey, "入住");
			//找出该教师所管理的所有宿舍
			List<Integer> list = null;
			Teacher t = (Teacher) httpSession.getAttribute(Constants.USER);
			list = tbDao.find_BuildingByID(t.getTeacher_ID());//老师所有的楼宇

			for(Student s : all){
				int domitoryID = s.getDomitory_ID();
				Domitory d = domitoryDao.findById(domitoryID);
				if(list.contains(d.getDomitory_BuildingID())){
					students.add(s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "queryMyStudent";
	}

}
