package shifan.service.impl;

import java.util.ArrayList;
import java.util.List;

import shifan.dao.BuildingDAO;
import shifan.dao.DomitoryDAO;
import shifan.pojo.Building;
import shifan.pojo.Domitory;
import shifan.service.DomitoryService;

public class DomitoryServiceImpl implements DomitoryService {
	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	private BuildingDAO buildingDao;

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	@Override
	public List<Domitory> findAll() throws Exception {
		List<Domitory> list = domitoryDao.findAll();
		for (Domitory d : list) {
			int id = d.getDomitory_BuildingID();
			Building building = buildingDao.findBuildingById(id);
			d.setDomitory_BuildingName(building.getBuilding_Name());
		}
		return list;
	}

	@Override
	public List<Domitory> findByBuildingAndSearch(int domitory_BuildingID,
			String searchRow) throws Exception {
		List<Domitory> list = new ArrayList<Domitory>();
		if (domitory_BuildingID == 0) {
			// 查找全部楼宇

			if ("Domitory_all".equals(searchRow)) {
				list = domitoryDao.findAll();
			} else {
				// 查找出可用的宿舍
				List<Domitory> dos = domitoryDao.findAll();
				for (Domitory d : dos) {
					if (d.getDomitory_totalNumber() > d.getDomitory_Number()) {
						list.add(d);
					}
				}

			}
			for (Domitory d : list) {
				String name = buildingDao.findBuildingById(
						d.getDomitory_BuildingID()).getBuilding_Name();
				d.setDomitory_BuildingName(name);
			}

		} else {
			// 根据楼宇查询查出部分楼宇
			if ("Domitory_all".equals(searchRow)) {
				list = domitoryDao.findAll();
			} else {
				// 查找出可用的宿舍
				List<Domitory> dos = domitoryDao.findAll();
				for (Domitory d : dos) {
					if (d.getDomitory_totalNumber() > d.getDomitory_Number()
							&& d.getDomitory_BuildingID() == domitory_BuildingID) {
						list.add(d);
					}
				}

			}
			for (Domitory d : list) {
				String name = buildingDao.findBuildingById(
						d.getDomitory_BuildingID()).getBuilding_Name();
				d.setDomitory_BuildingName(name);
			}
		}
		return list;
	}

}
