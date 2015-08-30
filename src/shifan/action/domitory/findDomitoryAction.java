package shifan.action.domitory;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.service.DomitoryService;

public class findDomitoryAction extends BaseAction {
	private int current_BuildingID;
	private List<Domitory> domitorys;
	private DomitoryDAO domitoryDao;

	public String execute() {
		try {
			domitorys = domitoryDao.findByBuildingID(current_BuildingID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public void setCurrent_BuildingID(int current_BuildingID) {
		this.current_BuildingID = current_BuildingID;
	}

	public int getCurrent_BuildingID() {
		return current_BuildingID;
	}

	private int domitory_BuildingID;

	public void setDomitory_BuildingID(int domitory_BuildingID) {
		this.domitory_BuildingID = domitory_BuildingID;
	}

	public int getDomitory_BuildingID() {
		return domitory_BuildingID;
	}

	private String searchRow;

	public void setSearchRow(String searchRow) {
		this.searchRow = searchRow;
	}
	private DomitoryService domitoryService;
	public void setDomitoryService(DomitoryService domitoryService) {
		this.domitoryService = domitoryService;
	}
	public DomitoryService getDomitoryService() {
		return domitoryService;
	}
	public String getSearchRow() {
		return searchRow;
	}
	private List<Building> buildingList;
	public void setBuildingList(List<Building> buildingList) {
		this.buildingList = buildingList;
	}
	public List<Building> getBuildingList() {
		return buildingList;
	}
	private BuildingDAO buildingDao;
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
	public BuildingDAO getBuildingDao() {
		return buildingDao;
	}
	public String find() {
		try {
		//¸ù¾ÝÂ¥Óî²éÕÒ
			domitorys = domitoryService.findByBuildingAndSearch(domitory_BuildingID, searchRow);
			buildingList = buildingDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "find";
		
	}

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	public List<Domitory> getDomitorys() {
		return domitorys;
	}

	public void setDomitorys(List<Domitory> domitorys) {
		this.domitorys = domitorys;
	}

}
