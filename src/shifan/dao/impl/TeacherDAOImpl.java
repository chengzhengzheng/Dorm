package shifan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import shifan.dao.TeacherDAO;
import shifan.exception.DaoException;
import shifan.pojo.Admin;
import shifan.pojo.Teacher;
import shifan.wrapper.TeacherWapper;

public class TeacherDAOImpl extends JdbcDaoSupport implements TeacherDAO {

	@Override
	public Teacher checkLogin(String username, String password) {
		Teacher teacher = null;
		String sql = "select * from teacher where Teacher_Username = ? and Teacher_Password = ?";
		Object obj = this.getJdbcTemplate().queryForObject(sql,
				new Object[] { username, password }, new TeacherWapper());
		if (obj != null)
			teacher = (Teacher) obj;
		return teacher;
	}

	@Override
	public Teacher findById(int id) throws Exception {
		Teacher teacher = null;
		String sql = "select * from teacher where Teacher_ID = ?";
		try {
			teacher = (Teacher) this.getJdbcTemplate().queryForObject(sql,
					new Object[] { id }, new TeacherWapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return teacher;
	}

	@Override
	public List<Integer> findTeachersByBuildingID(int buildingID)
			throws Exception {
		String sql = "select TB_TeacherID from tb where TB_BuildingID = ?";
		try {
			ParameterizedRowMapper<Integer> mapper = new ParameterizedRowMapper<Integer>() {
				public Integer mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Integer i = new Integer(rs.getInt(1));
					return i;
				}
			};
			List<Integer> list = this.getJdbcTemplate().query(sql,
					new Object[] { buildingID }, mapper);
			return list;

		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
	}

	@Override
	public List<Teacher> findAll() throws Exception {
		String sql = "select * from teacher";
		List<Teacher> list = null;
		try {
			list = this.getJdbcTemplate().query(sql, new TeacherWapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return list;
	}

	@Override
	public void insert(Teacher teacher) throws Exception {
		String sql = "insert into teacher (Teacher_Username,Teacher_Password,Teacher_Name,Teacher_Sex,Teacher_Tel)"
				+ "values(?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { teacher.getTeacher_Username(),
						teacher.getTeacher_Password(),
						teacher.getTeacher_Name(), teacher.getTeacher_Sex(),
						teacher.getTeacher_Tel() });
	}

	@Override
	public List<Teacher> findByName(String queryName) throws Exception {
		String sql = "select * from teacher where Teacher_Name = ?";
		List<Teacher> teachers = null;
		try {
			teachers = this.getJdbcTemplate().query(sql,
					new Object[] { queryName }, new TeacherWapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return teachers;
	}

	@Override
	public List<Teacher> findByTel(String tel) throws Exception {
		String sql = "select * from teacher where Teacher_Tel = ?";
		List<Teacher> teachers = null;
		try {
			teachers = this.getJdbcTemplate().query(sql, new Object[] { tel },
					new TeacherWapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return teachers;
	}

	@Override
	public List<Teacher> findByUserName(String userName) throws Exception {
		String sql = "select * from teacher where Teacher_Username = ?";
		List<Teacher> teachers = null;
		try {
			teachers = this.getJdbcTemplate().query(sql,
					new Object[] { userName }, new TeacherWapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return teachers;
	}

	@Override
	public void update(Teacher t) throws Exception {
		String sql = "update teacher set Teacher_Username = ?," +
				"Teacher_Name = ?,Teacher_Password=?,Teacher_Sex=?,Teacher_Tel=? where Teacher_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{t.getTeacher_Username(),t.getTeacher_Name()
				,t.getTeacher_Password(),t.getTeacher_Sex(),t.getTeacher_Tel(),t.getTeacher_ID()});
	}

	@Override
	public void delete(int teacher_ID) throws Exception {
		String sql  = "delete from teacher where Teacher_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{teacher_ID});
	}

	@Override
	public void updatePassword(Admin admin, String password2) throws Exception {
		String sql = "update admin set Admin_Password = ? where Admin_ID = ?";
		this.getJdbcTemplate().update(sql, new Object[]{password2,admin.getAdmin_ID()});
	}
	
	@Override
	public void updatePassword(Teacher t,String password2)throws Exception{
		String sql = "update teacher set Teacher_Password where Teacher_Password = ?";
		this.getJdbcTemplate().update(sql, new Object[]{password2,t.getTeacher_ID()});
	}

}
