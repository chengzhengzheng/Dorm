package shifan.service.impl;
import java.util.List;
import shifan.dao.BuildingDAO;
import shifan.pojo.Building;
import shifan.service.BuildingService;
public class BuildingServiceImpl implements BuildingService {
	private BuildingDAO buildingDao;
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	@Override
	public List<Building> findByTeacherID(int id) {
		return null;
	}
	

}
