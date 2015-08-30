package shifan.dao.impl;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import shifan.dao.DomitoryDAO;
import shifan.exception.DaoException;
import shifan.pojo.Domitory;
import shifan.wrapper.DomitoryWrapper;

public class DomitoryDAOImpl extends JdbcDaoSupport implements DomitoryDAO {
	public Domitory findById(int domitory_ID) throws Exception {
		String sql = "select * from domitory where Domitory_ID = ?";
		Domitory d = null;
		try{
			d = (Domitory)this.getJdbcTemplate().queryForObject
					(sql, new Object[]{domitory_ID},new DomitoryWrapper());
		}catch(Exception e){
			//可以用于处理查询queryfor 为空或者多条的时候返回异常的情况，
			//现在返回null,主要是拦截IncorrectResultSizeDataAccessException异常,以及子类
		   //  * @param jdbcTemplateCallBack
			if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
                return null;
		}
		return d;
	}
//ajax请求进行处理
	@Override
	public List<Domitory> findByBuildingID(int buildingID) throws Exception {
		String sql = "select * from domitory where  Domitory_BuildingID = ?";
		List<Domitory> list = null;
		try{
			list = this.getJdbcTemplate().query(sql, new Object[]{buildingID},new DomitoryWrapper());
		}catch(Exception e){
			if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
                return null;
			throw new DaoException();
		}
		return list;
	}
	@Override
	public List<Domitory> findAll() throws Exception {
		String sql = "select * from domitory";
		List<Domitory> list;
		try{
		list = this.getJdbcTemplate().query(sql, new DomitoryWrapper());
		}catch(Exception e){
			if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
                return null;
			throw new DaoException();
		}
		return list;
	}
	@Override
	public void addsave(Domitory domitory) throws Exception {
		String sql = "insert into domitory(Domitory_BuildingID,Domitory_Name,Domitory_Number,Domitory_Person," +
				"Domitory_Tel)values(?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{domitory.getDomitory_BuildingID(),domitory.getDomitory_Name(),
				domitory.getDomitory_totalNumber(),0,domitory.getDomitory_Tel()});
}
	@Override
	public void updatesave(Domitory domitory) throws Exception {
		String sql = "update domitory set Domitory_BuildingID = ?,Domitory_Name = ?,Domitory_Number = ?," +
				"Domitory_Tel = ? where Domitory_ID = ?";
		this.getJdbcTemplate().update(sql, new Object[]{domitory.getDomitory_BuildingID(),domitory.getDomitory_Name(),
				domitory.getDomitory_totalNumber(),domitory.getDomitory_Tel(),domitory.getDomitory_ID()});
	}
	@Override
	public void delete(int domitory_ID) throws Exception {
		String sql = "delete from domitory where Domitory_ID = ?";
		this.getJdbcTemplate().update(sql, new Object[]{domitory_ID});
	}
	@Override
	public List<Domitory> findBySearchRow(String searchRow, String searchKey)
			throws Exception {
		String sql  = "select * from domitory where "+searchRow +" =? ";
		List<Domitory> list = null;
		try{
			 list = this.getJdbcTemplate().query(sql, new Object[]{searchKey},new DomitoryWrapper());
		}catch(Exception e){
			if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
                return null;
			throw new DaoException();
		}
		return list;
	}
	@Override
	public List<Domitory> findByBuildingAndSearch(int domitory_BuildingID,
			String searchRow, String searchKey) throws Exception {
		String sql = "select * from domitory where Domitory_BuildingID = ? and "+searchRow +"=?";
		List<Domitory> list = null;
		try{
			list = this.getJdbcTemplate().query(sql, new Object[]{domitory_BuildingID,searchKey}, new DomitoryWrapper());
		}catch(Exception e){
			if((e instanceof IncorrectResultSizeDataAccessException)
                    &&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
                return null;
			throw new DaoException();
		}
		return list;
	}
	@Override
	public void updateNumber(int domitoryID) throws Exception {
		String sql = "update Domitory set Domitory_Person = Domitory_Person + 1 where Domitory_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{domitoryID});
	}
	@Override
	public void updatePerson(int preDomitory, int domitory_ID) throws Exception {
		String sql = "update Domitory set Domitory_Person = Domitory_Person - 1 where Domitory_ID = ?";
		String sql2 = "update Domitory set Domitory_Person = Domitory_Person +1 where Domitory_ID=?" ;
		System.out.println("是否执行调换宿舍"+preDomitory+","+domitory_ID);
		this.getJdbcTemplate().update(sql,new Object[]{preDomitory});
		this.getJdbcTemplate().update(sql2,new Object[]{domitory_ID});
		
	}

}
