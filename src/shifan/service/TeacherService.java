package shifan.service;

import java.util.List;

import shifan.pojo.Teacher;

public interface TeacherService {
	public List<Teacher> findTeachersByBuildingID(int buildingID)throws Exception;

}
