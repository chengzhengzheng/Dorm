package shifan.dao;

import java.util.List;

import shifan.pojo.Building;
import shifan.pojo.Teacher;

public interface BuildingDAO {
	public List<Building> findAll()throws Exception;
	public Building findBuildingById(int building_ID)throws Exception;
	public void insert(String building_Name, String building_Introduction)throws Exception;
	public List<Building> findBuildingByName(String searchKey)throws Exception;
	public void updatesave(Building building)throws Exception;
	public void delete(int building_ID)throws Exception;
	
	

}
