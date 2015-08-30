package shifan.service.impl;

import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.dao.StudentDAO;
import shifan.pojo.Domitory;
import shifan.pojo.Student;
import shifan.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDao;
	

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public String studentRZSave(String student_Username, int domitoryID)
			throws Exception {
		Student student = studentDao.findByName(student_Username);
		
		if (student != null) {
			if (student.getStudent_State().equals("δ��ס")) {
				// ���Բ���
				studentDao.studentRZ(student_Username, domitoryID);
				domitoryDao.updateNumber(domitoryID);
				
				return "yes";
			}
			return "no";
		} else {
			return "û�и�ѧ��";
		}
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	private BuildingDAO buildingDao;

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	@Override
	public Student studentTH(String student_Username) throws Exception {
		Student s = null;
		s = studentDao.findByName(student_Username);
		System.out.println("StudentServiceImpl's�����ƣ�" + s);
		if ( null == s ) {// ������û�б���������
			return null;
		}
		int domitoryID = s.getDomitory_ID();
		Domitory d = domitoryDao.findById(domitoryID);
		s.setDomitory_Name(d.getDomitory_Name());
		int buildingID = d.getDomitory_BuildingID();
		s.setBuilding_ID(buildingID);
		String buildingName = buildingDao.findBuildingById(buildingID)
				.getBuilding_Name();
		s.setBuilding_Name(buildingName);
		return s;
	}

}
