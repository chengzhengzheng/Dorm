package shifan.action.building;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.pojo.Building;

public class QueryBuildingManager extends BaseAction{
	private String searchKey;
	private BuildingDAO buildingDao;
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	
	public BuildingDAO getBuildingDao() {
		return buildingDao;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchKey() {
		return searchKey;
	}
	private List<Building>builds;
	public void setBuilds(List<Building> builds) {
		this.builds = builds;
	}
	public List<Building> getBuilds() {
		return builds;
	}
	public String execute(){
		try {
			builds = buildingDao.findBuildingByName(searchKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

}
