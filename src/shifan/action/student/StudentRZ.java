package shifan.action.student;

import java.util.ArrayList;
import java.util.List;

import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.service.StudentService;

public class StudentRZ {
	private List<Building> buildinglist;

	public void setBuildinglist(List<Building> buildinglist) {
		this.buildinglist = buildinglist;
	}

	public List<Building> getBuildinglist() {
		return buildinglist;
	}

	private int buildingID;

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	private BuildingDAO buildingDao;

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	public DomitoryDAO getDomitoryDao() {
		return domitoryDao;
	}

	private List<Domitory> domitorylist = new ArrayList<Domitory>();

	public void setDomitorylist(List<Domitory> domitorylist) {
		this.domitorylist = domitorylist;
	}

	public List<Domitory> getDomitorylist() {
		return domitorylist;
	}

	
	public String execute() {
		try {
			if (buildingID != 0){
				List<Domitory>domitorylist = domitoryDao.findByBuildingID(buildingID);
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
	
	private String student_Username;
	public void setStudent_Username(String student_Username) {
		this.student_Username = student_Username;
	}
	public String getStudent_Username() {
		return student_Username;
	}
	private int domitoryID;
	public void setDomitoryID(int domitoryID) {
		this.domitoryID = domitoryID;
	}
	public int getDomitoryID() {
		return domitoryID;
	}
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public String RZsave(){
		try {
			String flag = studentService.studentRZSave(student_Username, domitoryID);
			System.out.println("StudentRZ.java:flag:"+flag);
			if(flag.equals("no")){
				return "hasdomitory";
			}
			if(flag.equals("没有该学生")){
				return "nostudent";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "save";
	}

}
