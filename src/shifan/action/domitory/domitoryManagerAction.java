package shifan.action.domitory;

import java.util.List;

import shifan.action.BaseAction;
import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.service.DomitoryService;

public class domitoryManagerAction extends BaseAction{
	private List<Domitory> domitorys;
	private DomitoryDAO domitoryDao;
	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}
	public DomitoryDAO getDomitoryDao() {
		return domitoryDao;
	}
	public void setDomitorys(List<Domitory> domitorys) {
		this.domitorys = domitorys;
	}
	public List<Domitory> getDomitorys() {
		return domitorys;
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
	private DomitoryService domitoryService;
	public void setDomitoryService(DomitoryService domitoryService) {
		this.domitoryService = domitoryService;
	}
	public String list(){
		try {
			domitorys = domitoryService.findAll();

			buildingList = buildingDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	
	public String add(){
		try {
			buildingList = buildingDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "add";
	}
	
	
	private Domitory domitory;
	public void setDomitory(Domitory domitory) {
		this.domitory = domitory;
	}
	public Domitory getDomitory() {
		return domitory;
	}
	public String addsave(){
		try {
			domitoryDao.addsave(domitory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addsave";
	}
	
	private int domitory_ID;
	public void setDomitory_ID(int domitory_ID) {
		this.domitory_ID = domitory_ID;
	}
	public int getDomitory_ID() {
		return domitory_ID;
	}
	public String update(){
		try {
			domitory = domitoryDao.findById(domitory_ID);
			buildingList = buildingDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update";
	}
	
	public String updatesave(){
		try {
			domitoryDao.updatesave(domitory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updatesave";
	}
	
	/**
	 * 此方法为补充实现
	 * @return
	 */
	public String del(){
		try {
			domitoryDao.delete(domitory_ID);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "del";
	}
}
