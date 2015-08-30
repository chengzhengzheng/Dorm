package shifan.action.student;
import java.util.ArrayList;
import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.dao.StudentDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.pojo.Student;
import shifan.service.StudentService;
public class StudentTH extends BaseAction{
	private String student_Username;//传过来的学号
	private StudentDAO studentDao;
	private Student student;
	private StudentService studentService;
	
	private int buildingID;
	private List<Building> buildinglist;
	private List<Domitory> domitorylist = new ArrayList<Domitory>();
	private DomitoryDAO domitoryDao;
	private BuildingDAO buildingDao;
	private String errorMsg;
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMeg() {
		return errorMsg;
	}
	public String execute(){
	try {
		log.info("student_Username:"+student_Username);
		student = studentService.studentTH(student_Username);

		if(student == null){
			errorMsg = "该生不存在";
			return "nostudent";
		}
		if(student.getStudent_State().equals("还未住")){
			errorMsg = "还没有入住";
			return "nodomitory";
		}
		httpSession.setAttribute("preDomitory", student.getDomitory_ID());
		if (buildingID != 0){
			List<Domitory> domitorylist = domitoryDao.findByBuildingID(buildingID);
			for(Domitory d : domitorylist){
				if(d.getDomitory_totalNumber() >d.getDomitory_Number())
					this.domitorylist.add(d);
			}
		}
		buildinglist = buildingDao.findAll();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "success";
	}
	
	public String StudentTHSave(){
		try {
			System.out.println("save......."+student.getDomitory_ID()+",student_ID:"+student.getStudent_ID());
			studentDao.THSave(student);
			int preDomitory = (Integer) httpSession.getAttribute("preDomitory");
			domitoryDao.updatePerson(preDomitory,student.getDomitory_ID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "save";
	}
	
	public void setStudent_Username(String student_Username) {
		this.student_Username = student_Username;
	}
	public String getStudent_Username() {
		return student_Username;
	}
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	public int getBuildingID() {
		return buildingID;
	}

	public List<Building> getBuildinglist() {
		return buildinglist;
	}

	public void setBuildinglist(List<Building> buildinglist) {
		this.buildinglist = buildinglist;
	}

	public List<Domitory> getDomitorylist() {
		return domitorylist;
	}

	public void setDomitorylist(List<Domitory> domitorylist) {
		this.domitorylist = domitorylist;
	}

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	
}
