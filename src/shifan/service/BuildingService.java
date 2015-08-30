package shifan.service;

import java.util.List;

import shifan.pojo.Building;

public interface BuildingService {

	public List<Building> findByTeacherID(int id);
	

}
