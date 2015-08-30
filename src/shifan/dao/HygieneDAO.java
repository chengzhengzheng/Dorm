package shifan.dao;

import java.util.List;

import shifan.pojo.Hygiene;

public interface HygieneDAO {
	public List<Hygiene> findAll(int week)throws Exception;
	public List<Hygiene>findById(int building_ID)throws Exception;
	public Hygiene findByDor(int dormitory_ID)throws Exception;
	public void insert(Hygiene hygiene)throws Exception;
	public void del(int domitory_ID)throws Exception;
	public void updatesave(Hygiene hygiene)throws Exception;
	public List<Hygiene> query(int building_ID,String searchKey)throws Exception;
	public List<Hygiene> findByBuilding(int building_ID)throws Exception;
	public boolean findByWeekAndDomitory(int w, int domitory_ID)throws Exception;
	public List<Hygiene> findByWeekAndD(int week_Number,
			int domitory_BuildingID)throws Exception;

}
