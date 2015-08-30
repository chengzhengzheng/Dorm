package shifan.dao.impl;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mysql.jdbc.PreparedStatement;

import shifan.dao.TBDAO;
import shifan.exception.DaoException;
import shifan.pojo.Building;

public class TBDAOImpl extends JdbcDaoSupport implements TBDAO {
	@Override
	public boolean add(int building_ID, int beacher_ID) throws Exception {
		String sql = "select TB_ID from tb where TB_BuildingID = ? and TB_TeacherID = ?";
		try {
			int id = this.getJdbcTemplate().queryForInt(sql,
					new Object[] { building_ID, beacher_ID });
			// 沒有出現異常、说明已经存在了、不能重复添加了
			return false;
		} catch (Exception e) {
		}
		return true;
	}

	@Override
	public List<Integer> find_TeacherID(int buildingID) throws Exception {
		String sql = "select TB_TeacherID from tb where TB_BuildingID = ?";
		List<Integer>  list = null;
		try{
		 list = this.getJdbcTemplate().queryForList(sql, new Object[]{buildingID},Integer.class);
		 System.out.println("list："+list);
		 return list;
		}catch(Exception e){
			System.out.println("异常出现了。。。。");
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				
				return null;
		}
		return list;
	}

	@Override
	public void insert(int building_ID, int tB_TeacherID) {
		String sql = "insert into tb(TB_TeacherID,TB_BuildingID)values(?,?)";
		this.getJdbcTemplate().update(sql,new Object[]{tB_TeacherID,building_ID});
	}

	@Override
	public void delete(int tB_TeacherID, int building_ID) throws Exception {
		String sql = "delete from tb  where TB_TeacherID = ? and  TB_BuildingID = ?";
		this.getJdbcTemplate().update(sql, new Object[]{tB_TeacherID,building_ID});
		
	}

	@Override
	public List<Integer> find_BuildingByID(int teacher_ID) throws Exception {
		String sql = "select TB_BuildingID from tb where TB_TeacherID = ?";
		List<Integer> list = this.getJdbcTemplate().queryForList(sql, new Object[]{teacher_ID},Integer.class);
		
		
		return list;
	}	

}
