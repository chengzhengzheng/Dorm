package shifan.service;

import java.util.List;

import shifan.pojo.Domitory;

public interface DomitoryService {
	public List<Domitory> findAll()throws Exception;
	public List<Domitory> findByBuildingAndSearch(int domitory_BuildingID,
			String searchRow)throws Exception;

}
