package shifan.dao.impl;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import shifan.dao.BuildingDAO;
import shifan.exception.DaoException;
import shifan.pojo.Building;
import shifan.wrapper.BuildingWrapper;

public class BuildingDAOImpl extends JdbcDaoSupport implements BuildingDAO {
	@Override
	public List<Building> findAll() throws Exception {
		String sql = "select * from building";
		List<Building> list;
		try {
			list = this.getJdbcTemplate().query(sql, new BuildingWrapper());
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	

	
	

	

	
	@Override
	public Building findBuildingById(int building_ID) throws Exception {
		String sql = "select * from building where Building_ID = ?";
		Building building = null;
		try{
			building = (Building) this.getJdbcTemplate().queryForObject(sql, new Object[]{building_ID},new BuildingWrapper());
			return building;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void insert(String building_Name, String building_Introduction)
			throws Exception {
		String sql = "insert into building(Building_Name,Building_Introduction) values(?,?)";
		this.getJdbcTemplate().update(sql,new Object[]{building_Name,building_Introduction});
	}

	@Override
	public List<Building> findBuildingByName(String searchKey) throws Exception {
		String sql = "select * from building where Building_Name = ?";
		List<Building> list = null;
		try{
		list = this.getJdbcTemplate().query(sql, new Object[]{searchKey},new BuildingWrapper());
		return list;
		}catch(Exception e){
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
	}









	@Override
	public void updatesave(Building building) throws Exception {
		String sql  = "update building set Building_Name = ?, Building_Introduction = ? where Building_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{building.getBuilding_Name(),
				building.getBuilding_Introduction(),
				building.getBuilding_ID()});
	}









	@Override
	public void delete(int building_ID) throws Exception {
		String sql  = "delete from building where Building_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{building_ID});
		
	}

}
