package shifan.dao;

import java.util.List;

import shifan.pojo.Building;

public interface TBDAO {
	public List<Integer> find_TeacherID(int builing_ID)throws Exception;
	public boolean add(int building_ID, int tB_TeacherID)throws Exception;
	public void insert(int building_ID, int tB_TeacherID);
	public void delete(int tB_TeacherID, int building_ID)throws Exception;
	public List<Integer> find_BuildingByID(int teacher_ID)throws Exception;

}
