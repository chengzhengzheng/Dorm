package shifan.action.student;

import java.util.ArrayList;
import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.dao.StudentDAO;
import shifan.dao.TBDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.pojo.Student;
import shifan.pojo.Teacher;
import shifan.util.Constants;

public class StudentManagerAction extends BaseAction {
	/**
	 * 查出所有宿舍的学生
	 * 
	 * @return
	 */
	private StudentDAO studentDao;

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	private List<Student> students = new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	private TBDAO tBDao;
	private BuildingDAO buildingDao;
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	public void setTbDao(TBDAO tBDao) {
		this.tBDao = tBDao;
	}
	private List<Building> myBuildings = new ArrayList<Building>();
	public void setMyBuildings(List<Building> myBuildings) {
		
		this.myBuildings = myBuildings;
	}
	public List<Building> getMyBuildings() {
		return myBuildings;
	}
	public String mybuilding() {
		Teacher teacher = (Teacher) httpSession.getAttribute(Constants.USER);
		// tBDao.findBuilding();
		try {
			List<Integer> list = tBDao.find_BuildingByID(teacher.getTeacher_ID());
			if(null != list && list.size() != 0){
				for(Integer i : list){
					myBuildings.add(buildingDao.findBuildingById(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mybuilding";
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	private int Building_ID;
	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}
	public int getBuilding_ID() {
		return Building_ID;
	}
	public String listMyStudent(){
		try {
			List<Student>s = studentDao.findAll();
			for(Student ss : s){
				int id = ss.getDomitory_ID();
				Domitory d = domitoryDao.findById(id);
				if(d.getDomitory_BuildingID() ==Building_ID ){
					students.add(ss);
				}
			}
			String domitory_Name = null;
			for (Student t : students) {
				if (t.getDomitory_ID() == 0) {
					domitory_Name = "宿舍未定";
				} else {
					domitory_Name = domitoryDao.findById(t.getDomitory_ID())
							.getDomitory_Name();
				}
				t.setDomitory_Name(domitory_Name);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listMyStudent";
		
	}
	public String list() {
		try {
			students = studentDao.findAll();
			String domitory_Name = null;
			for (Student s : students) {
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
		return "list";
	}

	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public String add() {
		try {
			studentDao.add(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "add";
	}

	private int student_ID;

	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}

	public int getStudent_ID() {
		return student_ID;
	}

	public String update() {
		try {
			student = studentDao.findById(student_ID);
			log.info("update是student_ID:" + student.getStudent_State());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "update";
	}

	public String updatesave() {
		log.info("保存修改：" + student.getStudent_ID() + ",student_state:"
				+ student.getStudent_State());
		try {
			studentDao.update(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updatesave";
	}

	public String del() {
		try {
			studentDao.delete(student_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del";
	}
}