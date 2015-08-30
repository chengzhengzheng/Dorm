package shifan.service;

import java.util.List;

import shifan.pojo.Teacher;

public interface TBService {
	public List<Teacher> findTeachersByBuildingID(int building_ID)throws Exception;

}
