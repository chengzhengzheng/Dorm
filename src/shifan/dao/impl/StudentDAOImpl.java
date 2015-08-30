package shifan.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import shifan.dao.StudentDAO;
import shifan.exception.DaoException;
import shifan.pojo.Admin;
import shifan.pojo.Student;
import shifan.pojo.Teacher;
import shifan.util.Constants;
import shifan.wrapper.AdminWrapper;
import shifan.wrapper.StudentWrapper;

public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO {

	@Override
	public Admin checkLogin(String username, String password) throws Exception {
		Admin obj = null;
		String sql = "select * from admin where Admin_Username = ? and Admin_Password = ?";
		try {
			obj = (Admin) this.getJdbcTemplate().queryForObject(sql,
					new Object[] { username, password }, new AdminWrapper());
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
		return obj;
	}

	@Override
	public List<Student> findAll() throws Exception {
		String sql = "select * from student";
		List<Student> list = null;
		try {
			list = this.getJdbcTemplate().query(sql, new StudentWrapper());
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
	// 程征,123,男,1109034114,null
	public void add(Student student) throws Exception {
		String sql = "insert into student(Student_Username,Student_Password,Student_Name,"
				+ "Student_Sex,Student_Class,Student_State)values(?,?,?,?,?,?)";
		this.getJdbcTemplate().update(
				sql,
				new Object[] { student.getStudent_Username(),
						student.getStudent_Password(),
						student.getStudent_Name(), student.getStudent_Sex(),
						student.getStudent_Class(), Constants.NOTIN });
	}

	@Override
	public List<Student> findStudents(String searchRow, String searchKey,
			String state) throws Exception {
		Logger log = LogManager.getRootLogger();
		log.info("数据库中state:" + state + ",searchRow:" + searchRow
				+ ",searchKey:" + searchKey);
		List<Student> list = null;
		try {
			if (searchRow.equals("姓名")) {
				// 按照姓名查找
				String sql = "select * from student where Student_Name = ? and Student_State = ?";
				if(searchKey == null || "".equals(searchKey)){
					sql = "select * from student";
					list = this.getJdbcTemplate().query(sql,new StudentWrapper());
					return list;
				}
				list = this.getJdbcTemplate()
						.query(sql, new Object[] { searchKey, state },
								new StudentWrapper());
				System.out.println("list的大小：" + list.size());
				return list;
			} else if (searchRow.equals("学号")) {
				String sql = "select * from student where Student_Username = ? and Student_State = ?";
				list = this.getJdbcTemplate()
						.query(sql, new Object[] { searchKey, state },
								new StudentWrapper());
				return list;
			} else {
				// 按照班级查找
				String sql = "select * from student where Student_Class = ? and Student_State = ?";
				list = this.getJdbcTemplate()
						.query(sql, new Object[] { searchKey, state },
								new StudentWrapper());
				return list;
			}
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();
		}
	}

	@Override
	public List<Student> findStudentsByState(String state) throws Exception {
		String sql = "select * from student where Student_State = ?";
		List<Student> list = null;
		try {
			list = this.getJdbcTemplate().query(sql, new Object[] { state },
					new StudentWrapper());
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
	public Student findById(int student_ID) throws Exception {
		String sql = "select * from student where Student_ID = ?";
		try {
			Student s = (Student) this.getJdbcTemplate().queryForObject(sql,
					new Object[] { student_ID }, new StudentWrapper());
			return s;
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			throw new DaoException();

		}
	}

	@Override
	public void update(Student student) throws Exception {
		Logger log = LogManager.getRootLogger();
		System.out.println("update中的student是："+student.getStudent_State());
		log.info("数据库中：" + student.getStudent_Username() + ","
				+ student.getStudent_Password() + ","
				+ student.getStudent_Name() + "," + student.getStudent_Sex()
				+ "," + student.getStudent_State());
		if (student.getStudent_Password().equals("")
				|| student.getStudent_Password() == null) {
			String sql = "update student set Student_Username = ?,"
					+ "Student_Name = ?,Student_Sex = ?,Student_Class = ?,Student_State = ? where Student_ID = ?";
			this.getJdbcTemplate()
					.update(sql,
							new Object[] { student.getStudent_Username(),
									student.getStudent_Name(),
									student.getStudent_Sex(),
									student.getStudent_Class(),
									student.getStudent_State(),
									student.getStudent_ID() });
		} else {
			String sql = "update student set Student_Username = ?,Student_Password = ?,"
					+ "Student_Name = ?,Student_Sex = ?,Student_Class = ?,Student_State = ? where Student_ID = ?";
			this.getJdbcTemplate()
					.update(sql,
							new Object[] { student.getStudent_Username(),
									student.getStudent_Password(),
									student.getStudent_Name(),
									student.getStudent_Sex(),
									student.getStudent_Class(),
									student.getStudent_State(),
									student.getStudent_ID() });
		}

	}

	@Override
	public void delete(int student_ID) throws Exception {
		String sql = "delete from student where Student_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{student_ID});
	}

	@Override
	public void studentRZ(String student_Username,int domitoryID) throws Exception {
		System.out.println("StudentDAOImpl:domitoryID -->"+domitoryID+",student_Username-->"+student_Username);
		String sql = "update student set Student_DomitoryID = ?,Student_State = ? where Student_Username = ?";
		this.getJdbcTemplate().update(sql, new Object[]{domitoryID,"入住",student_Username});
	}

	@Override
	public Student findByName(String student_Username) throws Exception {
		System.out.println("studentDAOImpl:"+student_Username);
		String sql = "select * from student where Student_Username = ?";
		Student student = null;
		try{
			//student = (Student) this.getJdbcTemplate().queryForObject(sql, new Object[]{student_Username}, new StudentWrapper());
			List<Student> list = this.getJdbcTemplate().query(sql, new Object[]{student_Username},new StudentWrapper());
			student = list.get(0);
		}catch(Exception e){
			System.out.println("fjdslafjd");
				return null;
		}

		return student;
	}

	@Override
	public void THSave(Student student) throws Exception {
		String sql = "update student set Student_DomitoryID =? where Student_ID = ?";
		this.getJdbcTemplate().update(sql,new Object[]{student.getDomitory_ID(),student.getStudent_ID()});
	}

	@Override
	public void upatePassword(Student s, String password2) throws Exception {
		String sql = "update student set Student_Password = ? where Student_ID = ?";
		this.getJdbcTemplate().update(sql, new Object[]{password2,s.getStudent_ID()});
	}

	@Override
	public boolean checkPasswor(Object obj, String password) throws Exception {
		if(obj instanceof Admin){
			Admin a = (Admin)obj;
			return a.getAdmin_Password().equals(password);
		}
		if(obj instanceof Teacher){
			Teacher t = (Teacher)obj;
			return t.getTeacher_Password().equals(password);
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			return s.getStudent_Password().equals(password);
		}
		return false;
	}

	@Override
	public List<Student> findByBuildingId(int building_ID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
