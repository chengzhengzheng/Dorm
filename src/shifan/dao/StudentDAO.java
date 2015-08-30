package shifan.dao;

import java.util.List;

import shifan.pojo.Admin;
import shifan.pojo.Student;

public interface StudentDAO {

	public Admin checkLogin(String username, String password)throws Exception;
	public List<Student> findAll()throws Exception;
	public void add(Student student)throws Exception;
	public List<Student> findStudents(String searchRow,String searchKey,String state)throws Exception;
	public List<Student> findStudentsByState(String state)throws Exception;
	public Student findById(int student_ID)throws Exception;
	public void update(Student student)throws Exception;
	public void delete(int student_ID)throws Exception;
	public void studentRZ(String student_Username,int domitoryID)throws Exception;
	public Student findByName(String student_Username)throws Exception;
	public void THSave(Student student)throws Exception;
	public void upatePassword(Student s, String password2)throws Exception;
	public boolean checkPasswor(Object obj, String password)throws Exception;
	public List<Student> findByBuildingId(int building_ID)throws Exception;


}
