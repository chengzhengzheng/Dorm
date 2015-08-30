package shifan.dao;

import java.util.List;

import shifan.pojo.Domitory;

public interface DomitoryDAO {
	public Domitory findById(int domitory_ID)throws Exception;
	public List<Domitory>findByBuildingID(int buildingID)throws Exception;	
	public List<Domitory>findAll()throws Exception;
	public void addsave(Domitory domitory)throws Exception;
	public void updatesave(Domitory domitory)throws Exception;
	public void delete(int domitory_ID)throws Exception;
	public List<Domitory> findBySearchRow(String searchRow, String searchKey)throws Exception;
	public List<Domitory> findByBuildingAndSearch(int domitory_BuildingID,
			String searchRow, String searchKey)throws Exception;
	public void updateNumber(int domitoryID)throws Exception;
	public void updatePerson(int preDomitory, int domitory_ID)throws Exception;
	
	

}
