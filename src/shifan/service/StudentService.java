package shifan.service;

import shifan.pojo.Student;

public interface StudentService {
	public String studentRZSave(String student_Username,int domitoryID)throws Exception;
	public Student studentTH(String student_Username)throws Exception;

}
