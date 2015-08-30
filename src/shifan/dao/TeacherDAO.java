package shifan.dao;

import java.util.List;

import shifan.pojo.Admin;
import shifan.pojo.Teacher;

public interface TeacherDAO {

	public Teacher checkLogin(String username, String password);
	public Teacher findById(int id)throws Exception;
	public List<Integer> findTeachersByBuildingID(int buildingID)throws Exception;
	public List<Teacher> findAll()throws Exception;
	public void insert(Teacher teacher)throws Exception;
	public List<Teacher>findByName(String queryName)throws Exception;
	public List<Teacher>findByTel(String tel)throws Exception;
	public List<Teacher>findByUserName(String userName)throws Exception;
	public void update(Teacher t)throws Exception;
	public void delete(int teacher_ID)throws Exception;
	public void updatePassword(Teacher t, String password2)throws Exception;
	void updatePassword(Admin admin, String password2) throws Exception;
	
	

}
