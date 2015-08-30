package shifan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import shifan.dao.DomitoryDAO;
import shifan.dao.HygieneDAO;
import shifan.exception.DaoException;
import shifan.pojo.Domitory;
import shifan.pojo.Hygiene;
import shifan.wrapper.HygieneWrapper;

public class HygieneDAOImpl extends JdbcDaoSupport implements HygieneDAO {

	@Override
	public List<Hygiene> findAll(int week) throws Exception {
		String sql = " select h.id,h.score,h.teacher_ID,h.week,h.teacher_Type,d.* from domitory d   left outer  join hygiene h on d.Domitory_ID = h.Domitory_ID and week = ?";
		List<Hygiene> list = null;
		try {
			list = this.getJdbcTemplate().query(sql, new Object[] { week },
					new HygieneWrapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
		}

		return list;
	}

	@Override
	public List<Hygiene> findById(int building_ID) throws Exception {
		String sql = "select * from hygiene where Building_ID = ?";
		List<Hygiene> list = this.getJdbcTemplate().query(sql,
				new Object[] { building_ID }, new HygieneWrapper());
		return list;
	}

	@Override
	public Hygiene findByDor(int dormitory_ID) throws Exception {
		String sql = "select * from hygiene where Domitory_ID = ?";
		try {
			Hygiene hygiene = (Hygiene) this.getJdbcTemplate().queryForObject(
					sql, new Object[] { dormitory_ID }, new HygieneWrapper());
			return hygiene;
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;

		}
		return null;
	}

	@Override
	public void insert(Hygiene hygiene) throws Exception {
		String sql = "insert into hygiene(Domitory_ID,score,Teacher_ID,week,teacher_type)values(?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { hygiene.getDomitory_ID(), hygiene.getScore(),
						hygiene.getTeacher_ID(), hygiene.getWeek(),
						hygiene.getTeacher_Type() });

	}

	@Override
	public void del(int domitory_ID) throws Exception {
		String sql = "delete from hygiene where Domitory_ID = ?";
		this.getJdbcTemplate().update(sql, new Object[] { domitory_ID });
	}

	@Override
	public void updatesave(Hygiene hygiene) throws Exception {
		String sql = "update hygiene set score = ? where Domitory_ID = ? and week = ?";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { hygiene.getScore(), hygiene.getDomitory_ID(),
						hygiene.getWeek() });
	}

	@Override
	public List<Hygiene> query(int building_ID, String searchKey)
			throws Exception {
		List<Hygiene> list = null;
		try {
			if (building_ID != 0) {
				String sql = "select h.* from hygiene h join domitory d on"
						+ " h.Domitory_ID = d.Domitory_ID  where "
						+ "d.Domitory_Name = ? and h.Building_ID= ?";

				list = this.getJdbcTemplate().query(sql,
						new Object[] { searchKey, building_ID },
						new HygieneWrapper());
				return list;
			} else {
				String sql = "select h.* from hygiene h join domitory d on h.Domitory_ID = d.Domitory_ID  where "
						+ "d.Domitory_Name = ?";
				list = this.getJdbcTemplate().query(sql,
						new Object[] { searchKey }, new HygieneWrapper());
				return list;
			}
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
		}
		return null;
	}

	@Override
	public List<Hygiene> findByBuilding(int building_ID) throws Exception {
		List<Hygiene> list = null;
		if (building_ID == 0) {
			list = findAll(1);
		} else {
			try {
				String sql = "select * from hygiene where Building_ID = ?";
				list = this.getJdbcTemplate().query(sql,
						new Object[] { building_ID }, new HygieneWrapper());
				return list;
			} catch (Exception e) {
				if ((e instanceof IncorrectResultSizeDataAccessException)
						&& ((IncorrectResultSizeDataAccessException) e)
								.getActualSize() == 0)
					return null;
			}
		}
		return list;
	}

	@Override
	public boolean findByWeekAndDomitory(int w, int domitory_ID)
			throws Exception {
		String sql = "select * from hygiene where week = ? and  Domitory_ID = ?";
		try {

			List<Hygiene> list = this.getJdbcTemplate().query(sql,
					new Object[] { w, domitory_ID }, new HygieneWrapper());
			if (list == null || list.size() == 0) {
				return false;
			}

		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return false;
		}
		return true;
	}

	private DomitoryDAO domitoryDao;

	public void setDomitoryDao(DomitoryDAO domitoryDao) {
		this.domitoryDao = domitoryDao;
	}

	@Override
	public List<Hygiene> findByWeekAndD(int week_Number, int domitory_BuildingID)
			throws Exception {
		List<Hygiene> list = new ArrayList<Hygiene>();
		System.out.println("week_Number:" + week_Number
				+ ",domitory_BuildingID:" + domitory_BuildingID);
		List<Domitory> dos = domitoryDao.findByBuildingID(domitory_BuildingID);
		for (Domitory d : dos) {
			Hygiene ds = findByDor(d.getDomitory_ID());
			if (ds != null) {
				ds.setBuilding_ID(d.getDomitory_BuildingID());
				ds.setBuilding_Name(d.getDomitory_BuildingName());
				ds.setDomitory_Name(d.getDomitory_Name());
				list.add(ds);
			} else {
				Hygiene h = new Hygiene();
				h.setBuilding_ID(d.getDomitory_BuildingID());
				h.setScore(0);
				h.setBuilding_Name(d.getDomitory_BuildingName());
				h.setDomitory_Name(d.getDomitory_Name());
				list.add(h);
			}
		}
		return list;

	}

}
