package shifan.action.building;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.pojo.Building;

public class BuildingManagerAction extends BaseAction{
	private List<Building> builds;
	public void setBuilds(List<Building> builds) {
		this.builds = builds;
	}
	public List<Building> getBuilds() {
		return builds;
	}
	//action由spring插件创建、会自动装配dao
	private BuildingDAO buildingDao;
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	public String list(){
		try {
			builds = buildingDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	private Building building;
	public void setBuilding(Building building) {
		this.building = building;
	}
	public Building getBuilding() {
		return building;
	}
	public String addsave(){
		log.info("builing:"+building.getBuilding_Name()+","+building.getBuilding_Introduction());
		try {
			buildingDao.insert(building.getBuilding_Name(), building.getBuilding_Introduction());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addsave";
	}
	
	private int building_ID;
	public void setBuilding_ID(int building_ID) {
		this.building_ID = building_ID;
	}
	public int getBuilding_ID() {
		return building_ID;
	}
	public String update(){
		try {
			building = buildingDao.findBuildingById(building_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update";
	}

	//修改保存
	
	public String updatesave(){
		try {
			buildingDao.updatesave(building);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updatesave";
	}
	
	public String del(){
		try {
			buildingDao.delete(building_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del";
	}
}
